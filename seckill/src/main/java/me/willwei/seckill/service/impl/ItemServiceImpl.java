package me.willwei.seckill.service.impl;

import me.willwei.seckill.dao.ItemDOMapper;
import me.willwei.seckill.dao.ItemStockDOMapper;
import me.willwei.seckill.dataobject.ItemDO;
import me.willwei.seckill.dataobject.ItemStockDO;
import me.willwei.seckill.error.BusinessException;
import me.willwei.seckill.error.EmBusinessError;
import me.willwei.seckill.service.ItemService;
import me.willwei.seckill.service.model.ItemModel;
import me.willwei.seckill.validator.ValidationResult;
import me.willwei.seckill.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ItemServiceImpl
 *
 * @author leiming
 * @date 2019/1/23
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ValidatorImpl validator;

    @Autowired
    private ItemDOMapper itemDOMapper;

    @Autowired
    private ItemStockDOMapper itemStockDOMapper;

    @Override
    @Transactional
    public ItemModel createItem(ItemModel itemModel) throws BusinessException {
        // 校验入参
        ValidationResult validationResult = validator.validate(itemModel);
        if (validationResult.isHasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, validationResult.getErrMsg());
        }

        // 转化itemModel->dataObject
        ItemDO itemDO = this.convertItemDOFromItemModel(itemModel);
        ItemStockDO itemStockDO = this.convertItemStockDOFromModel(itemModel);

        // 写入数据库
        this.itemDOMapper.insertSelective(itemDO);
        itemModel.setId(itemDO.getId());

        this.itemStockDOMapper.insertSelective(itemStockDO);

        // 返回创建完成的对象
        return this.getItemById(itemModel.getId());
    }

    @Override
    public List<ItemModel> listItem() {
        return null;
    }

    @Override
    public ItemModel getItemById(Integer id) {
        ItemDO itemDO = this.itemDOMapper.selectByPrimaryKey(id);
        if (itemDO == null) {
            return null;
        }

        // 操作获得库存数量
        ItemStockDO itemStockDO = this.itemStockDOMapper.selectByItemId(itemDO.getId());

        // 将dataObject->model
        ItemModel itemModel = this.convertModelFromDataObject(itemDO, itemStockDO);

        return itemModel;
    }

    private ItemDO convertItemDOFromItemModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemDO itemDO = new ItemDO();
        BeanUtils.copyProperties(itemModel, itemDO);

        return itemDO;
    }

    private ItemStockDO convertItemStockDOFromModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemStockDO itemStockDO = new ItemStockDO();
        itemStockDO.setItemId(itemModel.getId());
        itemStockDO.setStock(itemModel.getStock());

        return itemStockDO;
    }

    private ItemModel convertModelFromDataObject(ItemDO itemDO, ItemStockDO itemStockDO) {
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDO, itemModel);
        itemModel.setStock(itemStockDO.getStock());

        return itemModel;
    }

}
