package cn.com.scitc.webapp3.dao;

import cn.com.scitc.webapp3.pojo.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerDao extends CrudRepository<Manager,Integer> {
}
