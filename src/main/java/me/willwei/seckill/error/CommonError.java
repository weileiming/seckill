package me.willwei.seckill.error;

/**
 * CommonError
 *
 * @author leiming
 * @date 2019/1/17
 */
public interface CommonError {

    public int getErrCode();

    public String getErrMsg();

    public CommonError setErrMsg(String errMsg);

}
