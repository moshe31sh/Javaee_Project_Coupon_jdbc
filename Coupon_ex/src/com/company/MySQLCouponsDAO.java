package com.company;


import com.mysql.jdbc.exceptions.MySQLDataException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLCouponsDAO implements ICouponsDAO {

    private final static String  insertCoupon = "INSERT INTO coupons"+"(id,title,description) VALUES"+"(?,?,?)";
    private final static String  deleteCoupon = "DELETE FROM coupons WHERE id="+"(?)";
    private final static String queryCheck = "SELECT * from coupons WHERE id = ";
    private final static String getAllCoupons = "SELECT * from coupons WHERE 1";

    /**
     *single tone
     */
    private static MySQLCouponsDAO instance;

    private PreparedStatement preparedStatement;
    private ResultSet rs;

    private MySQLCouponsDAO() {
        this.preparedStatement = null;
        this.rs = null;
    }

    /**
     *MySQLCouponsDAO. single ton implementation
     * @return object instance
     */
    public static MySQLCouponsDAO getInstance() {
        if(instance==null) {
            instance = new MySQLCouponsDAO();
        }
        return instance;
    }

    /**
     * createTableInDB. run for the first time on new DB
     * @param tableName - receive table name from main
     */
    public void createTableInDB(String tableName) throws CouponsPlatformException, ClassNotFoundException {
        try {

            this.preparedStatement = MysqlConnect.getInstance().connection.prepareStatement("create table " + tableName + "(id int, title VARCHAR (20) ,description VARCHAR (20))");
            this.preparedStatement.addBatch();
            this.preparedStatement.executeBatch();
        }catch(SQLException e){
            throw new CouponsPlatformException("Problem create table "+tableName , e);

           //
        }
    }

    @Override
    public void addCoupon(Coupon coupon) throws CouponsPlatformException, ClassNotFoundException {

        try {
            this.preparedStatement = MysqlConnect.getInstance().connection.prepareStatement(insertCoupon);
            if(this.exist(coupon.getId())){
                System.out.println("Coupon " + coupon.getTitle() + " id " + coupon.getId() + " is already exist");
            }else {
                this.preparedStatement.setInt(1, coupon.getId());
                this.preparedStatement.setString(2, coupon.getTitle());
                this.preparedStatement.setString(3, coupon.getDescription());
                preparedStatement.addBatch();
                preparedStatement.executeBatch();
            }
        }catch (SQLException e){
            //e.printStackTrace();
            throw new CouponsPlatformException("Problem add coupon" , e);
        }
    }

    @Override
    public boolean deleteCoupon(Coupon coupon) throws CouponsPlatformException, ClassNotFoundException {
        try {
            this.preparedStatement = MysqlConnect.getInstance().connection.prepareStatement(deleteCoupon);
            if(exist(coupon.getId())){
                this.preparedStatement.setInt(1, coupon.getId());
                preparedStatement.addBatch();
                preparedStatement.executeBatch();
            }
            else {
                System.out.println("Coupon "+coupon.getTitle() + " id "+coupon.getId()+" is not exist");
            }
        }catch (SQLException e){
          //  e.printStackTrace();
            throw new CouponsPlatformException("Problem delete coupon" , e);

        }
        return false;
    }

    @Override
    public Coupon[] getCoupons() throws CouponsPlatformException, ClassNotFoundException {
        int rowsCounter = countRows();;
        if (rowsCounter!= 0) {
            int i = 0;
            try {
                Coupon [] couponsArr = new Coupon[rowsCounter];
                rs = this.preparedStatement.executeQuery(
                        "SELECT id,title,description FROM coupons ORDER BY id");
                while (rs.next()) {
                    couponsArr[i] = new Coupon( rs.getInt("id") ,rs.getString("title") ,rs.getString("description"));
                    i++;
                }
                return couponsArr;
            } catch (SQLException e) {
               // e.printStackTrace();
                throw new CouponsPlatformException("Problem receive coupon array" , e);

            }
        }

        return null;
    }

    /**
     * countRows . count row number
     * @return rows number
     */
    private int countRows() throws CouponsPlatformException, ClassNotFoundException {
        int numberOfRows = 0;
        try {
            this.preparedStatement = MysqlConnect.getInstance().connection.prepareStatement(getAllCoupons);//get table table from db
            rs = this.preparedStatement.executeQuery(
                    "SELECT COUNT(*) FROM coupons");
             if (rs.next()) {
                numberOfRows = rs.getInt(1);
            }

        }catch (SQLException e){
           // e.printStackTrace();
            throw new CouponsPlatformException("Problem receive coupon array" , e);

        }
        return numberOfRows;
    }

    /**
     * check if value is already in table
     * @param id
     * @return
     */
    private boolean exist(int id){
        try {
            this.rs = this.preparedStatement.executeQuery(queryCheck + id);//check if coupon is already exist in table
            if (this.rs.absolute(1)) {
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

}