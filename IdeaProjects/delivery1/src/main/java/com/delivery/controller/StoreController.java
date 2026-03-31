package com.delivery.controller;

import com.delivery.domain.Store;
import com.delivery.service.StoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

//    @GetMapping("/stores")
//    public List<Map<String, Object>> stores(){

//        List<Map<String, Object>> list = new ArrayList<>();
//
//        Map<String, Object> storeInfo1 = new HashMap<>();
//        storeInfo1.put("id", 1);
//        storeInfo1.put("name", "네네치킨");
//        list.add(storeInfo1);
//
//        Map<String, Object> storeInfo2 = new HashMap<>();
//        storeInfo2.put("id", 2);
//        storeInfo2.put("name", "메가커피");
//        list.add(storeInfo2);
//
//        Map<String, Object> storeInfo3 = new HashMap<>();
//        storeInfo3.put("id", 3);
//        storeInfo3.put("name", "알라딘마라탕");
//        list.add(storeInfo3);
//
//        return list;
//
//    }
//    }
    private final StoreService storeService;

    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @GetMapping("/stores")
    public List<Store> stores(){
        return storeService.getStores();
    };

}
