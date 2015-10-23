package com.company;

/**
 * Created by moshe on 23-10-15.
 */
public class Coupon {
    private int id;
    private String title;
    private String description;

    /**
     * Coupon constructor
      * @param id
     * @param title
     * @param description
     */
    public Coupon(int id, String title, String description) {
        setId(id);
        setTitle(title);
        setDescription(description);
    }

    /**
     * getId.
     * @return id value
     */
    public int getId() {
        return id;
    }

    /**
     * setId
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getTitle
     * @return coupon title
     */

    public String getTitle() {
        return title;
    }

    /**
     * setTitle
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getDescription
     * @return coupon description
     */
    public String getDescription() {
        return description;
    }

    /**
     * setDescription
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString(){
        return "Coupon details ** id : ["+this.getId() + "] Title: [" + this.getTitle() + "] Description: ["+this.getDescription()+"] **";
    }
}
