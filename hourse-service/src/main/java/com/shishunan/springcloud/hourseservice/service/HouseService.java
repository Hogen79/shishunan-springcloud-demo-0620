package com.shishunan.springcloud.hourseservice.service;

import com.shishunan.springcloud.hourseservice.entity.District;
import com.shishunan.springcloud.hourseservice.entity.House;
import com.shishunan.springcloud.hourseservice.entity.HouseTerm;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface HouseService {
    List<District> list(Integer parent);

    List<District> findByparent(Integer id);

    boolean insertHouse(House house);

    Page<House> getHouseList(HouseTerm houseTerm, Integer pageNum, Integer pageSize);

    List<House> listall();

    boolean updateHouse(House house);

    boolean deleteHouse(String ids);
}
