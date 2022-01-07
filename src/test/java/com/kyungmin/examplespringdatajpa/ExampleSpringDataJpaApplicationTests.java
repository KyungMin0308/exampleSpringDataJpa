package com.kyungmin.examplespringdatajpa;

import com.kyungmin.examplespringdatajpa.entity.Product;
import com.kyungmin.examplespringdatajpa.repository.ProductRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class) // to run tests in order
class ExampleSpringDataJpaApplicationTests {
    
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Order(1)
    public void findProductById() {
        Optional<Product> product = productRepository.findById(1L);
        assertNotNull(product.get()); //null이 되면 안됨 -> null이라면 테스트 실패
    }

    @Test
    @Order(2)
    public void findAllProducts() {
        List<Product> products = productRepository.findAll();
        assertNotNull(products);
    }

    @Test
    @Order(3)
    public void createProduct() {
        Product product = new Product("OLED TV", "LG전자", "korea", 300.0);
        Product savedProduct = productRepository.save(product);

        Product newProduct = productRepository.findById(savedProduct.getId()).get();
        assertEquals("OLED TV", newProduct.getName());
    }

    @Test
    @Order(4)
    public void findByName() {
        Product product = productRepository.findByName("Galaxy S21");
        assertEquals("Galaxy S21", product.getName());
    }

    @Test
    @Order(5)
    public void findByNameContainingWithPaging() {

        Pageable paging = PageRequest.of(0, 3);
        List<Product> productList = productRepository.findByNameContaining("MacBook", paging); //MacBook이 들어간 레코드 찾기

        System.out.println("====findByNameContainingWithPaging: Macbook=====");
        for (Product product : productList) {
            System.out.println("-->" + product.toString() );
        }
    }

    @Test
    @Order(6)
    public void findByNameContainingWithPagingAndSort( ) {

        Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "id");
        List<Product> productList = productRepository.findByNameContaining("Galaxy", paging);

        System.out.println("===findByNameContainingWithPagingAndSort: Galaxy====");
        for (Product product : productList) {
            System.out.println("-->" + product.toString() );
        }
    }

    @Test
    @Order(7)
    public void searchByNameUsingQuery() {
        List<Product> productList= productRepository.searchByName("Air");

        System.out.println(" ====searchByNameUsingQuery: Air======");
        for (Product product : productList) {
            System.out.println("-->" + product.toString() );
        }
    }
}
