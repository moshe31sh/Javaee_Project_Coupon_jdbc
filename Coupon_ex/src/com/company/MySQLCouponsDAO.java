package com.company;


public class MySQLCouponsDAO implements ICouponsDAO {

    private static MySQLCouponsDAO instance;

    private MySQLCouponsDAO() {}

    public static MySQLCouponsDAO getInstance() {
        if(instance==null) {
            instance = new MySQLCouponsDAO();
        }
        return instance;
    }


    @Override
    public void addCoupon(Coupon coupon) throws CouponsPlatformException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean deleteCoupon(Coupon coupon) throws CouponsPlatformException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Coupon[] getCoupons() throws CouponsPlatformException {
        // TODO Auto-generated method stub
        return null;
    }

}
