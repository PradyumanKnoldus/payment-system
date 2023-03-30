package com.knoldus

import scala.util.Try

final case class PaymentSystem(paymentMethods: List[PaymentMethod] = List.empty) {

  // A method to add a new payment method to the payment system
  def addPaymentMethodDetails(newPaymentMethod: PaymentMethod): PaymentSystem = {
    PaymentSystem(newPaymentMethod :: paymentMethods)
  }

  // A method to remove an existing payment method to the payment system
  def removePaymentMethodDetails(existingPaymentMethod: PaymentMethod): PaymentSystem = {
    PaymentSystem(paymentMethods.filterNot(_ == existingPaymentMethod))
  }

  // A method to process a payment using a given payment method
  def processPayment(amount: Double, paymentMethod: PaymentMethod): Boolean = {
    val result = Try(paymentMethod.paymentProcess(amount))

    result match {
      case util.Success(true) => true
      case util.Failure(exception) =>
        println("Error occurred while processing the payment: " + exception.getMessage)
        false
    }
  }

  // A method to list all payment methods added to the payment system
  def listPaymentMethods(): List[PaymentMethod] = {
    paymentMethods
  }
}
