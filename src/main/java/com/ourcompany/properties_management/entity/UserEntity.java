package com.ourcompany.properties_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "USER_TABLE")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(name="EMAIL", nullable = false)
    private  String ownerEmail;
    private  String ownerName;
    private  String phone;
    private String password;

}
