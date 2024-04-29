package com.sotnalucard.orders_service.models;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder //Buildear desde DTO a Entity
public class Orders implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "orderNumber")
    private String orderNumber;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Product> products;
}
