package com.fh.controller;

import com.fh.model.TUserWallet;
import com.fh.service.IUserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("userWalletController")
@CrossOrigin
public class UserWalletController {

    @Autowired
    private IUserWalletService walletService;

    /**
     * 根据用户Id查询 用户钱包表 的金额
     * @param userId
     * @return
     */
    @RequestMapping("selectWalletListByUserId")
    public TUserWallet selectWalletListByUserId(Long userId){
        return walletService.selectWalletListByUserId(userId);
    }
}
