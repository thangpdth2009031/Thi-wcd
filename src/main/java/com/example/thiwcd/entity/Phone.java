package com.example.thiwcd.entity;

import java.util.HashMap;

public class Phone {
    private int id;
    private String name = "";
    private String brand;
    private double price;
    private String description = "";

    public Phone() {
    }

    public Phone(int id, String name, String brand, double price, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValid();
        return errors.size() == 0;
    }
    private void checkValid() {
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter name");
        }
        if (description == null || description.length() == 0) {
            errors.put("description", "Please enter description");
        }
        if (price < 0) {
            errors.put("price", "The price of the dish must be greater than 0");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static final class PhoneBuilder {
        private int id;
        private String name;
        private String brand;
        private double price;
        private String description;
        private HashMap<String, String> errors = new HashMap<>();

        private PhoneBuilder() {
        }

        public static PhoneBuilder aPhone() {
            return new PhoneBuilder();
        }

        public PhoneBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public PhoneBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PhoneBuilder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public PhoneBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public PhoneBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public PhoneBuilder withErrors(HashMap<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public Phone build() {
            Phone phone = new Phone();
            phone.setId(id);
            phone.setName(name);
            phone.setBrand(brand);
            phone.setPrice(price);
            phone.setDescription(description);
            phone.setErrors(errors);
            return phone;
        }
    }
}
