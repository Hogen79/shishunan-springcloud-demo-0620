package com.shishunan.springcloud.hourseservice.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HouseTerm {
    private double price1;
    private double price2;
    private Integer cid;
    private Integer xid;
    private Integer room;
}
