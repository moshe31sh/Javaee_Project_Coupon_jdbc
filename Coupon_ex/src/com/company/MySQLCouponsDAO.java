package com.company;

import java.sql.*;

public class MySQLCouponsDAO implements ICouponsDAO {

    private static MySQLCouponsDAO instance;
    public static String driver = "org.apache.derby.jdbc.ClientDriver";
    public static String protocol = "jdbc:derby://localhost:1527/gagamoDB;create=true";
    private  int count;
    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    private MySQLCouponsDAO() {init();}

    private void init(){
         connection = null;
         statement = null;
         rs = null;
        count = 0;
        try {
            connection = null;
            //Instantiating the dirver class will indirectly register
            //this driver as an available driver for DriverManager
            Class.forName(driver);
            //Getting a connection by calling getConnection
            connection = DriverManager.getConnection(protocol);
            statement = connection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static MySQLCouponsDAO getInstance() {
        if(instance==null) {
            instance = new MySQLCouponsDAO();
        }
        return instance;
    }

    @Override
    /**
     * addCoupon . Adding coupon details to data base
     */
    public void addCoupon(Coupon coupon) throws CouponsPlatformException {
        // TODO Auto-generated method stub

        try{
            count++;
            statement.execute("INSERT INTO Coupons VALUES (" + coupon.getId() + " ," + coupon.getTitle() + " , " + coupon.getDescription()+")");

    }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    /**
     * deleteCoupon. deleting coupon from data base by id
     */
    public boolean deleteCoupon(Coupon coupon) throws CouponsPlatformException {
        // TODO Auto-generated method stub
        try{
            count--;
            statement.execute("DELETE  FROM  Coupons WHERE id IN (5)");
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Coupon[] getCoupons() throws CouponsPlatformException {
        try {

            rs = statement.executeQuery("SELECT id,title ,description   FROM Coupons ORDER BY id");

           // while(rs.next()) count++;
            Coupon [] arrayOfCoupons = new Coupon[count];
            int i = 0 ;
            while(rs.next()) {

            arrayOfCoupons[i] = new Coupon(rs.getInt("id") ,rs.getString("title") , rs.getString("description"));
                i++;
            }
            return arrayOfCoupons;
        }catch (Exception e){
            e.printStackTrace();
        }
        // TODO Auto-generated method stub
        return null;
    }

    public void buildTable(){
        try {
            statement.execute("create table Coupons(id int, title  VARCHAR (50) NOT NULL , description VARCHAR (50) NOT NULL )");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteTable(){
        try {
            statement.execute("DROP TABLE Coupons");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
