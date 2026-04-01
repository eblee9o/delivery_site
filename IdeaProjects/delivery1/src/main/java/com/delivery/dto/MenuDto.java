package com.delivery.dto;

public class MenuDto {
    private Long id;
    private Long storeId;
    private String name;
    private int price;

    public MenuDto(Long id, Long storeId, String name, int price) {
        this.id = id;
        this.storeId = storeId;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
