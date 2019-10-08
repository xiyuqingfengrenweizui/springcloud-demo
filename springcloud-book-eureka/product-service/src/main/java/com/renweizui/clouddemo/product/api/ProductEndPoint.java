package com.renweizui.clouddemo.product.api;

import com.renweizui.clouddemo.common.BaseEndPoint;
import com.renweizui.clouddemo.common.DataResponse;
import com.renweizui.clouddemo.common.HttpMethod;
import com.renweizui.clouddemo.product.dto.ProductCommentDto;
import com.renweizui.clouddemo.product.dto.ProductDto;
import com.renweizui.clouddemo.product.dto.UserDto;
import com.renweizui.clouddemo.product.entity.Product;
import com.renweizui.clouddemo.product.entity.ProductComment;
import com.renweizui.clouddemo.product.service.ProductService;
import com.renweizui.clouddemo.product.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品管理相关API
 *
 * @author justin.zheng
 * @date 2019/9/26 10:19
 */
@Api(value = "ProductEndPoint", description = "商品管理相关API")
@RestController
@RequestMapping(value = "/products")
public class ProductEndPoint extends BaseEndPoint {


    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    /**
     * 获取商品列表
     *
     * @param pageable 分页信息
     * @return 商品分页数据
     */
    @ApiOperation(value = "获取商品列表", notes = "获取商品列表", httpMethod = HttpMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "页码，从0开始,默认0", name = "page", dataType = "int", paramType = "query", required = false),
            @ApiImplicitParam(value = "页容量，默认20", name = "size", dataType = "int", paramType = "query", required = false),
            @ApiImplicitParam(value = "排序,prop,prod(,ASC|Desc)，例如：sort=name&sort=nickname,desc", name = "sort", dataType = "string", paramType = "query", required = false)
    })
    @GetMapping(value = "")
    public DataResponse<List<ProductDto>> page(Pageable pageable) {

        List<ProductDto> list = new ArrayList<>();

        Page<Product> page = this.productService.getPage(pageable);
        if (page != null) {
            list = page.getContent().stream().map(ProductDto::new).collect(Collectors.toList());
        }

        return this.success(list);
    }


    /**
     * 加载商品详情
     *
     * @param id 商品主键ID
     * @return 商品详情
     */
    @ApiOperation(value = "加载商品详情", notes = "加载商品详情", httpMethod = HttpMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "商品主键Id", name = "id", dataType = "int", paramType = "path", required = true)
    })
    @GetMapping(value = "/{id}")
    public DataResponse<ProductDto> detail(@PathVariable Long id) {
        ProductDto productDto = null;
        Product product = this.productService.load(id);
        if (null != product) {
            productDto = new ProductDto(product);
        }

        return this.success(productDto);
    }


    /**
     * 加载指定商品的评论列表
     *
     * @param id 指定商品主键ID
     * @return 指定商品的评论列表
     */
    @ApiOperation(value = "加载指定商品所有评论", notes = "加载指定商品所有评论", httpMethod = HttpMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(value = "商品主键Id", name = "id", dataType = "int", paramType = "path", required = true)

    })
    @GetMapping(value = "/{id}/comments")
    public DataResponse<List<ProductCommentDto>> comments(@PathVariable Long id) {
        List<ProductCommentDto> list = new ArrayList<>();
        List<ProductComment> comments = this.productService.findAllCommentsByProduct(id);
        if (null == comments || comments.size() == 0) {
            //没有找到指定商品
            return this.success(list);
        }
        Product product = this.productService.load(id);
        ProductDto productDto = new ProductDto(product);

        list = comments.stream().map((comment) -> {

            ProductCommentDto dto = new ProductCommentDto(comment);
            dto.setProductDto(productDto);
            dto.setUserDto(this.loadUser(comment.getAuthorId()));
            return dto;

        }).collect(Collectors.toList());


        return this.success(list);
    }

    /**
     * 通过restTemplate加载评论者的用户信息
     *
     * @param userId
     * @return
     */
    protected UserDto loadUser(Long userId) {
        UserDto userDto = null;

        DataResponse<UserDto> dataResponse = this.userService.load(userId);

        if (dataResponse != null) {
            userDto = dataResponse.getData();
            if (userDto != null) {
                this.logger.debug("I came from port:{}", userDto.getUserServicePort());
            }
        }

        return userDto;

    }


}
