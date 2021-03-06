package com.company;

import java.sql.*;

/**
 * Created by moshe on 30-10-15.
 */
public final class MysqlConnect {

    public static String driver = "com.mysql.jdbc.Driver";
    public static String protocol = "jdbc:mysql://127.0.0.1:4000/demo";
    private static String dbUsername = "moshe";
    private static String dbPassword = "moshe";

    public Connection connection;


    private static MysqlConnect instance;

    private MysqlConnect() throws ClassNotFoundException {
        this.connection = null;

        try{
            /**
             * Try to connect to db
             */
            Class.forName(driver);
            System.out.println("connecting to data base...");
            this.connection = DriverManager.getConnection(protocol, dbUsername, dbPassword);
        }catch (SQLException e){
            System.out.println("connecting failed!");
            e.printStackTrace();
        }
    }

    public static MysqlConnect getInstance () throws ClassNotFoundException {
    if (instance == null) {
        instance = new MysqlConnect();
    }
        return instance;
    }

}
