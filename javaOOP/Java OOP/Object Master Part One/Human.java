public class Human{
    private int strength;
    private int stealth;
    private int intelligence;
    private int health;

    public Human(){
        this.strength=3;
        this.stealth=3;
        this.intelligence=3;
        this.health=100;
    }

    public void attack(Human attacked){
        attacked.health-=this.strength;
    }

    public int getHealth(){
        return this.health;
    }
}