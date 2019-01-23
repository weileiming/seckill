package me.willwei.seckill.service.model;

import lombok.Getter;
import lombok.Setter;

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
    private String title;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品销量
     */
    private Integer sales;

    /**
     * 商品图片url
     */
    private String imgUrl;

}
