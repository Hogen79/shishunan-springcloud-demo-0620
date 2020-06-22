package com.shishunan.springcloud.hourseservice.controller;

import com.shishunan.springcloud.hourseservice.entity.District;
import com.shishunan.springcloud.hourseservice.entity.House;
import com.shishunan.springcloud.hourseservice.entity.HouseTerm;
import com.shishunan.springcloud.hourseservice.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HoustController {


    @Autowired
    HouseService houseService;


    @RequestMapping("/list")
    public List<District> list(){

        return houseService.list(0);
    }

    @RequestMapping("/getcityById")
    public List<District> getcityById(Integer id){

        return houseService.findByparent(id);
    }
    @RequestMapping("/insert")
    public boolean insertHouse(@RequestBody House house){
        System.err.println("/insert---------"+house);
        return houseService.insertHouse(house);
    }
    @RequestMapping("/houselist")
    public Page<House> pageInfo(HouseTerm houseTerm, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum, @RequestParam(value = "pageSize")Integer pageSize){
        System.err.println("/houselist-----------"+houseTerm);
        return houseService.getHouseList(houseTerm,pageNum,pageSize);
    }
    @RequestMapping("/listall")
    public List<House> listall(){
        return houseService.listall();
    }
    @RequestMapping("/update")
    public boolean updateHouse(@RequestBody House house){
        return houseService.updateHouse(house);
    }
    @RequestMapping("/delete")
    public boolean deleteHouse(String ids){
        return houseService.deleteHouse(ids);
    }


}
