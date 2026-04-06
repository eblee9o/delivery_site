package com.delivery.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
/* create table menu (
    id serial primary key,
    store_id integer not null,
    name varchar(100) not null,
    price integer not null,
    amount integer not null,
    image_url varchar(500),
    constraint fk_menu_store
        foreign key (store_id)
        references store(id)
        on delete cascade
);*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "store_id", nullable = false)
    private Integer storeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer amount;

    @Column(name = "image_url")
    private String imageUrl;

    public Menu() {
    }

    public Menu(Integer id, Integer storeId, String name, Integer price, Integer amount, String imageUrl) {
        this.id = id;
        this.storeId = storeId;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}