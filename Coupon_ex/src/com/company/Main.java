package com.company;


public class Main {

    public static void main(String[] args) {

        Coupon myCoupon = new Coupon(2,"food", "free food for all"); //class test
        //System.out.println(myCoupon.toString());
        try {
            MySQLCouponsDAO.getInstance().addCoupon(myCoupon);
        }
        catch (CouponsPlatformException e){
            e.printStackTrace();
        }
        }
}
