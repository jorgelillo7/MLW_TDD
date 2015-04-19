package models;

import utils.Suit;

public class CardFactory {
    
    
    public static Card getCard(int value, int suitNum) {
        switch (suitNum) {
        case 0:
            return new SpadesCard(value);
        case 1:
            return new HeartsCard(value);
        case 2:
            return new DiamondsCard(value);
        case 3:
            return new ClubsCard(value);
        }
        return null;
        
    }
    
    public static Card getCard(int value, Suit suit) {
        switch (suit) {
        case SPADES:
            return new SpadesCard(value);
        case CLUBS:
            return new ClubsCard(value);
        case HEARTS:
            return new HeartsCard(value);
        case DIAMONDS:
            return new DiamondsCard(value);
        }
        return null;
    }

}
