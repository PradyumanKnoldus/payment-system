# Payment System
## Session 4 Day 3 Assignment 1

Build a payment system for an e-commerce website where users can make payments using different payment methods such as credit cards, PayPal, and bank transfers.
Write a modular program that can perform the following operations:

    Add a new payment method with the details (Pick from credit cards, PayPal, and bank transfers. You can add multiple payment methods)
    Process a payment
    List all the added payment methods

> Take care of the abstraction

## Solution

This is a Payment System Library implemented in Scala which allows you to add, remove and process payments using different payment methods. The library currently supports Credit Card Payment, PayPal Payment, and Bank Transfer Payment methods.

### Method Signature

You can then add payment methods to the payment system using the 
    
    addPaymentMethodDetails method:
    
    def addPaymentMethodDetails(newPaymentMethod: PaymentMethod)
    
To process a payment, you can use the 
    
    processPayment method:
    
    def processPayment(amount: Double, paymentMethod: PaymentMethod)
    
To list all payment methods added to the payment system, you can use the 

    listPaymentMethods method:
    
    def listPaymentMethods()
    
You can also remove a payment method from the payment system using the 

    removePaymentMethodDetails method:
    
    def removePaymentMethodDetails(existingPaymentMethod: PaymentMethod)
    

