package com.company;



public class Main {


    public static void main(String[] args) {

        /**
         ******Step 1 ******
         */
        Coupon [] myCoupon = {new Coupon(2,"food","Free food for all"),new Coupon(1,"drink","Free drinks for all")};

        /**
         ******Step 2 Create table ******
         */
       // MySQLCouponsDAO.getInstance().createTableInDB("coupons");

        try {
            /**
             ******Step 3 add coupons to table ******
             */
//            for (Coupon coupon : myCoupon) {
//                MySQLCouponsDAO.getInstance().addCoupon(coupon);
//            }

            /**
             ******Step 4 delete coupons to table ******
             */
//            for (Coupon coupon : myCoupon) {
//                MySQLCouponsDAO.getInstance().deleteCoupon(coupon);
//            }

            /**
             ******Step 4 get coupons to array table ******
             */

            Coupon [] myCouponsFromDb =  MySQLCouponsDAO.getInstance().getCoupons();

            if (myCouponsFromDb != null) {
                for (Coupon coupon : myCouponsFromDb) {
                    System.out.println(coupon.toString());
                }
            }
            else {
                System.out.printf("Table is empty");
            }
        }
        catch (CouponsPlatformException e){
            e.printStackTrace();
        }
    }
}
