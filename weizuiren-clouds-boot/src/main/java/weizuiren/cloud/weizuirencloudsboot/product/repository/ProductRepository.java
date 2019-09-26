package weizuiren.cloud.weizuirencloudsboot.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weizuiren.cloud.weizuirencloudsboot.product.entity.Product;

/**
 * 商品信息Repository
 *
 * @author weizuiren
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
