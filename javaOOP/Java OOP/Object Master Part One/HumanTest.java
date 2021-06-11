public class HumanTest{
    public static void main(String[] args){
        Human John=new Human();
        Human Jack=new Human();
        Jack.attack(John);
        Jack.attack(John);
        System.out.println(John.getHealth());
        System.out.println(Jack.getHealth());
    }
}