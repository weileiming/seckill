package me.willwei.seckill.service;

import me.willwei.seckill.error.BusinessException;
import me.willwei.seckill.service.model.OrderModel;

/**
 * OrderService
 *
 * @author leiming
 * @date 2019/1/24
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param userId
     * @param itemId
     * @param amount
     * @return
     * @throws BusinessException
     */
    OrderModel createOrder(Integer userId, Integer itemId, Integer amount) throws BusinessException;

}
