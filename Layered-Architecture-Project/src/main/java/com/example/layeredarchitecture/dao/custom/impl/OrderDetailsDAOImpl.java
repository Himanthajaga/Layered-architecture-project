package com.example.layeredarchitecture.dao.custom.impl;


import com.example.layeredarchitecture.Entity.OrderDetail;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.DTO.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {


    @Override
    public ArrayList<OrderDetail> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(OrderDetail dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", dto.getOid(), dto.getItemCode(), dto.getUnitPrice(), dto.getQty());
    }

    @Override
    public boolean update(OrderDetail dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetail search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
