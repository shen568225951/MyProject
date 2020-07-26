package com.fh.service;

import com.fh.model.TUserWallet;


public interface IUserWalletService {
    TUserWallet selectWalletListByUserId(Long userId);
}
