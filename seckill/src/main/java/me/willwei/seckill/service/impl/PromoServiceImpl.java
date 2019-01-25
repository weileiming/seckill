package me.willwei.seckill.service.impl;

import me.willwei.seckill.dao.PromoDOMapper;
import me.willwei.seckill.dataobject.PromoDO;
import me.willwei.seckill.service.PromoService;
import me.willwei.seckill.service.model.PromoModel;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PromoServiceImpl
 *
 * @author leiming
 * @date 2019/1/25
 */
@Service
public class PromoServiceImpl implements PromoService {

    @Autowired
    private PromoDOMapper promoDOMapper;

    @Override
    public PromoModel getPromoByItemId(Integer itemId) {
        // 获取对应商品的秒杀活动信息
        PromoDO promoDO = this.promoDOMapper.selectByItemId(itemId);
        // dataObject->model
        PromoModel promoModel = this.convertFromDataObject(promoDO);
        if (promoModel == null) {
            return null;
        }
        // 判断当前时间是否秒杀活动即将考试或正在进行
        DateTime now = new DateTime();
        if (promoModel.getStartDate().isAfterNow()) {
            // 未开始
            promoModel.setStatus(1);
        } else if (promoModel.getEndDate().isBeforeNow()) {
            // 已结束
            promoModel.setStatus(3);
        } else {
            // 进行中
            promoModel.setStatus(2);
        }

        return promoModel;
    }

    private PromoModel convertFromDataObject(PromoDO promoDO) {
        if (promoDO == null) {
            return null;
        }
        PromoModel promoModel = new PromoModel();
        BeanUtils.copyProperties(promoDO, promoModel);
        promoModel.setStartDate(new DateTime(promoDO.getStartDate()));
        promoModel.setEndDate(new DateTime(promoDO.getEndDate()));

        return promoModel;
    }

}
