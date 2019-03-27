package com.spock

import spock.lang.Specification

class CheckoutSpec extends Specification {

    def "complete checkout with given list of item "(){
        given : "the payment processor and list of item available"
        PaymentMethod paymentMethod = new PaymentMethod()
        Item item = new Item()
        List<Item> itemList = new ArrayList<>()
        itemList.add(item)
        when :"Call complete checkout method "
            Checkout checkout = new Checkout(paymentMethod,itemList)
            String response = checkout.completeCheckout()
        then :
        response == "checkout complete"
    }

    def "complete checkout with given list of item mock paymentMehod to return false"(){
        given : "the payment processor and list of item available"
        PaymentMethod paymentmethod = Stub(PaymentMethod)
        Item item = Stub(Item)
        List<Item> itemList = new ArrayList<>()
        itemList.add(item)

        when :"mock the payment method with expected response "
        paymentmethod.processPayment(itemList) >> false
        Checkout checkout = new Checkout(paymentmethod,itemList)
        String response = checkout.completeCheckout()
        then :
        response == "unable to make payment"

    }

    def "Test Class partly  with spy"(){
        PaymentMethod paymentmethod = Mock(PaymentMethod)
        Item item = Stub(Item)
        List<Item> itemList = new ArrayList<>()
        itemList.add(item)


        def checkout = Spy(Checkout,constructorArgs:[paymentmethod,itemList]){
            verifyPayment() >> "paymens verified"
        }
        when :
        String result  = checkout.verifycheckout()
        then :
        result == "checkout payment verified"


    }





}
