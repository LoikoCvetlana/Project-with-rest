package com.sportoras.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@ToString
@Builder
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "oraz_storage")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Role")
public class User extends BaseEntity<Long> {

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Embedded
    private FullName fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToOne(mappedBy = "user", fetch=FetchType.EAGER)
    private UserDetail userDetail;

    @Column(name = "role")
    private String role;

    @JsonIgnore
    @OneToMany (fetch=FetchType.EAGER)
    private List<Review> reviews;

      public User(String email, String password, FullName fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}