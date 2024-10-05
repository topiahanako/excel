package cards;


public class Card {
    
    private int suit;
    private int rank;
    
    public Card() {
        this(5, 15);
    }
    
    public Card(int suit, int rank) {
        this.setSuit(suit);
        this.setRank(rank);
    }
    
    public int getSuit() {
        return this.suit;
    }
    
    public int getRank() {
        return this.rank;
    }
    
    public void setRank(int rank) {
        if (rank < 2 || 15 < rank) {
            throw new IllegalArgumentException("Rank value is out of range.");
        }
        
        this.rank = rank;
    }
    
    public void setSuit(int suit) {
        if (suit < 1 || 5 < suit ) {
            throw new IllegalArgumentException("Suit value is out of range.");
        }
        
        this.suit = suit;
    }
    
    public String getSuitName() {
        String suitName = null;
        
        switch (this.getSuit()) {
            case 1:
                suitName = "club";
                break;
            case 2:
                suitName = "diamond";
                break;
            case 3:
                suitName = "heart";
                break;
            case 4:
                suitName = "spade";
                break;
            case 5:
                suitName = "joker";
                break;
        }
        
        return suitName;
    }
    
    public char getRankChar() {
        char rankChar = 0;
        
        switch (this.getRank()) {
            case 10:
                rankChar = 'T';
                break;
            case 11:
                rankChar = 'J';
                break;
            case 12:
                rankChar = 'Q';
                break;
            case 13:
                rankChar = 'K';
                break;
            case 14:
                rankChar = 'A';
                break;
            default:
                rankChar = Character.forDigit(this.getRank(), 10);
                break;
        }
        
        return rankChar;
    }
    
    public String toString() {
        if (this.getRankChar() == 0) {
            return "JK";
        }
        
        return this.getSuitName().substring(0, 1) + this.getRankChar();
    }
    
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null cannot be used.");
        }
        
        if (this == obj) {
            return true;
        }
        
        if (obj instanceof Card c) {
            return this.getRank() == c.getRank();
        } else {
            throw new ClassCastException("Cannot cast argument.");
        }
    }
    
    public boolean smallerThan(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null cannot be used.");
        }
        
        if (obj instanceof Card c) {
            if (this.getRank() == c.getRank()) {
                return this.getSuit() < c.getSuit();
            } else {
                return this.getRank() < c.getRank();
            }
        } else {
            throw new ClassCastException("Cannot cast argument.");
        }
    }
    
    public boolean greaterThan(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null cannot be used.");
        }
        
        if (obj instanceof Card c) {
            if (this.getRank() == c.getRank()) {
                return this.getSuit() > c.getSuit();
            } else {
                return this.getRank() > c.getRank();
            }
        } else {
            throw new ClassCastException("Cannot cast argument.");
        }
    }
}
