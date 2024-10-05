package cards;


public class Test {

    public static void main(String[] args) {
        System.out.println("Generating a card deck.");
        CardDeck cardDeck1 = new CardDeck();
        System.out.println(cardDeck1);
        System.out.println(cardDeck1.size() + " cards");
        
        System.out.println("Take out the 1st card.");
        Card card1 = cardDeck1.popCard();
        System.out.println(cardDeck1);
        System.out.println(cardDeck1.size() + " cards");
        
        System.out.println("Take out the 2nd card.");
        Card card2 = cardDeck1.popCard();
        System.out.println("1st " + card1);
        System.out.println("2nd " + card2);
        
        System.out.println("Compare two cards.");
        System.out.println(card1 + " == " + card2 + " " + card1.equals(card2));
        System.out.println(card1 + " < " + card2 + " " + card1.smallerThan(card2));
        System.out.println(card1 + " > " + card2 + " " + card1.greaterThan(card2));
        
        System.out.println("Take out the last card.");
        while (!cardDeck1.isEmpty()) {
            cardDeck1.popCard();
        }
        System.out.println(cardDeck1);
        
        System.out.println("Does not include joker.");
        CardDeck cardDeck2 = new CardDeck(false);
        System.out.println(cardDeck2);
        System.out.println(cardDeck2.size() + " cards");
    }
}
