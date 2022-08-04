package cn.com.service.user.impl;

import cn.com.dao.user.BillDao;
import cn.com.dao.user.impl.BillDaoImpl;
import cn.com.pojo.Bill;
import cn.com.pojo.Pro;
import cn.com.service.user.BillService;

import java.util.List;

/**
 * @author John.Cena
 * @date 2022/8/4 8:45
 * @Description:
 */
public class BillServiceImpl implements BillService {
    BillDao billDao = new BillDaoImpl();

    public List<Bill> getBillList() {
        return billDao.getBillList();
    }

    public List<Pro> getProList() {
        return billDao.getProList();
    }
}
