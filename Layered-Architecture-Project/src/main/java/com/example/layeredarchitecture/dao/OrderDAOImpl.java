package com.example.layeredarchitecture.dao;


import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAOImpl implements OrderDAO{

    public String generateOID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.executes("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
      ResultSet rst = SqlUtil.executes("SELECT oid FROM `Orders` WHERE oid=?", orderId);
      return rst.next();
    }

    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.executes("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)", dto.getOrderId(), Date.valueOf(dto.getOrderDate()), dto.getCustomerId());
    }


}
