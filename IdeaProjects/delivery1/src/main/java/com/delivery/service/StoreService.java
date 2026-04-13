package com.delivery.service;

import com.delivery.domain.Store;
import com.delivery.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class StoreService {
    //StoreRepository를 이용해 가져온 데이터를 이 서비스 안에서 사용하겠다
    private final StoreRepository storeRepository;

    //생성자: 스프링이 알아서 StoreRepository를 넣어서 StoreService를 생성하도록
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    //가게 목록 전체를 조회하여 리스트로 반환
    public List<Store> getStores() {
        System.out.println("stores 서비스 >>>> " );
        //findAll = select * from store
        return storeRepository.findAll();
    }

}
