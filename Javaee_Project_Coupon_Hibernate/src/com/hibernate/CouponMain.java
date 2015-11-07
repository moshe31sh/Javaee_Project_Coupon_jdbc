package com.hibernate;

/**
 * Created by moshe on 06-11-15.
 */
public class CouponMain {

    public static void main(String args[]){
        /**
         ******Step 1 ******
         */
        Coupon [] myCoupon = {new Coupon(2,"food","Free food for all")
                ,new Coupon(1,"drink","Free drinks for all")};

        try {
            /**
             ******Step 2 add coupons to table ******
             */
            for (Coupon coupon : myCoupon) {
                MySQLCouponsDAO.getInstance().addCoupon(coupon);
            }

//            /**
//             ******Step 3 delete coupons from table ******
//             */
////            for (Coupon coupon : myCoupon) {
////                MySQLCouponsDAO.getInstance().deleteCoupon(coupon);
////            }
//
//            /**
//             ******Step 4 get coupons to array table ******
//             */
//
//            Coupon [] myCouponsFromDb =  MySQLCouponsDAO.getInstance().getCoupons();
//
//            if (myCouponsFromDb != null) {
//                for (Coupon coupon : myCouponsFromDb) {
//                    System.out.println(coupon.toString());
//                }
//            }
//            else {
//                System.out.printf("Table is empty");
//            }
       }
        catch (CouponsPlatformException e){
            e.printStackTrace();
        }

    }
}
