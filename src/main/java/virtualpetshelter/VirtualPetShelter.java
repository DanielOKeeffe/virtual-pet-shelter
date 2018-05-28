package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> pets = new HashMap<>();

	public void add(VirtualPet virtualPet) {
		pets.put(virtualPet.getName(), virtualPet);
	}

	public VirtualPet getPet(String petName) {
		return pets.get(petName);
	}

	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public void feedAllPets() {
		Collection<VirtualPet> feedingPets = pets.values();
		for (VirtualPet pet : feedingPets) {
			pet.feed(100);
		}
	}

	public void waterAllPets() {
		Collection<VirtualPet> wateringPets = pets.values();
		for (VirtualPet pet : wateringPets) {
			pet.water(100);
		}
	}

	public void tick() {
		Collection<VirtualPet> tickPets = pets.values();
		for (VirtualPet pet : tickPets) {
			pet.tick();
		}
	}

	public void remove(VirtualPet pet) {
		pets.remove(pet.getName());
	}
	
	public void displayAllPets() {
		System.out.println("Name" + "\t\t" + "Hunger" + "\t" + "Thirst" + "\t" + "Boredom");
		Collection<VirtualPet> displayPets = pets.values();
		for (VirtualPet pet : displayPets) {
			System.out.println(pet.getName() + "\t\t" + pet.getHunger() + "\t" + pet.getThirst() + "\t" + pet.getBoredom());
		}
	}
	
	public void displayAllPetDescriptions() {
		System.out.println("Name" + "\t\t" + "Description");
		Collection<VirtualPet> displayPets = pets.values();
		for (VirtualPet pet : displayPets) {
			System.out.println(pet.getName() + "\t\t" + pet.getDescription());
		}
	}

}