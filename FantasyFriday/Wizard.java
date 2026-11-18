public class Wizard extends Character {
    private int magicPower;

    public Wizard(String name,Weapon weapon,int magicPower) {
        super(name, weapon);
        this.magicPower = magicPower;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public String getDescription() {
        return (super.getDescription() + " and has a magic power of " + magicPower);
    }

    public static void main(String[] args) {
    }
}