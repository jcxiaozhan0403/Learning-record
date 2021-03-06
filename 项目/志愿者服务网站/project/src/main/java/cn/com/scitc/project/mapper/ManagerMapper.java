package cn.com.scitc.project.mapper;

import cn.com.scitc.project.model.Manager;
import java.util.List;

public interface ManagerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Wed Apr 21 16:26:08 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Wed Apr 21 16:26:08 CST 2021
     */
    int insert(Manager manager);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Wed Apr 21 16:26:08 CST 2021
     */
    Manager selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Wed Apr 21 16:26:08 CST 2021
     */
    List<Manager> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager
     *
     * @mbg.generated Wed Apr 21 16:26:08 CST 2021
     */
    int updateByPrimaryKey(Manager record);

    Manager findByLoginId(String loginId);

    Manager findById(Integer id);

    int reset();
}