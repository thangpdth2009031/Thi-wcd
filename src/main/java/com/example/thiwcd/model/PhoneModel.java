package com.example.thiwcd.model;

import com.example.thiwcd.entity.Phone;

import java.util.List;

public interface PhoneModel {
    boolean save(Phone obj);
    List<Phone> findAll();
}
