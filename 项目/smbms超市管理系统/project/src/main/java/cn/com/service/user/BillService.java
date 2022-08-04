package cn.com.service.user;

import cn.com.pojo.Bill;
import cn.com.pojo.Pro;

import java.util.List;

/**
 * @author John.Cena
 * @date 2022/8/4 8:45
 * @Description:
 */
public interface BillService {
    List<Bill> getBillList();

    List<Pro> getProList();
}
