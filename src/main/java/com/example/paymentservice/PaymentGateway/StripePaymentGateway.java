package com.example.paymentservice.PaymentGateway;

import com.stripe.Stripe;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.exception.*;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway {

    @Value("stripe.secret.key")
    private String stripeSecretKey;
    @Override
    public String getLink(Long amount) throws StripeException{

        Stripe.apiKey = "sk_test_51ONYUKSGqdSmVi6jxmLUSa2vo8p3dJcqS8vlA9vHLePcN6ggo2Z4qvW5D9oM6cyntQx0eS6aCv1UUmXKIzJlTqCS00OQfqVToZ";
        ProductCreateParams paramsProduct =
                ProductCreateParams.builder().setName("Gold Plan").build();
        Product product = Product.create(paramsProduct);


        PriceCreateParams paramsPrice =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(amount)
                        .setProduct(product.getId())
                        .build();

        Price price = Price.create(paramsPrice);

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);
        return paymentLink.getUrl();
    }
}
