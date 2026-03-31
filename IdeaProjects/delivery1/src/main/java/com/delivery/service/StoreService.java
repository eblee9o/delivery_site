package com.delivery.service;

import com.delivery.repository.StoreRepository;
import com.delivery.domain.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
    public List<Store> getStores() {
        return storeRepository.findAll();
    }
}
