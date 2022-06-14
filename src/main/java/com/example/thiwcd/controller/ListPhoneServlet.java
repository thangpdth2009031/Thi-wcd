package com.example.thiwcd.controller;

import com.example.thiwcd.entity.Phone;
import com.example.thiwcd.model.MySqlPhoneModel;
import com.example.thiwcd.model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListPhoneServlet extends HttpServlet {
    private PhoneModel phoneModel;
    public ListPhoneServlet() {
        this.phoneModel = new MySqlPhoneModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Phone> phones = phoneModel.findAll();
        req.setAttribute("phones", phones);
        req.getRequestDispatcher("/listphone.jsp").forward(req, resp);
    }
}
