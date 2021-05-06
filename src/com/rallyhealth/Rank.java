package com.rallyhealth;

/** @author swamy on 3/23/21 */
public enum Rank {
  ACE("0"),
  TWO("2"),
  THREE("3"),
  FOUR("4"),
  FIVE("5");
  String cardNumber;

  Rank(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  String getCardNumber() {
    return cardNumber;
  }
}
