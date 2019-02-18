//package com.sportoras.database.entity;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//@ToString
//@Data
//@EqualsAndHashCode(of = "id")
//@AllArgsConstructor(staticName = "of")
//@NoArgsConstructor
//@Builder
//@Entity
//@Table(name = "order", schema = "oraz_storage")
//public class Order extends BaseEntity{
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    private LocalDate date;
//
//    @Column(name = "desire_date")
//    private LocalDate desireDate;
//
//    @OneToMany
//    private Set<ProductInOrder> productInOrders = new HashSet<>();
//
//}
//
