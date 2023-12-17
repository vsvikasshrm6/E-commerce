package com.example.paymentservice.Service;

import com.example.paymentservice.PaymentGateway.PaymentGateway;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    PaymentService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    public String getPaymentLink(Long price) throws StripeException {
        //For any payment gateway we require id , name phonenumber
        //Payment service can call userservice or order service
        //Can be userservice service if userservice table has order id
        //Payment service will call user service for all user details
        //Via rest template
       return paymentGateway.getLink(price);
    }
}
