package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl {
    public ArrayList<CustomerDTO>getAll() throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
       return customerDAO.getAll();
    }


    public boolean add(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.add(String.valueOf(dto));
    }

    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.update(dto);
    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.add(id);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.generateNewID();
    }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.delete(id);
    }


    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.search(id);
    }


    public String generateOID() throws SQLException, ClassNotFoundException {
        return null;
    }


    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
        return false;
    }


    public boolean saveOrder(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }


    public boolean saveOrderDetails(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }
}
