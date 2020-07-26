package com.fh.service;

import com.fh.model.vo.CartVo;

import java.util.List;

public interface ICartService {
    List<CartVo> addCart(Long userId, Long pid, Long count);
}
