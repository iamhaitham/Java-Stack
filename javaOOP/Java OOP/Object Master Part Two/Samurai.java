public class Samurai extends Human{
    private static int counter=0;
    
    public Samurai(){
        this.health=200;
        counter+=1;
    }

    public void deathBlow(Human dead){
        this.health/=2;
        dead.health=0;
    }

    public void meditate(){
        this.health*=1.5;
        if(this.health>200){
            this.health=200;
        }
    }

    public int howMany(){
        return counter;
    }


}