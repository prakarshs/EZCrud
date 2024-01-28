package com.ezcrud.OrderService.Services;

import com.ezcrud.OrderService.Entities.Orders;
import com.ezcrud.OrderService.Errors.CustomError;
import com.ezcrud.OrderService.External.Classes.PaymentRequest;
import com.ezcrud.OrderService.External.Classes.Payments;
import com.ezcrud.OrderService.External.Classes.Stocks;
import com.ezcrud.OrderService.External.Clients.PaymentService;
import com.ezcrud.OrderService.External.Clients.StockService;
import com.ezcrud.OrderService.Models.*;
import com.ezcrud.OrderService.Repositories.OrderServiceRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.UUID;

@Service
@Log4j2
public class OrderServiceIMPL implements OrderService{

    @Autowired
    private OrderServiceRepository orderServiceRepository;

    @Autowired
    private StockService stockService;
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public OrderResponse addCart(OrderRequest orderRequest) {
        log.info("VALIDATING ORDER STOCKID...");
        Stocks stocks;
        try {
            stocks = restTemplate.getForObject("http://localhost:8080/stocks/show/"+orderRequest.getStockId(), Stocks.class);
        }catch(Exception e){
            log.info("STOCK NOT FOUND.");
            throw new CustomError(Constants.STOCK_ID_DOESNT_EXIST,Constants.TRY_WITH_A_DIFFERENT_STOCKID);
        }

        Orders orders;

        assert stocks != null;
        if(orderRequest.getOrderQuantity() <= stocks.getStockQuantity()){
            orders = Orders.builder()
                    .orderRefCode(UUID.randomUUID().toString())
                    .stockId(stocks.getStockId())
                    .orderQuantity(orderRequest.getOrderQuantity())
                    .orderTime(Instant.now())
                    .orderStatus(Constants.ADDED_TO_CART)
                    .build();
            orderServiceRepository.save(orders);
            log.info("ADDED TO CART!");
        }
        else {
            throw new CustomError(Constants.INSUFFICIENT_STOCK,Constants.TRY_WITH_A_LESSER_AMOUNT);
        }
        return OrderResponse.builder()
                .message("STOCK ADDED TO CART!")
                .orderId(orders.getOrderId())
                .orderRefCode(orders.getOrderRefCode())
                .stockId(orders.getStockId())
                .orderQuantity(orders.getOrderQuantity())
                .orderTime(orders.getOrderTime())
                .orderStatus(orders.getOrderStatus())
                .build();
    }



    @Override
    public OrderShow show(Long orderId) {
        log.info("VALIDATING ORDERID...");
        Orders orders = orderServiceRepository.findById(orderId).orElseThrow(()-> new CustomError(Constants.ORDER_ID_DOESNT_EXIST,Constants.TRY_WITH_A_DIFFERENT_ORDER_ID));

        log.info("LOOKING UP STOCK..");
        Stocks stocks = restTemplate.getForObject("http://localhost:8080/stocks/show/"+orders.getStockId(),Stocks.class);

        log.info("FETCHING PAYMENT...");
        Payments payments = restTemplate.getForObject("http://localhost:8082/payments/show/"+orders.getPaymentId(),Payments.class);

        return OrderShow.builder()
                .message("Here's Your Order Details : ")
                .orderDetails(orders)
                .orderedStockDetails(stocks)
                .paymentDetails(payments)
                .build();
    }

    @Override
    public OrderResponse place(PlaceOrderRequest placeOrderRequest) {
        log.info("VALIDATING ORDER-REFERENCE-CODE...");
        Orders orders;
        try {
            orders = orderServiceRepository.findByorderRefCode(placeOrderRequest.getOrderRefCode());
        }catch (Exception e){
            throw new CustomError(Constants.REFERENCE_CODE_DOESNT_EXIST, Constants.TRY_WITH_A_DIFFERENT_REFERENCE_CODE);
        }

        log.info("LOOKING UP STOCK...");
        Stocks stocks = restTemplate.getForObject("http://localhost:8080/stocks/show/"+orders.getOrderId(),Stocks.class);


        log.info("REDUCING ORDER-QUANTITY...");
        stockService.reduce(orders.getStockId(), orders.getOrderQuantity());

        log.info("MAKING PAYMENTS FROM ORDER...");
        assert stocks != null;
        paymentService.make(PaymentRequest.builder()
                .orderId(orders.getOrderId())
                .orderRefCode(orders.getOrderRefCode())
                .paymentMode(placeOrderRequest.getPaymentMode())
                .paymentAmount(orders.getOrderQuantity() * stocks.getStockPrice())
                .build());

        log.info("FETCHING PAYMENTS...");
        Payments payments = restTemplate.getForObject("http://localhost:8082/payments/show/"+orders.getOrderId(),Payments.class);

        orders.setOrderStatus(Constants.PLACED);
        orders.setPaymentId(payments.getPaymentId());

        orderServiceRepository.save(orders);
        return OrderResponse.builder()
                .message("YOUR ORDER IS PLACED !")
                .orderId(orders.getOrderId())
                .orderRefCode(orders.getOrderRefCode())
                .stockId(orders.getStockId())
                .paymentId(orders.getPaymentId())
                .orderQuantity(orders.getOrderQuantity())
                .orderTime(orders.getOrderTime())
                .orderStatus(orders.getOrderStatus())
                .build();
    }
}
