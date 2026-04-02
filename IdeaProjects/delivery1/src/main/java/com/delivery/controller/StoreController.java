package com.delivery.controller;

import com.delivery.domain.Store;
import com.delivery.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreController {

    //StoreService 이용해 가져온 데이터를 이 컨트롤러 안에서 사용하겠다
    private final StoreService storeService;

    //생성자 : StoreController는 StoreService 없이는 동작 못 함
    //-> 스프링이 알아서 생성하도록
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/stores")
    public List<Store> stores(){
        return storeService.getStores();
    }
}
