package com.hibernate;

/**
 * Created by moshe on 06-11-15.
 */

/**
 * CouponsPlatformException . inheritance for Exception java class.
 * This method  receive coupon exception.
 */
public class CouponsPlatformException extends Exception {
    /**
     * CouponsPlatformException . Constructor that receive string error msg
     * @param msg
     */
    public CouponsPlatformException(String msg) {
        super(msg);
    }
    public CouponsPlatformException(String msg, Throwable throwable) {
        super(msg,throwable);
    }
}