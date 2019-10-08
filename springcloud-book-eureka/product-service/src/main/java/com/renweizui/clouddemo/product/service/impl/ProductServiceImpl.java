package com.renweizui.clouddemo.product.service.impl;

import com.renweizui.clouddemo.product.entity.Product;
import com.renweizui.clouddemo.product.entity.ProductComment;
import com.renweizui.clouddemo.product.repository.ProductCommentRepository;
import com.renweizui.clouddemo.product.repository.ProductRepository;
import com.renweizui.clouddemo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author justin.zheng
 * @date 2019/9/26 10:05
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCommentRepository productCommentRepository;


    @Override
    public Page<Product> getPage(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    @Override
    public Product load(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProductComment> findAllCommentsByProduct(Long productId) {
        return this.productCommentRepository.findByProductIdOrderByCreateTime(productId);
    }
}
