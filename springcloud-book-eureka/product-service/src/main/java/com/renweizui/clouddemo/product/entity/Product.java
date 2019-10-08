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
 * 商品信息实体
 *
 * @PackageName:weizuiren.cloud.weizuirencloudsboot.product.entity
 * @ClassName:Product
 * @Description:
 * @Author: justin zheng
 * @Date: 2019/9/23 10:19
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    /**商品主键ID*/
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品封面图片
     */
    private String coverImage;
    /**
     * 商品价格（分）
     */
    private Integer price;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", price=" + price +
                '}';
    }


}
