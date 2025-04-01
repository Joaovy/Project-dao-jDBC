package dbanco;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection con = null;

    public static Connection getConnection(){
        if (con == null){
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                con = DriverManager.getConnection(url, props);
            } catch (SQLException e){
                throw  new DbExceptions(e.getMessage());
            }
        }

        return con;
    }

    public static void closeConnection(){
        if(con != null){
            try{
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }


    private static Properties loadProperties() {
        try (InputStream inputStream = DB.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (inputStream == null) {
                throw new IOException("Arquivo db.properties não encontrado no classpath!");
            }

            Properties props = new Properties();
            props.load(inputStream);
            return props;
        } catch (IOException e) {
            throw new DbExceptions(e.getMessage());
        }
    }


    public static void closeStatement(Statement st){

        if(st != null){
            try {
                st.close();

            } catch (SQLException e) {
                throw new DbExceptions(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){

        if(rs != null){
            try {
                rs.close();

            } catch (SQLException e) {
                throw new DbExceptions(e.getMessage());
            }
        }
    }


}
