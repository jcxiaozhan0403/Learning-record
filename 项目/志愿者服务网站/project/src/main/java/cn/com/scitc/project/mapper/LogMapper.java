package cn.com.scitc.project.mapper;

import cn.com.scitc.project.model.Log;

import java.util.List;

public interface LogMapper {
    List<Log> findAll();

    int insert(Log log);

    int reset();
}
