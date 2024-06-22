package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.CustomerBO;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.getAll();
    }

    @Override
    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.add(dto);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.update(dto);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.exist(id);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.delete(id);
    }

    @Override
    public String generateNewCustomerID() throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.generateNewID();
    }
}
