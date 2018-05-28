package virtualpetshelter;

import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		VirtualPetShelter myPetShelter = new VirtualPetShelter();

		VirtualPet julius = new VirtualPet("Julius", "Loves to play!");
		VirtualPet trevor = new VirtualPet("Trevor", "Is always hungry.");
		VirtualPet maxine = new VirtualPet("Maxine", "Is a little shy.");
		VirtualPet judith = new VirtualPet("Judith", "Hopes to be a ballerina someday.");

		myPetShelter.add(julius);
		myPetShelter.add(trevor);
		myPetShelter.add(maxine);
		myPetShelter.add(judith);

		System.out.println("Welcome to the friendly crocodile rescue shelter!");
		System.out.println();

		String choice = "";

		do {
			System.out.println("Here are the pets in our shelter:");
			myPetShelter.displayAllPets();
			myPetShelter.tick();
			System.out.println();

			Collection<VirtualPet> pets = myPetShelter.getAllPets();
			for (VirtualPet pet : pets) {
				if (pet.getSickness() == true) {
					System.out.println(pet.getName() + " is sick and needs medicine!");
				}
			}
			System.out.println();

			System.out.println("What would you like to do?");
			System.out.println();
			System.out.println("1. Feed the pets");
			System.out.println("2. Water the pets");
			System.out.println("3. Play with a pet");
			System.out.println("4. Adopt a pet");
			System.out.println("5. Admit a pet");
			System.out.println("6. Give medicine to a pet");
			System.out.println("7. Leave the shelter");
			choice = input.nextLine();

			if (choice.equals("1")) {
				myPetShelter.feedAllPets();
				System.out.println("Yum! The crocodiles love the food you gave them!");
				System.out.println();

			} else if (choice.equals("2")) {
				myPetShelter.waterAllPets();
				System.out.println("Wow! The crocodiles love water!");
				System.out.println();

			} else if (choice.equals("3")) {
				System.out.println("Which pet would you like to play with?");
				System.out.println();
				myPetShelter.displayAllPetDescriptions();
				String playChoice = input.nextLine();
				VirtualPet playingPet = myPetShelter.getPet(playChoice);
				System.out.println("How long would you like to play with " + playChoice + "?");
				int playTime = input.nextInt();
				input.nextLine();

				if (playingPet.getSickness() == true) {
					System.out.println(playChoice + " is not feeling well and does not want to play right now.");
					System.out.println();

				} else {
					if (playingPet.getFreeWill() == false) {
						playingPet.play(playTime);
						System.out.println("You take a step back and " + playChoice + " performs DEATHROLL!");
						System.out.println();
						System.out.println(playChoice + " is so happy to play with you!");
						System.out.println();
					} else {
						System.out.println(playChoice + " growls at you and goes to get a snack instead.");
						System.out.println();
						playingPet.feed(25);
					}
				}

			} else if (choice.equals("4")) {
				if (myPetShelter.getAllPets().isEmpty()) {
					System.out.println("There are no pets to adopt right now! Come back soon!");
				} else {
					System.out.println("You have chosen to adopt a pet.");
					System.out.println("Which pet would you like to adopt?");
					myPetShelter.displayAllPetDescriptions();
					String adoptionChoice = input.nextLine();
					VirtualPet adoptionPet = myPetShelter.getPet(adoptionChoice);
					myPetShelter.remove(adoptionPet);
					System.out.println("You have chosen to adopt " + adoptionChoice + ".");
					System.out.println("Thank you for adopting " + adoptionChoice + "!");
					System.out.println(adoptionChoice + " is so excited to go home with you!");
					System.out.println();
				}

			} else if (choice.equals("5")) {
				System.out.println("You have chosen admit a pet.");
				System.out.println("What is the name of the pet you are admitting?");
				String admitPetName = input.nextLine();
				System.out.println("What is a description of " + admitPetName + "?");
				String admitPetDescription = input.nextLine();
				VirtualPet admitPet = new VirtualPet(admitPetName, admitPetDescription);
				myPetShelter.add(admitPet);
				System.out.println("Thank you for admitting a pet! We will take great care of it!");
				System.out.println();

			} else if (choice.equals("6")) {
				System.out.println("You have chosen to give a pet medicine.");
				System.out.println("Which pet would you like to give medicine to?");
				System.out.println();
				myPetShelter.displayAllPetDescriptions();
				String curePetName = input.nextLine();
				VirtualPet curePet = myPetShelter.getPet(curePetName);

				if (curePet.getSickness() == true) {
					curePet.giveMedicine();
					System.out.println("Thank you for giving " + curePetName + " medicine!");
					System.out.println(curePetName + " is feeling much better!");
					System.out.println();
				} else {
					System.out.println(curePetName + " is feeling fine and does not need medicine.");
					System.out.println();
				}

			}
		} while (!choice.equals("7"));

		System.out.println("Thank you for visiting the friendly crocodile rescue shelter! Please come back soon!");
	}

}
