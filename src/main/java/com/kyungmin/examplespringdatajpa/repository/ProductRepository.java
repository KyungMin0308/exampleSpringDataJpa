package com.kyungmin.examplespringdatajpa.repository;

import com.kyungmin.examplespringdatajpa.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //특별한 코드 없이도 CRUD 기능이 모두 구현됨

    //이름만 선언하면 자동으로 sql문이 생성(이름 생성 규칙: findBy~)
    Product findByName(String name);
    List<Product> findByNameContaining(String searchKeyword, Pageable paging);

    //@Query Annotation 사용
    @Query("select p from Product p where p.name like %?1%")
    List<Product> searchByName(String name); //sql을 자동으로 생성해줌
}
