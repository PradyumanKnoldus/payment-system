package com.knoldus

sealed trait PaymentMethod {

  val paymentType: String

  def paymentProcess(amount: Double): Boolean
}

// Credit card payment method
final case class CreditCardPayment (
  paymentType: String,
  fullName: String,
  cardNumber: String,
  cardExpiryDate: String,
  cvv: String ) extends PaymentMethod {

  override def paymentProcess(amount: Double): Boolean = {
    // Code to process payment using credit card details
    if (amount < 0) {
      throw new IllegalArgumentException("Payment amount should be greater than zero.")
    }
    true
  }
}

// PayPal payment method
final case class PayPalPayment (
  paymentType: String,
  fullName: String,
  email: String,
  password: String ) extends PaymentMethod {

  override def paymentProcess(amount: Double): Boolean = {
    // Code to process payment using PayPal credentials
    if (amount < 0) {
      throw new IllegalArgumentException("Payment amount should be greater than zero.")
    }
    true
  }
}

// Bank transfer payment method
final case class BankTransferPayment (
  paymentType: String,
  bankName: String,
  fullName: String,
  accountNumber: String,
  ifscCode: String) extends PaymentMethod {

  override def paymentProcess(amount: Double): Boolean = {
    // Code to process payment using bank transfer details
    if (amount < 0) {
      throw new IllegalArgumentException("Payment amount should be greater than zero.")
    }
    true
  }
}