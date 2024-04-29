package com.sotnalucard.orders_service.dto;

import java.util.List;

//A diferencia de una clase normal, record es inmutable (una vez inicializado, no se puede modificar).
public record OrderResponse(Long id, String orderNumber, List<ProductResponse> products) {
}

