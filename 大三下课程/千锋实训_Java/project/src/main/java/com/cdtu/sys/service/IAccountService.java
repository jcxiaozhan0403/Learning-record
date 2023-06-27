package com.cdtu.sys.service;

/**
 * @Author:千锋强哥
 * @organization: 千锋教研院
 * @Version: 1.0
 */
public interface IAccountService {

    /**
     * 创建一个转账方法  update*开头的方法
     */
    public int  updateTransfer(String inName ,String outName ,double money);
}
