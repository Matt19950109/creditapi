package com.weavus.api.credit.controller;

import com.weavus.api.credit.dao.CreditInfoDao;
import com.weavus.api.credit.dto.CreditInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditController {

    @Autowired
    private CreditInfoDao creditInfoDao;

    @GetMapping("/")
    public String init(){
        return "Hello World";
    }

    @PostMapping("/creditInfo")
    public CreditInfo saveCreditInfo(@RequestBody CreditInfo creditInfo){

        CreditInfo info = creditInfoDao.save(creditInfo);
        return info;
    }

    @PatchMapping("/creditInfo")
    public CreditInfo updateCreditInfo(@RequestBody CreditInfo creditInfo){

        CreditInfo info = creditInfoDao.save(creditInfo);
        return info;
    }

    @GetMapping("/creditInfo/{id}")
    public CreditInfo getCreditInfo(@PathVariable String id){

        CreditInfo info = creditInfoDao.findById(id).orElse(null);
        return info;
    }

    @PatchMapping("/payment/id/{id}/price/{price}")
    public ResponseEntity<String> payment(@PathVariable String id,@PathVariable long price){

        CreditInfo info = creditInfoDao.findById(id).orElse(null);
        long updateSiyoGaku = info.getSiyoGaku() + price;
        if(info.getGendoGaku() < info.getSiyoGaku() + price){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("限度額が足りません");
        } else{
            info.setSiyoGaku(updateSiyoGaku);

            creditInfoDao.save(info);
            return ResponseEntity.status(HttpStatus.OK).body("さてはD払いだね");
        }
    }


}
