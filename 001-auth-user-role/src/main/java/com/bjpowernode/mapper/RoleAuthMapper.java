package com.bjpowernode.mapper;

import com.bjpowernode.entity.RoleAuth;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleAuthMapper {
    int deleteByPrimaryKey(Integer roleAuthId);

    int insert(RoleAuth record);

    int insertSelective(RoleAuth record);

    RoleAuth selectByPrimaryKey(Integer roleAuthId);

    int updateByPrimaryKeySelective(RoleAuth record);

    int updateByPrimaryKey(RoleAuth record);

    int deleteByRole(int roleId);

    int insertBatch(int roleId, int[] authIds);
}