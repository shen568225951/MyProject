package com.fh.mapper;

import com.fh.model.TUserWallet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author 15136
 */
@Repository
@Mapper
public interface TUserWalletMapper {
    int deleteByPrimaryKey(Long tuwId);

    int insert(TUserWallet record);

    int insertSelective(TUserWallet record);

    TUserWallet selectByPrimaryKey(Long tuwId);

    int updateByPrimaryKeySelective(TUserWallet record);

    int updateByPrimaryKey(TUserWallet record);

    TUserWallet selectWalletListByUserId(Long userId);
}