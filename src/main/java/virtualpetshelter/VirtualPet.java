package virtualpetshelter;

public class VirtualPet {
	
	private int hunger;
	private int thirst;
	private int boredom;
	private boolean sickness;
	private double randomizedSickness;
	private boolean freeWill;
	private double randomizedFreeWill;

	public VirtualPet(int hunger, int thirst, int boredom, boolean sickness, boolean freeWill) {
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
		this.sickness = sickness;
		this.freeWill = freeWill;
	}

	public int getHunger() {
		return hunger;
	}

	public void feed(int food) {
		if (hunger - food >= 0) {
			hunger -= food;
		} else {
			hunger = 0;
		}
	}

	public int getThirst() {
		return thirst;
	}

	public void water(int volume) {
		if (thirst - volume >= 0) {
			thirst -= volume;
		} else {
			thirst = 0;
		}
	}

	public int getBoredom() {
		return boredom;
	}

	public void play(int time) {
		if (boredom - time >= 0) {
			boredom -= time;
		} else {
			boredom = 0;
		}
	}

	public void tick() {
		if (hunger <= 90) {
			hunger += 10;
		} else {
			hunger = 100;
		}
		if (thirst <= 90) {
			thirst += 10;
		} else {
			thirst = 100;
		}
		if (boredom <= 90) {
			boredom += 10;
		} else {
			boredom = 100;
		}
		randomizeSickness();
		randomizeFreeWill();
	}

	public boolean getSickness() {
		if (sickness == false) {
			return false;
		} else {
			return true;
		}
	}

	public void giveMedicine() {
		sickness = false;
	}

	public void randomizeSickness() {
		if (sickness == true) {
			//if sickness is true do not randomize state of sickness
		} else {
			randomizedSickness = Math.random() * 100;
			if (randomizedSickness < 30) {
				sickness = true;
			} else {
				sickness = false;
			}
		}
	}

	public boolean getFreeWill() {
		if (freeWill == false) {
			return false;
		} else {
			return true;
		}
	}

	public void randomizeFreeWill() {
		randomizedFreeWill = Math.random() * 100;
		if (randomizedFreeWill < 30) {
			freeWill = true;
		} else {
			freeWill = false;
		}
	}

}
