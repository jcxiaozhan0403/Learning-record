package com.cdtu.sys.service;

public interface IAccountService {

    //转账方法
    public int updateTransfer(String inName ,String outName , double money);
}
