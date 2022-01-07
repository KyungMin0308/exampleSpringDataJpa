package com.kyungmin.examplespringdatajpa.service;

import com.kyungmin.examplespringdatajpa.entity.Product;
import com.kyungmin.examplespringdatajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repo;

    //ID에 해당하는 Product 조회
    public Product get(long id) { //C
        return repo.findById(id).get();
    }

    //전체 Product 조회
    public List<Product> listAll() { //R
        return repo.findAll();
    }

    //새로운 Product 저장
    public void save(Product product) { //U
        repo.save(product);
    }

    //ID에 해당하는 Product 삭제
    public void delete(long id) { //D
        repo.deleteById(id);
    }
}
