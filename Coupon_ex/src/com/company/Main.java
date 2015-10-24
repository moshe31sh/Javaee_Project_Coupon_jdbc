package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {


    public static void main(String[] args) {
    Coupon myCoupon = new Coupon(2,"food","Free food for all");
        try {
            MySQLCouponsDAO.getInstance().buildTable();
            try {
                MySQLCouponsDAO.getInstance().addCoupon(myCoupon);
               Coupon[] arr = MySQLCouponsDAO.getInstance().getCoupons();
                for (Coupon coupon : arr){
                    System.out.println(coupon.toString());
                }
               if (MySQLCouponsDAO.getInstance().deleteCoupon(myCoupon) == true){
                   System.out.println("Successfully deleted "+myCoupon.getId());
               }
                else{
                   System.out.println("Delete failed "+ myCoupon.getDescription());
               }
            }catch (CouponsPlatformException e){
                e.printStackTrace();
            }
            MySQLCouponsDAO.getInstance().deleteTable();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
