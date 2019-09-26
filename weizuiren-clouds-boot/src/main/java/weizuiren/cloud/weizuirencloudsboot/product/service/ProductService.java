package weizuiren.cloud.weizuirencloudsboot.product.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import weizuiren.cloud.weizuirencloudsboot.product.entity.Product;
import weizuiren.cloud.weizuirencloudsboot.product.entity.ProductComment;

import java.util.List;

/**
 * 商品Service
 */
public interface ProductService {

    /**
     * 获取商品分页数据
     *
     * @param pageable 分页参数
     * @return 分页数据
     */
    Page<Product> getPage(Pageable pageable);

    /**
     * 加载指定ID的商品数据
     *
     * @param id 商品主键
     * @return 商品信息
     */
    Product load(Long id);

    /**
     * 加载指定商品的评论列表
     *
     * @param productId 商品主键ID
     * @return 该商品的评论列表
     */
    List<ProductComment> findAllCommentsByProduct(Long productId);


}
