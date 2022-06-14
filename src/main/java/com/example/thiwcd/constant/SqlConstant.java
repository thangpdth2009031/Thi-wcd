package com.example.thiwcd.constant;

public class SqlConstant {
    public static final String PHONE_INSERT = "INSERT INTO phones (name, brand, price, description) values (?, ?, ?, ?)";
    public static final String PHONE_SELECT_ALL = "SELECT * FROM phones";
    public static final String PHONE_FIELD_ID = "id";
    public static final String PHONE_FIELD_NAME = "name";
    public static final String PHONE_FIELD_BRAND = "brand";
    public static final String PHONE_FIELD_PRICE = "price";
    public static final String PHONE_FIELD_DESCRIPTION = "description";
}
