package cn.com.scitc.springbootstudy.dao;

import cn.com.scitc.springbootstudy.pojo.Department;
import cn.com.scitc.springbootstudy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author John.Cena
 * @date 2021/10/21 21:56
 * @Description: 员工Dao
 */
@Repository
public class EmployeeDao {
    // 模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    @Autowired
    DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer,Employee>();

        employees.put(1,new Employee(1,"李爽","826594",1,new Department(105,"后勤部")));
        employees.put(2,new Employee(2,"张三","826594",1,new Department(105,"后勤部")));
        employees.put(3,new Employee(3,"李四","826594",1,new Department(105,"后勤部")));
        employees.put(4,new Employee(4,"王五","826594",1,new Department(105,"后勤部")));
        employees.put(5,new Employee(5,"赵六","826594",1,new Department(105,"后勤部")));
    }

    public Integer initId = 6;

    /**
     * 添加员工
     * @param employee
     */
    public void add(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employees.put(employee.getId(),employee);
    }


    /**
     * 通过id删除员工
     * @param id
     */
    public void delete(Integer id) {
        employees.remove(id);
    }

    /**
     * 通过id更新员工
     * @param employee
     */
    public void update(Employee employee) {
        employees.put(employee.getId(),employee);
    }

    /**
     * 通过id查找员工
     * @param id
     * @return
     */
    public Employee findById(Integer id) {
        return employees.get(id);
    }

    /**
     * 加载员工列表
     * @return
     */
    public Collection<Employee> employeeList() {
        return employees.values();
    }
}
