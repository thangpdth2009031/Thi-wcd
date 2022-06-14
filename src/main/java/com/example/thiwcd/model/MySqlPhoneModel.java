package com.example.thiwcd.model;

import com.example.thiwcd.constant.SqlConstant;
import com.example.thiwcd.entity.Phone;
import com.example.thiwcd.util.ConnectionHelper;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlPhoneModel implements PhoneModel{
    @Override
    public boolean save(Phone obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(SqlConstant.PHONE_INSERT);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getBrand());
            preparedStatement.setDouble(3, obj.getPrice());
            preparedStatement.setString(4, obj.getDescription());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Phone> findAll() {
        List<Phone> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SqlConstant.PHONE_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Phone obj = convertResultSetToPhone(resultSet);
                if (obj != null) {
                    listObj.add(obj);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listObj;
    }

    private Phone convertResultSetToPhone(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(SqlConstant.PHONE_FIELD_ID);
            String name = resultSet.getString(SqlConstant.PHONE_FIELD_NAME);
            String brand = resultSet.getString(SqlConstant.PHONE_FIELD_BRAND);
            double price = resultSet.getDouble(SqlConstant.PHONE_FIELD_PRICE);
            String description = resultSet.getString(SqlConstant.PHONE_FIELD_DESCRIPTION);
            return Phone.PhoneBuilder.aPhone()
                    .withId(id)
                    .withName(name)
                    .withBrand(brand)
                    .withDescription(description)
                    .withPrice(price)
                    .build();
        } catch (SQLException ex) {
            return null;
        }
    }
}
