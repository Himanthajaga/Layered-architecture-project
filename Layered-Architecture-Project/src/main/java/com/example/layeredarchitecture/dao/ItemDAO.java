package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO {
    ArrayList<ItemDTO> loadAllItems() throws SQLException, ClassNotFoundException ;

    void deleteItem(String code) throws SQLException, ClassNotFoundException ;

    void saveItem(ItemDTO item) throws SQLException, ClassNotFoundException ;

    boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    boolean existItem(String code) throws SQLException, ClassNotFoundException ;

    ResultSet generateNewId() throws SQLException, ClassNotFoundException ;

    ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException ;
}
