package com.ysl.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    //One
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String userMail;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<SaleAdvertisement> saleAdvertisementList;



}
