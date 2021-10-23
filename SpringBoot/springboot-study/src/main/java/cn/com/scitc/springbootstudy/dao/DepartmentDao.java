package cn.com.scitc.springbootstudy.dao;

import cn.com.scitc.springbootstudy.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author John.Cena
 * @date 2021/10/21 21:46
 * @Description: 部门Dao
 */
@Repository
public class DepartmentDao {
    // 模拟数据库中的数据
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer,Department>();

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));
    }

    /**
     * 获取部门列表
     * @return
     */
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    /**
     * 通过id查询部门信息
     * @param id
     * @return
     */
    public Department getDepartment(Integer id) {
        return departments.get(id);
    }
}
