package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.bo.custom.Impl.CustomerBOImpl;
import com.example.layeredarchitecture.bo.custom.Impl.ItemBOImpl;
import com.example.layeredarchitecture.bo.custom.Impl.PlaceOrderBOImpl;

public class BoFactory{
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getBoFactory() {
        return (boFactory == null) ? (boFactory = new BoFactory()) : boFactory;
    }
    public enum BoTypes {
        CUSTOMER, ITEM, ORDER;
    }

    public SuperBO getBo( BoTypes boTypes) {
        switch (boTypes) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }

    }
}
