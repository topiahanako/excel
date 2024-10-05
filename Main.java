package main;

import java.util.Scanner;

import cards.Card;
import cards.CardDeck;
import cards.CardField;
import view.ConsolePrinter;


public class Main {
    
    public static void main(String[] args) {
        ConsolePrinter console = new ConsolePrinter();
        console.printStart();
        
        try (Scanner scanner = new Scanner(System.in)) {
            CardDeck deck = new CardDeck();
            Card firstCard = deck.popCard();
            
            CardField field = new CardField();
            field.add(firstCard);
            
            while (!deck.isEmpty()) {
                String input = null;
                
                while (true) {
                    console.printQuestion(field);
                    
                    input = scanner.nextLine();
                    
                    if (input.equals("h")) {
                        input = "high";
                        break;
                    }
                    
                    if (input.equals("l")) {
                        input = "low";
                        break;
                    }
                }
                
                Card nextCard = deck.popCard();
                
                field.calcResult(nextCard, input);
                field.add(nextCard);
                
                console.printResult(field);
                
                if (field.getResult().equals("LOSE")) {
                    break;
                }
                
                input = null;
                
                while (true) {
                    console.printContinue();
                    
                    input = scanner.nextLine();
                    
                    if (input.matches("[yn]")) {
                        break;
                    }
                }
                
                if (input.equals("n")) {
                    console.printQuit(field);
                    break;
                }
            }
            
            console.printQuit(field);
        }
    }
}
