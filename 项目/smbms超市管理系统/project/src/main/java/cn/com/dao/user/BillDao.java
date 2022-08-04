package cn.com.dao.user;

import cn.com.pojo.Bill;
import cn.com.pojo.Pro;

import java.util.List;

/**
 * @author John.Cena
 * @date 2022/8/4 8:40
 * @Description:
 */
public interface BillDao {
    List<Bill> getBillList();

    List<Pro> getProList();
}
