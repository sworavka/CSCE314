// package week10_friday;

public class Character {
    private String name;
    private Weapon weapon;

    private static int characterCount = 0;

    public Character(String name, Weapon weapon){
        characterCount+= 1;
        this.name = name;
        this.weapon = weapon;
    }
    public String getName(){return name;}
    public Weapon getWeapon(){return weapon;}
    public static int getCharacterCount(){return characterCount;}
    public int attack(){
        return weapon.attack();
    }
    public String getDescription(){
        return (name + " carries " + weapon.getDescription());
    }

   public static void main(String[] args) {
    
   } 
}
