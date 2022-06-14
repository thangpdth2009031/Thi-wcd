package com.example.thiwcd.controller;

import com.example.thiwcd.entity.Phone;
import com.example.thiwcd.model.MySqlPhoneModel;
import com.example.thiwcd.model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class AddPhoneServlet extends HttpServlet {
    private PhoneModel phoneModel;
    public AddPhoneServlet() {
        this.phoneModel = new MySqlPhoneModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addphone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            String brand = req.getParameter("brand");
            String description = req.getParameter("description");
            double price = Double.parseDouble(req.getParameter("price"));
            Phone phone = new Phone();
            phone.setName(name);
            phone.setDescription(description);
            phone.setPrice(price);
            phone.setBrand(brand);
            if (phone.isValid()) {
                boolean result = phoneModel.save(phone);
                if (result) {
                    resp.sendRedirect("/listphone");
                } else {
                    try {
                        throw new Exception("Cant save phone");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }else {
                req.setAttribute("phone", phone);
                req.setAttribute("errors", phone.getErrors());
                req.getRequestDispatcher("/addphone.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
