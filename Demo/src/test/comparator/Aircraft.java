package test.comparator;

public class Aircraft {

	public String name;
	public Integer speed;
	public Integer weight;
	
	public Aircraft(String name, Integer speed, Integer weight) {
		super();
		this.name = name;
		this.speed = speed;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
}
