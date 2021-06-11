public class Human{
    protected int strength;
    protected int stealth;
    protected int intelligence;
    protected int health;

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
    
    public int getStealth(){
        return this.stealth;
    }

    public int getStrength(){
        return this.strength;
    }

    public int getIntelligence(){
        return this.intelligence;
    }
}