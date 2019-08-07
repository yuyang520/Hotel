package com.javaee.hotel.service;


import com.javaee.hotel.domain.*;
import com.javaee.hotel.mapper.CustomerInfoMapper;
import com.javaee.hotel.mapper.CustomerMapper;
import com.javaee.hotel.mapper.PriceChangeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class PriceChangeService {

    @Autowired
    private PriceChangeMapper priceChangeMapper;

    public List<PriceChange> priceChangeRespond(){
        PriceChangeExample priceChange = new PriceChangeExample();
        return priceChangeMapper.selectByExample(priceChange);
    }


    public Integer savePriceChange(PriceChange priceChange){

        if(priceChange.getPriceChangeId()== null){
            return  priceChangeMapper.insert(priceChange);
        }else {
            if(priceChangeMapper.selectByPrimaryKey(priceChange.getPriceChangeId()) == null ) {
                return -1;
            }
            return priceChangeMapper.updateByPrimaryKey(priceChange);
        }


    }

    public PriceChange findPriceChangeByPrimaryKey(String PriceChangeId){

        return priceChangeMapper.selectByPrimaryKey(PriceChangeId);
    }


    public void deletePriceChangeById(String PriceChangeId) {

        priceChangeMapper.deleteByPrimaryKey(PriceChangeId);
    }
}
