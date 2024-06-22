package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.DTO.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;

    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException ;

    public String generateNewCode() throws SQLException, ClassNotFoundException ;
}
