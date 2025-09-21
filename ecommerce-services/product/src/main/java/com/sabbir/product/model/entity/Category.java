package com.sabbir.product.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;

    private String description;

//    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "category", fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Product> products; // OneToMany relationship with Product class (Many products can belong to one category>
}
