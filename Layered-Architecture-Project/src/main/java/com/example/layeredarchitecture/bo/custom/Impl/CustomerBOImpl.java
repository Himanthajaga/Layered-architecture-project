package com.example.layeredarchitecture.bo.custom.Impl;

import com.example.layeredarchitecture.Entity.Customer;
import com.example.layeredarchitecture.bo.custom.CustomerBO;
import com.example.layeredarchitecture.dao.DAOFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.DTO.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> customers = customerDAO.getAll();
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOS.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));
        }
        return customerDTOS;
    }

    @Override
    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {;

        return customerDAO.add(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public String generateNewCustomerID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewID();
    }
}
