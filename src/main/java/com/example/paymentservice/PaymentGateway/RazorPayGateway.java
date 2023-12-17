package com.example.paymentservice.PaymentGateway;

import com.stripe.exception.StripeException;

public class RazorPayGateway implements PaymentGateway{
    @Override
    public String getLink(Long amount) throws StripeException {
        return null;
    }
}
