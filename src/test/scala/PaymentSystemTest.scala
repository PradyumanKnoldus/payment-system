package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class PaymentSystemTest extends AnyFlatSpec {

  // Credit card payment method
  val creditCardPayment: CreditCardPayment = CreditCardPayment(
    "Credit Card",
    "Pradyuman Singh",
    "1234567890123456",
    "12/23",
    "123")

  // PayPal payment method
  val payPalPayment: PayPalPayment = PayPalPayment(
    "PayPal",
    "Pradyuman Singh",
    "pradyuman.singh@knoldus.com",
    "password123")

  // Bank transfer payment method
  val bankTransferPayment: BankTransferPayment = BankTransferPayment(
    "Bank Transfer",
    "QWE Bank",
    "Pradyuman Singh",
    "1234567890",
    "SBIN0000345")

  // A PaymentSystem instance with no payment methods
  val emptyPaymentSystem: PaymentSystem = PaymentSystem()

  // A PaymentSystem instance with multiple payment methods
  val paymentSystem: PaymentSystem = PaymentSystem(
    List(
      creditCardPayment,
      payPalPayment,
      bankTransferPayment
    )
  )

  "PaymentSystem" should "add a new payment method" in {
    val newPaymentMethod = CreditCardPayment(
      "Credit Card",
      "Pradyuman Singh",
      "0987654321098765",
      "01/24",
      "456"
    )
    val updatedPaymentSystem = paymentSystem.addPaymentMethodDetails(newPaymentMethod)

    assert(updatedPaymentSystem.listPaymentMethods().contains(newPaymentMethod))
  }

  it should "process a payment using a given payment method" in {
    val amount = 100.0

    assert(paymentSystem.processPayment(amount, creditCardPayment))
    assert(paymentSystem.processPayment(amount, payPalPayment))
    assert(paymentSystem.processPayment(amount, bankTransferPayment))
  }

  it should "list all payment methods added to the payment system" in {
    assert(paymentSystem.listPaymentMethods().size == 3)
    assert(emptyPaymentSystem.listPaymentMethods().isEmpty)
  }
}
