package cn.com.scitc.student.mapper;


import cn.com.scitc.student.pojo.Manager;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerMapper {
    Manager findByLoginId(String loginId);
}
