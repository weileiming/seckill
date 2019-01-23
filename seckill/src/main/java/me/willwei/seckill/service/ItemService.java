package me.willwei.seckill.service;

import me.willwei.seckill.error.BusinessException;
import me.willwei.seckill.service.model.ItemModel;

import java.util.List;

/**
 * ItemService
 *
 * @author leiming
 * @date 2019/1/23
 */
public interface ItemService {

    /**
     * 创建商品
     *
     * @param itemModel
     * @return
     * @throws BusinessException
     */
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    /**
     * 商品列表浏览
     *
     * @return
     */
    List<ItemModel> listItem();

    /**
     * 商品详情浏览
     *
     * @param id
     * @return
     */
    ItemModel getItemById(Integer id);

}
