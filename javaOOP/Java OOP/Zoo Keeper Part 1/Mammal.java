package codingdojo.OOP.ZooKeeper1;

public class Mammal {
	private int energyLevel=100;
	
	public int displayEnergy() {
		System.out.println(this.energyLevel);
		return this.energyLevel;
	}
	public void decreaseEnergy(int loss) {
		this.energyLevel-=loss;
	}
	public void increaseEnergy(int loss) {
		this.energyLevel+=loss;
	}
}
