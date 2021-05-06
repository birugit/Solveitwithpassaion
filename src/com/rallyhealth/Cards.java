package com.rallyhealth;

/**
 * @author swamy on 3/22/21
 */
public abstract class Cards {
   // Rank rank; // Ace, 2, 3, 4 etc
   // Suit suit; // Hearts, Spade etc
   // Rank rank;
   // Suit suit;

    private boolean isAvailable;
    /* number or face that's on card - a number 2 through 1e, or 11 for Jack, 12 for * Queen, 13 for King, or 1 for Ace *1 */
    protected int faceValue;
    protected Suit suit;

    Cards(int r, Suit suit){
        this.faceValue = r;
        this.suit = suit;
    }

    public abstract  int value();

    public Suit suit(){
        return suit;
    }

  /** check if the card is available to be given out to someone */
  public boolean isAvailbale() {
    return isAvailable;
    }

    public void markUnavailable(){
      isAvailable = false;
    }

    public void markavailable(){
        isAvailable = true;
    }

}
