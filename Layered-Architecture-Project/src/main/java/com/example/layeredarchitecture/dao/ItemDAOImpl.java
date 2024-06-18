package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{


    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        ResultSet rst =SqlUtil.executes("SELECT * FROM Item");
        while (rst.next()) {
            allItems.add(new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
        }
        return allItems;
    }

    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return SqlUtil.executes("DELETE FROM Item WHERE code=?", code);
    }

    public boolean add(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.executes("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
    }

    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
       return SqlUtil.executes("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand(), dto.getCode());
    }

    public boolean exist(String code) throws SQLException, ClassNotFoundException {
       ResultSet rst = SqlUtil.executes("SELECT code FROM Item WHERE code=?", code);
        return rst.next();
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.executes("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    public ItemDTO search(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst =SqlUtil.executes("SELECT * FROM Item WHERE code=?", code);
        rst.next();
        return new ItemDTO(code + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
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
    public boolean saveOrder(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean saveOrderDetails(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }


}
