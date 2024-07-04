package com.sofrecom.prix.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ServersAndDevicesPrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int euroPrice;
    private int usdPrice;
    private String name ;
    private String descr;
    @Enumerated(EnumType.STRING)
    private ServerType type;




}
