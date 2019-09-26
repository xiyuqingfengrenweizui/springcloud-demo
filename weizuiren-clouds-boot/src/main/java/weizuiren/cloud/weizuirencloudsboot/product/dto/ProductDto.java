package weizuiren.cloud.weizuirencloudsboot.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import weizuiren.cloud.weizuirencloudsboot.product.entity.Product;

import java.io.Serializable;

/**
 * 商品信息包
 */
@Setter
@Getter
@NoArgsConstructor
@ApiModel
public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品主键ID
     */
    @ApiModelProperty("商品主键Id")
    private Long id;
    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String name;
    /**
     * 商品封面图片
     */
    @ApiModelProperty("商品封面图片")
    private String coverImage;
    /**
     * 商品价格（分）
     */
    @ApiModelProperty("商品价格（分）")
    private Integer price;

    public ProductDto(Product product) {
        if (null != product) {
            this.id=product.getId();
            this.coverImage = product.getCoverImage();
            this.name = product.getName();
            this.price = product.getPrice();
        }
    }

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
