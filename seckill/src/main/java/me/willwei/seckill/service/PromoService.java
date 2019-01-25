package me.willwei.seckill.service;

import me.willwei.seckill.service.model.PromoModel;

/**
 * PromoService
 *
 * @author leiming
 * @date 2019/1/25
 */
public interface PromoService {

    /**
     * 根据itemId获取即将进行或正在进行的秒杀活动
     *
     * @param itemId
     * @return
     */
    PromoModel getPromoByItemId(Integer itemId);

}
