package com.example.layeredarchitecture.bo.custom;


import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException ;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    public String generateNewCustomerID() throws SQLException, ClassNotFoundException;
}
