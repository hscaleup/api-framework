package com.api.framework.pojos;

/**
 * @author Abhishek Kumar on 03/03/2024
 */
public class BookingDates {

    private  String checkin;
    private  String checkout;

    public BookingDates(String cin, String cout){
        setCheckin(cin);
        setCheckout(cout);
    }
    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


}

