package com.sotnalucard.products_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder //Buildear desde Entity a DTO
public class ProductRequest {
//    @ApiModelProperty(example = "")
    private String sku;

    private String name;

    private String description;

    private Double price;

    private Boolean status;
}
