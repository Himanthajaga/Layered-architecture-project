package com.example.layeredarchitecture.dao.custom.impl;


import com.example.layeredarchitecture.dao.SqlUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ResultSet rst = SqlUtil.executes("SELECT * FROM Customer");

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }


    public boolean add(String dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.executes("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(), dto.getName(), dto.getAddress());
    }

    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.executes("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(), dto.getAddress(), dto.getId());
    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {
       ResultSet rst =SqlUtil.executes("SELECT id FROM Customer WHERE id=?",id);
         return rst.next();
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();*/
        ResultSet rst = SqlUtil.executes("SELECT id FROM Customer ORDER BY id DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }


    public boolean delete(String id) throws SQLException, ClassNotFoundException {
      return SqlUtil.executes("DELETE FROM Customer WHERE id=?",id);
    }


    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst =SqlUtil.executes("SELECT * FROM Customer WHERE id=?",id);
        rst.next();
        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
    }

    @Override
    public String generateOID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveOrder(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveOrderDetails(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

}
