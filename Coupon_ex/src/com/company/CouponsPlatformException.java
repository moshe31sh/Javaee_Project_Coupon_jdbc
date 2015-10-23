package com.company;

/**
 *  * Created by moshe on 23-10-15.
 */

/**
 * Coupon calls exception handel
 */
public class CouponsPlatformException extends Exception {
    /**
     * Class constructors
     */
    public CouponsPlatformException(String msg){
        super(msg);
    }

    public CouponsPlatformException(String msg , Throwable throwable){
        super(msg , throwable);
    }
}
