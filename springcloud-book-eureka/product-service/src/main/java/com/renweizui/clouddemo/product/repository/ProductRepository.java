package com.renweizui.clouddemo.product.repository;

import com.renweizui.clouddemo.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品信息Repository
 *
 * @author weizuiren
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
