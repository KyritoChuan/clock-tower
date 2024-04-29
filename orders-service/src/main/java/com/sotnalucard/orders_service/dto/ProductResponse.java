package com.sotnalucard.orders_service.dto;

//A diferencia de una clase normal, record es inmutable (una vez inicializado, no se puede modificar).
public record ProductResponse(Long id, String sku, Double price, Long quantity) {
}
