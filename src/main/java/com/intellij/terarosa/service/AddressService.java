package com.intellij.terarosa.service;


import com.intellij.terarosa.common.category.SiGunGuCategory;
import com.intellij.terarosa.common.category.SidoCategory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AddressService {

    public Map<String, String> getMainAddress() {
        return SidoCategory.getSidoCategory();
    }

    public Map<String, String> getSubAddress(String addr1) {
        return SiGunGuCategory.getSiGunGuCategory(SidoCategory.valueOf(addr1));
    }
}
