package com.cdtu.sys.service;

/**
 * @author John.Cena
 * @date 2023/6/26 18:23
 * @Description:
 */
public interface IAccountService {

    //转账
    public int updateTransfer(String inName, String outName , double money);
}
