package com.delivery.service;

import com.delivery.domain.Menu;
import com.delivery.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    public List<Menu> getMenusByStoreId(Integer storeId) {
        System.out.println("getMenusByStoreId 서비스>>>> ");
        return menuRepository.findByStoreId(storeId);
    }
}
