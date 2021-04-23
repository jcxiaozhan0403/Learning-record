package cn.com.scitc.webapp1901.server;

import cn.com.scitc.webapp1901.dao.ManagerDao;
import cn.com.scitc.webapp1901.model.Manager;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyMd5 {
    public static String preSeed = "!@#";
    public static String sufSeed = "$%^";
    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    public static String signPwd(String plainText){
        return stringToMD5(preSeed + plainText + sufSeed);
    }

    public static boolean validateManager(String loginId,String plainText) {
        ManagerDao managerDao = new ManagerDao();
        Manager manager = managerDao.findByLoginId(loginId);
        if (manager != null && manager.getPwd() != null && MyMd5.signPwd(plainText).equals(manager.getPwd())){
            return true;
        }else {
            return false;
        }
    }
}
