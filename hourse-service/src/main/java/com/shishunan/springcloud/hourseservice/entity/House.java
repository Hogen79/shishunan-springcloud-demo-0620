package com.shishunan.springcloud.hourseservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "t_house")
@Data
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer province;
    private Integer city;
    private Integer county;
    private String community;
    private Integer room;
    private Integer hall;
    private Integer toilet;
    private String orientation;
    private String decorate;
    private BigDecimal rent;
    private String pic;
    private String introduction;


}
