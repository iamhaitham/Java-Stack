public class Wizard extends Human{
    public Wizard(){
        this.health=50;
        this.intelligence=8;
    }

    public void heal(Human healed){
        healed.health+=this.intelligence;

    }

    public void fireball(Human fired){
        fired.health-=(this.intelligence*3);
    }
}