package me.willwei.seckill.error;

/**
 * BusinessException
 * 包装器业务异常类实现
 *
 * @author leiming
 * @date 2019/1/17
 */
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    /**
     * 直接接受EmBusinessError的传参用于构造业务异常
     *
     * @param commonError
     */
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    /**
     * 接收自定义errMsg的方式构造业务异常
     *
     * @param commonError
     * @param errMsg
     */
    public BusinessException(CommonError commonError, String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }

}
