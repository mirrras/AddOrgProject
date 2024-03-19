package com.kwork.orgibiz.service;

import com.kwork.orgibiz.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService {
    @Autowired
    private AccessRepository accessRepository;
}
