package com.delivery.dto;

public class OrderResponse {
    private String message;
    private Long storeId;
    private Long menuId;
    private int quantity;

    public OrderResponse(int quantity, Long menuId, Long storeId, String message) {
        this.quantity = quantity;
        this.menuId = menuId;
        this.storeId = storeId;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
