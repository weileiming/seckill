package me.willwei.seckill.controller.viewobject;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * ItemDO
 *
 * @author leiming
 * @date 2019/1/23
 */
@Setter
@Getter
public class ItemVO {

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

    /**
     * 记录商品是否在秒杀活动中，以及对应的状态
     * 0：表示没有秒杀活动
     * 1：表示秒杀活动待开始
     * 2：表示秒杀活动进行中
     */
    private Integer promoStatus;

    /**
     * 秒杀活动价格
     */
    private BigDecimal promoPrice;

    /**
     * 秒杀Id
     */
    private Integer promoId;

    /**
     * 秒杀活动开始时间
     */
    private String promoStartDate;

}
