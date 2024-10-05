package cards;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class CardDeck extends ArrayList<Card> {
    
    public CardDeck() {
        this(true);
    }
    
    public CardDeck(boolean jokerIncludes) {
        List<Card> cardTemp = new LinkedList<>();
        
        for (int suit = 1; suit < 5; suit++) {
            for (int rank = 2; rank < 15; rank++) {
                cardTemp.add(new Card(suit, rank));
            }
        }
        
        if (jokerIncludes) {
            cardTemp.add(new Card());
        }
        
        Random random = new Random();
        
        while (!cardTemp.isEmpty()) {
            int i = random.nextInt(cardTemp.size());
            Card card = cardTemp.get(i);
            this.add(card);
            cardTemp.remove(i);
        }
    }
    
    public String toString() {
        String s = "";
        
        for (int i = 0; i < this.size(); i++) {
            s += this.get(i) + ",";
        }
        
        return s;
    }
    
    public Card popCard() {
        if (this.isEmpty()) {
            return null;
        }
        
        int i = this.size() - 1;
        Card lastCard = this.get(i);
        this.remove(i);
        
        return lastCard;
    }
}
