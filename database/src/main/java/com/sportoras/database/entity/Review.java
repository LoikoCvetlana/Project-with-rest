package com.sportoras.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

import static org.hibernate.jpamodelgen.xml.jaxb.FetchType.EAGER;

@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = "user")
@NoArgsConstructor
@Builder
@Entity
@Table(name = "review", schema = "oraz_storage")
@AllArgsConstructor
public class Review extends BaseEntity<Long> {

    @Version
    private long version;


    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    private LocalDate date;

    public Review(User user, String text, LocalDate date) {
        this.user = user;
        this.text = text;
        this.date = date;
    }
}
