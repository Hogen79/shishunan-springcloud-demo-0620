package com.shishunan.springcloud.hourseservice.service.impl;

import com.shishunan.springcloud.hourseservice.entity.District;
import com.shishunan.springcloud.hourseservice.entity.House;
import com.shishunan.springcloud.hourseservice.entity.HouseTerm;
import com.shishunan.springcloud.hourseservice.mapper.DistrictRepository;
import com.shishunan.springcloud.hourseservice.mapper.HouseRepository;
import com.shishunan.springcloud.hourseservice.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    DistrictRepository districtRepository;

    @Override
    public List<District> list(Integer parent) {
        return districtRepository.findByparent(parent);
    }

    @Override
    public List<District> findByparent(Integer id) {
        return districtRepository.findByparent(id);
    }

    @Override
    public boolean insertHouse(House house) {
        House save = houseRepository.save(house);
        return save!=null;
    }

    @Override
    public Page<House> getHouseList(HouseTerm houseTerm, Integer pageNum, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Specification<House> specification = new Specification() {

            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<>();
                if(houseTerm.getPrice1()!=0){
                    Predicate predicate=cb.between(root.get("rent"),houseTerm.getPrice1(),houseTerm.getPrice2());
                    predicates.add(predicate);
                }
                if(houseTerm.getXid()!=0){
                    Predicate predicate=cb.equal(root.get("county"),houseTerm.getXid());
                    predicates.add(predicate);
                }else if(houseTerm.getXid()==0){
                    Predicate predicate=cb.equal(root.get("city"),houseTerm.getCid());
                    predicates.add(predicate);
                }
                if(houseTerm.getRoom()!=0){
                    Predicate predicate=cb.equal(root.get("room"),houseTerm.getRoom());
                    predicates.add(predicate);
                }
                //返回的接口
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));


            }
        };
        return houseRepository.findAll(specification,pageable);
    }

    @Override
    public List<House> listall() {
        return houseRepository.findAll();
    }

    @Override
    public boolean updateHouse(House house) {
        return houseRepository.save(house)!=null;
    }

    @Override
    public boolean deleteHouse(String ids) {
        String[] split = ids.split(",");
        for (String id : split) {
            houseRepository.deleteById(Integer.parseInt(id));
        }
        return true;
    }
}
