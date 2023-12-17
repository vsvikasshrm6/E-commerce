package com.example.paymentservice.PaymentGateway;

import com.stripe.exception.StripeException;

public interface PaymentGateway {

    public String getLink(Long amount) throws StripeException;
}
