package com.sportoras.database.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class BaseEntity<P> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private P id;
}