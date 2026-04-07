package com.delivery.controller;

import com.delivery.domain.Menu;
import com.delivery.domain.Store;
import com.delivery.service.MenuService;
import com.delivery.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreController {

    //StoreService 이용해 가져온 데이터를 이 컨트롤러 안에서 사용하겠다
    private final StoreService storeService;
    private final MenuService menuService;

    //생성자 : StoreController는 StoreService 없이는 동작 못 함
    //-> 스프링이 알아서 생성하도록
    public StoreController(StoreService storeService, MenuService menuService) {
        this.storeService = storeService;
        this.menuService = menuService;
    }

    @GetMapping("/stores")
    public List<Store> stores(){
        System.out.println("stores 컨트롤러>>>> " );
        return storeService.getStores();
    }

    @GetMapping("/stores/{storeId}/menus")
    public List<Menu> menus(@PathVariable Integer storeId){
        System.out.println("getMenusByStoreId 컨트롤러>>>> "+ storeId );
        return  menuService.getMenusByStoreId(storeId);
    }
}
