package com.spock;

import java.util.List;

public class Checkout {
    private PaymentMethod paymentMethod;
    private List<Item> itemList;
    
    public Checkout(PaymentMethod paymentMethod, List<Item>  itemList){
        this.paymentMethod = paymentMethod;
        this.itemList = itemList;
    }
    public String  completeCheckout(){
        if(this.paymentMethod == null){
            throw new NullPointerException();
        }
        if(this.paymentMethod.processPayment(itemList)){
            return "checkout complete";
        }
        else{
            return "unable to make payment";
        }
    }


    public String  verifycheckout(){
        String response = verifyPayment();
        return "checkout "+response;
    }

    public String verifyPayment(){
        return  "payment method present";
    }






}
