package com.shishunan.springcloud.hourseservice.entity;

import lombok.Data;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="t_district")
@Data
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer parent;
    @OneToMany
    @JoinColumn(name = "parent")
    private List<District> districtList;

}
