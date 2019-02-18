package com.sportoras.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Data
@Builder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@Table(name = "material", schema = "oraz_storage")
public class Material extends BaseEntity<Long> {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    private String description;

    @OneToMany(fetch= FetchType.EAGER)
    @JsonIgnore
    private List<Product> products;

    public Material(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Material(Long id, String name, String description, List<Product> products) {
        super();
        this.name = name;
        this.description = description;
        this.products = products;
    }
}

