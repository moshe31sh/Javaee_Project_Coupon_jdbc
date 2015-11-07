package com.hibernate;

/**
 * Created by moshe on 06-11-15.
 */
/**
 * Created by moshe on 06-11-15.
 */
public class Coupon {
    // Var declaration
    private int id;
    private String title;
    private String description;


    /**
     * Coupon constructor
     * @param id - coupon id
     * @param title - coupon title
     * @param description - coupon description
     */
    public Coupon(int id, String title, String description) {
        setId(id);
        setTitle(title);
        setDescription(description);
    }

    /**
     * Default constructor
     */
    public Coupon() {
        super();
    }
    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString(){
        return "\nCoupon details ** id : ["+this.getId() + "] Title: [" + this.getTitle() + "] Description: ["+this.getDescription()+"] **";
    }

}
