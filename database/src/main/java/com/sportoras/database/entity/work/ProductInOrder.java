//package com.sportoras.database.entity;
//
//import lombok.*;
//
//import javax.persistence.Entity;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@ToString
//@Data
//@EqualsAndHashCode(of = "id")
//@AllArgsConstructor(staticName = "of")
//@NoArgsConstructor
//@Builder
//@Entity
//@Table(name = "product_in_order", schema = "oraz_storage")
//public class ProductInOrder extends BaseEntity {
//
//    @ManyToOne
//    private Order order;
//
//    private Product product;
//
//    private Integer counter;
//
//}