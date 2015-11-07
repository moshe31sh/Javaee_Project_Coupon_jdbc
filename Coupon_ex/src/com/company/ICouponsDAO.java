package com.company;

/**
 * Created by moshe on 23-10-15.
 */
public interface ICouponsDAO {
    public void addCoupon(Coupon coupon) throws CouponsPlatformException, ClassNotFoundException;
    public boolean deleteCoupon(Coupon coupon) throws CouponsPlatformException, ClassNotFoundException;
    public Coupon[] getCoupons() throws CouponsPlatformException, ClassNotFoundException;
}
