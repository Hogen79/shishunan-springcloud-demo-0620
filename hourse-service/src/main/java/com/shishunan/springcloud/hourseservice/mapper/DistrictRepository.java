package com.shishunan.springcloud.hourseservice.mapper;

import com.shishunan.springcloud.hourseservice.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District,Integer>, JpaSpecificationExecutor<District> {
    List<District> findByparent(Integer parent);
}
