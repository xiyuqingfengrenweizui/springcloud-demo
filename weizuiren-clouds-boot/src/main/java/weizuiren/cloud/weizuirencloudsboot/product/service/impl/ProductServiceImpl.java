package weizuiren.cloud.weizuirencloudsboot.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import weizuiren.cloud.weizuirencloudsboot.product.entity.Product;
import weizuiren.cloud.weizuirencloudsboot.product.entity.ProductComment;
import weizuiren.cloud.weizuirencloudsboot.product.repository.ProductCommentRepository;
import weizuiren.cloud.weizuirencloudsboot.product.repository.ProductRepository;
import weizuiren.cloud.weizuirencloudsboot.product.service.ProductService;

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
