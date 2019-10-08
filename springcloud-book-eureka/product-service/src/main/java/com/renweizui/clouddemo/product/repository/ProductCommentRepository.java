package com.renweizui.clouddemo.product.repository;

import com.renweizui.clouddemo.product.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品评论信息Repository
 *
 * @author weizuiren
 */
public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {

    /**
     * 查询指定商品的评论列表，按创建时间排序
     * @param productId 指定商品主键ID
     * @return 评论列表
     */
    List<ProductComment> findByProductIdOrderByCreateTime(Long productId);

}
