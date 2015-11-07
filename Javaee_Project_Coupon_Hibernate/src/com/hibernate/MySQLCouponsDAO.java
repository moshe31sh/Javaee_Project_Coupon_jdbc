package com.hibernate;

/**
 * Created by moshe on 06-11-15.
 */


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * MySQLCouponsDAO implements interface
 */

public class MySQLCouponsDAO implements ICouponsDAO {
    //singleton declaration
    private static MySQLCouponsDAO instance;
    private Session session;

    /**
     * default constructor
     */
    private MySQLCouponsDAO() {
    }
    //singleton implementation
    public static MySQLCouponsDAO getInstance() {
        if (instance == null) {
            instance = new MySQLCouponsDAO();
        }
        return instance;
    }

    /**
     * Override addCoupon  from  ICouponsDAO interface
     * @param coupon
     * @throws CouponsPlatformException
     */
    @Override
    public void addCoupon(Coupon coupon) throws CouponsPlatformException {
              this.session = DataAccess.getInstance().sessionFactory.openSession();
            try {

                this.session.beginTransaction();
              this.session.save(coupon);
                this.session.getTransaction().commit();

            } catch (HibernateException e) {

                //roll back in case of problem
                if (this.session.getTransaction() != null) {
                    this.session.getTransaction().rollback();
                    throw new CouponsPlatformException("Problem add coupon", e);

                }
            } finally {
                this.session.close();
            }
        }

    /**
     * Override deleteCoupon from  ICouponsDAO interface
     * @param coupon
     * @return bool if delete succeed
     * @throws CouponsPlatformException
     */
    @Override
    public boolean deleteCoupon(Coupon coupon) throws CouponsPlatformException {
        this.session = DataAccess.getInstance().sessionFactory.openSession();
        try
        {
            this.session.beginTransaction();
            Query query = this.session.createQuery("delete Coupon where id = :id");
            query.setParameter("id", coupon.getId());
            int result = query.executeUpdate();
            this.session.getTransaction().commit();
             } catch (HibernateException e) {

        //roll back in case of problem
        if (this.session.getTransaction() != null) {
            this.session.getTransaction().rollback();
            throw new CouponsPlatformException("Problem add coupon", e);

        }
    } finally {
        this.session.close();
    }
        return false;
    }

    /**
     * Override getCoupons  implementation from  ICouponsDAO interface
     * @return array of coupons from DB
     * @throws CouponsPlatformException
     */
    @Override
    public Coupon[] getCoupons() throws CouponsPlatformException {
        //coupons table to return
        Coupon [] couponsToReturn = null;
        this.session = DataAccess.getInstance().sessionFactory.openSession();
       try {
            this.session.beginTransaction();
            ArrayList couponsArr = new ArrayList( this.session.createQuery("from Coupon").list());
           if (couponsArr.size() > 0) {
           couponsToReturn = new Coupon[couponsArr.size()];
           for (int i = 0 ; i < couponsArr.size() ; i++){
               couponsToReturn[i] =(Coupon) couponsArr.get(i);
           }
        }

        } catch (HibernateException e) {

      //roll back in case o//f problem
            if (this.session.getTransaction() != null) {
                this.session.getTransaction().rollback();
                throw new CouponsPlatformException("Problem add coupon", e);

            }
        } finally {
            this.session.close();
        }

        return couponsToReturn;
    }




}