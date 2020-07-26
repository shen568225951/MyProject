package com.fh.service.impl;

import com.fh.mapper.TUserWalletMapper;
import com.fh.model.TUserWallet;
import com.fh.service.IUserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWalletServiceImpl implements IUserWalletService {

    @Autowired
    private TUserWalletMapper walletMapper;

    /**
     * 根据用户Id 查询用户钱包表的 数据
     * @param userId
     * @return
     */
    @Override
    public TUserWallet selectWalletListByUserId(Long userId) {
        return walletMapper.selectWalletListByUserId(userId);
    }
}
