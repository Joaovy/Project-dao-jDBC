package model.dao;

import dbanco.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao creatSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

}
