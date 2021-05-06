package com.rallyhealth;

/**
 * @author swamy on 3/23/21
 */
public enum Suit {
    HEARTS(2), SPADES(3), DIAMONDS(1), CLUBS(0);

    int cardType;
    Suit(int cardType) {
        this.cardType = cardType;
    }

    int getCardType(){
        return cardType;
    }
/*
    public static Suit getSuitFromValue(int value){
        return new Suit(1);
    }*/
}
