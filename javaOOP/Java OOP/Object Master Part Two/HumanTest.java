public class HumanTest{
    public static void main(String[] args){
        Human John=new Human();
        Human Jack=new Human();
        Human Amy=new Human();
        Jack.attack(John);
        Jack.attack(John);
        System.out.println(John.getHealth());
        System.out.println(Jack.getHealth());
        System.out.println(Amy.getHealth());

        Ninja ninja1=new Ninja();
        System.out.println("ninja1 has health of "+ninja1.getHealth()+", stealth of "+ninja1.getStealth()+", intelligence of "+ninja1.getIntelligence()+", and strength of "+ninja1.getStrength());
        System.out.println("ninja1 has stolen from Jack!!");
        ninja1.steal(Jack);
        System.out.println("ninja1 now has health of "+ninja1.getHealth()+", stealth of "+ninja1.getStealth()+", intelligence of "+ninja1.getIntelligence()+", and strength of "+ninja1.getStrength());
        System.out.println("Now ninja1 is running away!!");
        ninja1.runAway();
        System.out.println("ninja1 now has health of "+ninja1.getHealth()+", stealth of "+ninja1.getStealth()+", intelligence of "+ninja1.getIntelligence()+", and strength of "+ninja1.getStrength());
        

        Wizard wizard1=new Wizard();
        Wizard wizard2=new Wizard();
        wizard1.fireball(John);
        System.out.println("John has health of "+ John.getHealth() +" after being shot");
        wizard2.heal(John);
        System.out.println("John has health of "+ John.getHealth() +" after being healed");

        Samurai samurai1=new Samurai();
        System.out.println("samurai1 now has health of "+samurai1.getHealth()+", stealth of "+samurai1.getStealth()+", intelligence of "+samurai1.getIntelligence()+", and strength of "+samurai1.getStrength());
        System.out.println("samurai1 has killed Amy");
        samurai1.deathBlow(Amy);
        System.out.println("Amy is now dead and thus her health equals "+Amy.getHealth());
        System.out.println("and our samurai has his health decreased to "+samurai1.getHealth());
        System.out.println("We have "+samurai1.howMany()+ " samurais until now");
        samurai1.meditate();
        System.out.println("samurai1 now has health of "+samurai1.getHealth()+", stealth of "+samurai1.getStealth()+", intelligence of "+samurai1.getIntelligence()+", and strength of "+samurai1.getStrength());
        Samurai samurai2=new Samurai();
        Samurai samurai3=new Samurai();
        System.out.println("We have "+samurai3.howMany()+ " samurais until now");

    }
}