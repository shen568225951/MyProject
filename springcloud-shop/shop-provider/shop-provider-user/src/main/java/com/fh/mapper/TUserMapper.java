package com.fh.mapper;

import com.fh.model.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository
@Mapper
public interface TUserMapper {
    int deleteByPrimaryKey(Long tuId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long tuId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    //根据用户登录的用户名和密码查询该用户是否存在
    TUser selectUserByNameAndPsd(Map<String, Object> map);
}