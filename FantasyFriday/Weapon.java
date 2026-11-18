public class Weapon {
    private String name;
    private int sides;
    public Weapon(String name, int sides){
        this.name = name;
        this.sides = sides;
    }
    public String getName(){return name;}
    public int getSides(){return sides;}
    public int attack(){
        return Dice.roll(sides);
    }
    public String getDescription(){
        return (name + " d" + String.valueOf(sides));
    }
    
public static void main(String[] args) {
    
   } 

    
}