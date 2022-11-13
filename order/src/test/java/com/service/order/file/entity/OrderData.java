package com.service.order.file.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderData {
    private final int orderId;
    private final String name;
    private final String address;
    private final String request;
    private final int productKey;
}