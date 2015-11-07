package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by moshe on 06-11-15.
 */
public class DataAccess {
    //DataAccess singleton instance var
    public static DataAccess instance;
    public SessionFactory sessionFactory;
    /**
     * private constructor
     */
    private DataAccess(){
        //creating factory for getting sessions
        sessionFactory =  new AnnotationConfiguration().configure().buildSessionFactory();

    }

    /**
     * DataAccess. get instance to data
     * @return instance
     */
    public static DataAccess getInstance() {
        if(instance==null) {
            instance = new DataAccess();
        }
        return instance;
    }

}
