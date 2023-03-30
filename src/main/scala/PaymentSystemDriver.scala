package com.knoldus

object PaymentSystemDriver extends App {

  // create an initial payment system with no payment methods
  private val paymentSystem = PaymentSystem()

  // add a credit card payment method
  private val creditCardPayment = CreditCardPayment("Credit Card", "Shivam Garg", "1234 5678 9012 3456", "12/25", "159")
  private val updatedPaymentSystem1 = paymentSystem.addPaymentMethodDetails(creditCardPayment)

  // add a PayPal payment method
  private val payPalPayment = PayPalPayment("PayPal", "Pradyuman Pratap Singh", "pradyuman.singh@knoldus.com", "Pa$$word")
  private val updatedPaymentSystem2 = updatedPaymentSystem1.addPaymentMethodDetails(payPalPayment)

  // add a bank transfer payment method
  private val bankTransferPayment = BankTransferPayment("Bank Transfer", "XYZ Bank", "Shahrukh Khan", "1234567890", "IFSC1234")
  private val updatedPaymentSystem3 = updatedPaymentSystem2.addPaymentMethodDetails(bankTransferPayment)

  // list all the payment methods in the payment system
  val paymentMethods = updatedPaymentSystem3.listPaymentMethods()

  println("Payment methods:")
  paymentMethods.foreach(println)

  // process a payment of 18000.0 using the credit card payment method
  private val paymentAmount = 18000.0

  private val paymentSuccessful = updatedPaymentSystem3.processPayment(paymentAmount, creditCardPayment)

  if (paymentSuccessful) {
    println(s"Payment of $paymentAmount was successful.")
  } else {
    println(s"Payment of $paymentAmount failed.")
  }

}
