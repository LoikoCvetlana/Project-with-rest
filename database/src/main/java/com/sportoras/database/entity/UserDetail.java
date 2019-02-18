package com.sportoras.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@ToString(exclude = "user")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Entity
@Builder
@Table(name = "user_dateil", schema = "oraz_storage")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company")
    private String company;

    @Column(name = "position")
    private String position;

    @Column(name = "phone")
    private String phone;

    @Column(name = "other_information")
    private String otherInformation;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    public UserDetail(User user, String company, String phone) {
        this.user = user;
        this.company = company;
        this.phone =phone;
    }

    public UserDetail(User user, String company, String phone, String otherInformation) {
        this.user = user;
        this.company = company;
        this.phone =phone;
        this.otherInformation = otherInformation;
    }
    public UserDetail(Long id, User user, String company, String phone, String otherInformation) {
        this.id= id;
        this.user = user;
        this.company = company;
        this.phone =phone;
        this.otherInformation = otherInformation;
    }

}
