package com.delivery.repository;

import com.delivery.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
/*
* JpaRepository는 스프링 데이터 JPA가 제공하는 인터페이스인데,
이걸 상속하면 기본 CRUD 메서드들을 자동으로 쓸 수 있게 됩니다.

예를 들면 직접 구현하지 않아도 이런 메서드들을 바로 쓸 수 있어요.

findAll()
findById()
save()
deleteById()
count()

즉 SQL을 직접 안 써도 기본적인 DB 작업이 가능해집니다.
*
* */

}
