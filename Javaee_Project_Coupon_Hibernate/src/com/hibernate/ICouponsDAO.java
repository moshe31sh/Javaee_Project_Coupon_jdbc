package com.hibernate;

/**
 * Created by moshe on 06-11-15.
 */

/**
 *ICouponsDAO interface
 */
public interface ICouponsDAO {
    /**
     * addCoupon - Adding coupon object to DB
     * @param coupon
     * @throws CouponsPlatformException
     */
    public void addCoupon(Coupon coupon) throws CouponsPlatformException;

    /**
     * deleteCoupon - Delete coupon object from DB
     * @param coupon
     * @return bool value if delete succeed
     * @throws CouponsPlatformException
     */
    public boolean deleteCoupon(Coupon coupon) throws CouponsPlatformException;

    /**
     * getCoupons - Get all coupons from DB to array
     * @return - Coupons array from DB
     * @throws CouponsPlatformException
     */
    public Coupon[] getCoupons() throws CouponsPlatformException;
}
