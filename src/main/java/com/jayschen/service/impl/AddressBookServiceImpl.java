package com.jayschen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jayschen.entity.AddressBook;
import com.jayschen.mapper.AddressBookMapper;
import com.jayschen.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper,AddressBook> implements AddressBookService {
}
