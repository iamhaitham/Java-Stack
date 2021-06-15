package codingdojo.OOP.ZooKeeper1;

public class Gorilla extends Mammal{
	public void throwSomething() {
		System.out.println("the gorilla has thrown something");
		decreaseEnergy(5);
	}
	public void eatBananas() {
		System.out.println("Gorilla is satisfied :) ");
		increaseEnergy(10);
		}
	public void climb() {
		System.out.println("the gorilla has climbed a tree");
		decreaseEnergy(5);
	}
}
