package com.sofrecom.prix.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@Entity

public class ServicesPrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;
    private String name;
    private String provider;
    private  int price ;
@Enumerated(EnumType.STRING)
    private Services serviceType;

}
