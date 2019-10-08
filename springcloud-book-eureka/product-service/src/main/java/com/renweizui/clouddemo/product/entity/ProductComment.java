package com.renweizui.clouddemo.product.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 商品评论实体
 *
 * @PackageName:weizuiren.cloud.weizuirencloudsboot.product.entity
 * @ClassName:ProductComment
 * @Description:
 * @Author: justin zheng
 * @Date: 2019/9/23 10:25
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_product_comment")
public class ProductComment implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue
    /**商品评论主键ID*/
    private Long id;
    /**
     * 所属商品Id
     */
    private Long productId;
    /**
     * 评论作者Id
     */
    private Long authorId;
    /**
     * 评论具体内容
     */
    private String content;
    /**
     * 评论创建时间
     */
    private Long createTime;

    @Override
    public String toString() {
        return "ProductComment{" +
                "id=" + id +
                ", productId=" + productId +
                ", authorId=" + authorId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
