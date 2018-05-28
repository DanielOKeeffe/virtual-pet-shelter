package virtualpetshelter;

public class VirtualPet {
	
	private String petName;
	private int hunger;
	private int thirst;
	private int boredom;
	private boolean sickness;
	private double randomizedSickness;
	private boolean freeWill;
	private double randomizedFreeWill;
	private String petDescription;
	private double randomizedAction;

	public VirtualPet(String petName, int hunger, int thirst, int boredom, boolean sickness, boolean freeWill, String petDescription, double randomizedAction) {
		this.petName = petName;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
		this.sickness = sickness;
		this.freeWill = freeWill;
		this.petDescription = petDescription;
		this.randomizedAction = randomizedAction;
	}

	public VirtualPet(String petName, String petDescription) {
		this.petName = petName;
		this.hunger = 30;
		this.thirst = 30;
		this.boredom = 30;
		this.sickness = false;
		this.freeWill = false;
		this.petDescription = petDescription;
		this.randomizedAction = 50;
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
		randomizeAction();
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
			if (randomizedSickness < 3) {
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

	public String getName() {
		return petName;
	}

	public String getDescription() {
		return petDescription;
	}
	
	public void randomizeAction() {
		randomizedAction = Math.random() * 100;
	}
	
	public double getRandomizedAction() {
		return randomizedAction;
	}

}
