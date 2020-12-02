package com.bjpowernode.mapper;

import com.bjpowernode.entity.Auth;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthMapper {
    int deleteByPrimaryKey(Integer authId);

    int insert(Auth record);

    int insertSelective(Auth record);

    Auth selectByPrimaryKey(Integer authId);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKey(Auth record);

    List<Auth> selectAll();

    List<Auth> selectByUser(int userId);

    List<Auth> selectByRole(int roleId);
}