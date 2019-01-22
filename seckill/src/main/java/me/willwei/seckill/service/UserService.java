package me.willwei.seckill.service;

import me.willwei.seckill.error.BusinessException;
import me.willwei.seckill.service.model.UserModel;

/**
 * UserService
 *
 * @author leiming
 * @date 2019/1/17
 */
public interface UserService {

    /**
     * 通过用户ID获取用户对象的方法
     *
     * @param id
     * @return
     */
    UserModel getUserById(Integer id);

    /**
     * 注册用户
     *
     * @param userModel
     * @throws BusinessException
     */
    void register(UserModel userModel) throws BusinessException;

    /**
     * 用户登录
     *
     * @param telephone
     * @param encryptPassword
     * @return
     * @throws BusinessException
     */
    UserModel validateLogin(String telephone, String encryptPassword) throws BusinessException;

}
