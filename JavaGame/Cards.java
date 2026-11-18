public class Cards {
    public static String[] createDeck() {
        String[] deck = new String[52];
        int index = 0;
        for (String suit : new String[]{"Hearts", "Diamonds", "Clubs", "Spades"}) {
            for (int i = 1; i <= 13; i++) {
                if(i==1) {
                    deck[index++] = "Ace of " + suit;
                } else if(i==11) {
                    deck[index++] = "Jack of " + suit;
                } else if(i==12) {
                    deck[index++] = "Queen of " + suit;
                } else if(i==13) {
                    deck[index++] = "King of " + suit;
                } else {
                    deck[index++] = i + " of " + suit;
                }
            }
        }
        return deck;
    }
    public static void main(String[] args){
        String[] deck = createDeck();
        for(String card : deck){
            System.out.println(card);
        }
    }
}
