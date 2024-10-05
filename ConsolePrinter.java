package view;

import cards.CardField;


public class ConsolePrinter {
    
    public void printStart() {
        System.out.println("Start High & Low!!");
    }
    
    public void printQuestion(CardField cf) {        
        System.out.println("");
        
        String s = cf.toString().replace(",", "|");
        System.out.println("|" + s + "??|");
        
        System.out.println("h:high l:low");
        System.out.print("> ");
    }
    
    public void printResult(CardField cf) {
        System.out.println("");
        
        String rslt = cf.getResult();
        switch (rslt) {
            case "WIN":
                rslt += "!!";
                break;
            case "LOSE":
                rslt += "...";
                break;
            case "DRAW":
                rslt += "!";
                break;
        }
        System.out.print(rslt + " ");
        
        int wCnt = cf.getWinCount();
        int dCnt = cf.getDrawCount();
        System.out.println("(WIN:" + wCnt + " DRAW:" + dCnt + ")");
        
        String s = cf.toString().replace(",","|");
        System.out.println("|" + s);
    }
    
    public void printContinue() {
        System.out.println("");
        System.out.println("Continue? (y/n)");
        System.out.print("> ");
    }
    
    public void printQuit(CardField cf) {
        System.out.println("");
        System.out.println("You Won " + cf.getWinCount() + " Times!");
        System.out.println("Thanks for Playing!!");
    }
}
