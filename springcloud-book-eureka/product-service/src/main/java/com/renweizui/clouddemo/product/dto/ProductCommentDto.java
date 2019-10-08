package com.renweizui.clouddemo.product.dto;

import com.renweizui.clouddemo.product.entity.ProductComment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 商品评论信息包
 *
 * @author justin zheng
 * @date 2019/9/23 10:25
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel
public class ProductCommentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品评论主键ID
     */
    @ApiModelProperty(value = "商品评论主键ID")
    private Long id;
    /**
     * 所属商品
     */
    @ApiModelProperty(value = "所属商品")
    private ProductDto productDto;
    /**
     * 评论作者
     */
    @ApiModelProperty(value = "评论作者")
    private UserDto userDto;
    /**
     * 评论具体内容
     */
    @ApiModelProperty(value = "评论具体内容")
    private String content;
    /**
     * 评论创建时间
     */
    @ApiModelProperty(value = "评论创建时间")
    private Long createTime;

    public ProductCommentDto(ProductComment productComment) {
        if (productComment != null) {
            this.id = productComment.getId();
            this.content = productComment.getContent();
            this.createTime = productComment.getCreateTime();
        }
    }

    @Override
    public String toString() {
        return "ProductCommentDto{" +
                "id=" + id +
                ", productDto=" + productDto +
                ", userDto=" + userDto +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
