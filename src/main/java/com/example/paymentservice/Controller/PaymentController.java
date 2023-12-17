package com.example.paymentservice.Controller;

import com.example.paymentservice.DTO.PaymentLinkRequestDTO;
import com.example.paymentservice.Service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String getPaymentLink(@RequestBody PaymentLinkRequestDTO paymentLinkRequestDTO) throws StripeException {
        return paymentService.getPaymentLink(paymentLinkRequestDTO.getPrice());
    }
}
