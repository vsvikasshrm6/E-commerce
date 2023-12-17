package com.example.paymentservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentLinkRequestDTO {
    private Long orderId;
    private Long price;
    //We have used String order id
}
