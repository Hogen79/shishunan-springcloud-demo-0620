package com.shishunan.springcloud.hourseservice.mapper;

import com.shishunan.springcloud.hourseservice.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HouseRepository extends JpaRepository<House,Integer>, JpaSpecificationExecutor<House> {

}
