package com.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeliveryApplication {

    //스프링부트의 앱의 시작점
    /*즉 이 클래스가 실행되면서:
    StoreController를 찾고
    StoreService를 만들고
    StoreRepository를 만들고
    필요한 객체를 자동 연결해서
    /stores 요청을 받을 준비를 끝내는 거예요.
    * */
    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }


}
