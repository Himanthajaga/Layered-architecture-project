package com.example.layeredarchitecture.dao.custom.impl;


import com.example.layeredarchitecture.dao.SqlUtil;
import com.example.layeredarchitecture.dao.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(String dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
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
    public OrderDetailDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
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
    public boolean saveOrder(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    public boolean saveOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.executes("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
               dto.getOid(), dto.getItemCode(), dto.getUnitPrice(), dto.getQty());
    }
}
