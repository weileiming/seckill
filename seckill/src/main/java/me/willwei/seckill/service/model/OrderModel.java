package me.willwei.seckill.service.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * OrderModel
 *
 * @author leiming
 * @date 2019/1/24
 */
@Setter
@Getter
public class OrderModel {

    /**
     * String类型
     */
    private String id;

    /**
     * 购买的用户id
     */
    private Integer userId;

    /**
     * 购买商品id
     */
    private Integer itemId;

    /**
     * 购买商品的单价
     */
    private BigDecimal itemPrice;

    /**
     * 购买数量
     */
    private Integer amount;

    /**
     * 购买金额
     */
    private BigDecimal orderPrice;

}
