package com.spock

import spock.lang.Specification

class CheckoutSpec extends Specification {




    def "complete checkout with given list of item"(){

        given : "the payment processor and list of item available"
        PaymentMethod paymentmethod = Stub(PaymentMethod)
        Item item = Stub(Item)
        List<Item> itemList = new ArrayList<>()
        itemList.add(item)

        when :"mock the payment method with expected response "
            paymentmethod.processPayment(itemList) >> true
            Checkout checkout = new Checkout(paymentmethod,itemList)
            String response = checkout.completeCheckout()
        then :
        response == "checkout complete"

    }

    def "partial testing with spy"(){
        PaymentMethod paymentmethod = Mock(PaymentMethod)
        Item item = Stub(Item)
        List<Item> itemList = new ArrayList<>()
        itemList.add(item)


        def checkout = Spy(Checkout,constructorArgs:[paymentmethod,itemList]){
            verifyPayment() >> "payment verified"
        }
        when :
        String result  = checkout.verifycheckout()
        then :
        result == "checkout payment verified"


    }





}
