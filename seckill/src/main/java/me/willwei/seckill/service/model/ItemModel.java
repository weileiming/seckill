package me.willwei.seckill.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * ItemModel
 *
 * @author leiming
 * @date 2019/1/23
 */
@Setter
@Getter
public class ItemModel {

    /**
     * 商品ID
     */
    private Integer id;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空")
    private String title;

    /**
     * 商品价格
     */
    @NotNull(message = "商品价格不能为空")
    @Min(value = 0, message = "商品价格必须大于0")
    private BigDecimal price;

    /**
     * 商品库存
     */
    @NotNull(message = "库存不能为空")
    private Integer stock;

    /**
     * 商品描述
     */
    @NotBlank(message = "商品描述信息不能为空")
    private String description;

    /**
     * 商品销量
     */
    private Integer sales;

    /**
     * 商品图片url
     */
    @NotBlank(message = "商品图片不能为空")
    private String imgUrl;

    /**
     * 使用聚合模型，如果promoModel不为空，则表示其拥有还未结束的秒杀活动
     */
    private PromoModel promoModel;

}
