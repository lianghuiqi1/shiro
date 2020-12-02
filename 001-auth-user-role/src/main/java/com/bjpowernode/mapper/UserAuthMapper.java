package com.bjpowernode.mapper;

import com.bjpowernode.entity.UserAuth;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthMapper {
    int deleteByPrimaryKey(Integer userAuthId);

    int insert(UserAuth record);

    int insertSelective(UserAuth record);

    UserAuth selectByPrimaryKey(Integer userAuthId);

    int updateByPrimaryKeySelective(UserAuth record);

    int updateByPrimaryKey(UserAuth record);

    int deleteByUser(int userId);

    int insertBatch(int userId, int[] authIds);
}