package com.spock;

import java.util.List;

public class PaymentMethod {

    public Boolean processPayment(List<Item> itemList) {
        System.out.println("comming inside this method...");
        return true;
    }
}
