package me.willwei.seckill.service;

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
     * @param id user id
     */
    UserModel getUserById(Integer id);

}
