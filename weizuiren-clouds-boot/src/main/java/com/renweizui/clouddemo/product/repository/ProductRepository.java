package com.renweizui.clouddemo.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.renweizui.clouddemo.product.entity.Product;

/**
 * 商品信息Repository
 *
 * @author weizuiren
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
