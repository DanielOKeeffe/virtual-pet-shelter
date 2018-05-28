package virtualpetshelter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest;
	VirtualPet pet1;
	VirtualPet pet2;

	@Before
	public void setUp() {
		underTest = new VirtualPetShelter();
		pet1 = new VirtualPet("Julius", 0, 0, 0, false, false, "Loves to play!", 0);
		pet2 = new VirtualPet("Trevor", 0, 0, 0, false, false, "Is a little shy.", 0);
	}

	@Test
	public void shouldHaveHungerOf50() {
		VirtualPet underTest = new VirtualPet("", 50, 0, 0, false, false, "", 0);
		int check = underTest.getHunger();
		assertEquals(check, 50);
	}

	@Test
	public void shouldHaveHungerOf100() {
		VirtualPet underTest = new VirtualPet("", 100, 0, 0, false, false, "", 0);
		int check = underTest.getHunger();
		assertEquals(check, 100);
	}

	@Test
	public void shouldHaveHungerOf25AfterFeeding() {
		VirtualPet underTest = new VirtualPet("", 50, 0, 0, false, false, "", 0);
		underTest.feed(25);
		int check = underTest.getHunger();
		assertEquals(check, 25);
	}

	@Test
	public void shouldHaveHungerOf0AfterFeeding25() {
		VirtualPet underTest = new VirtualPet("", 0, 0, 0, false, false, "", 0);
		underTest.feed(25);
		int check = underTest.getHunger();
		assertEquals(check, 0);
	}

	@Test
	public void shouldHaveThirstOf100() {
		VirtualPet underTest = new VirtualPet("", 100, 100, 0, false, false, "", 0);
		int check = underTest.getThirst();
		assertEquals(check, 100);
	}

	@Test
	public void shouldHaveThirstOf25AfterWatering25() {
		VirtualPet underTest = new VirtualPet("", 100, 50, 0, false, false, "", 0);
		underTest.water(25);
		int check = underTest.getThirst();
		assertEquals(check, 25);
	}

	@Test
	public void shoulHaveThirstOf0AfterWatering25() {
		VirtualPet underTest = new VirtualPet("", 100, 0, 0, false, false, "", 0);
		underTest.water(25);
		int check = underTest.getThirst();
		assertEquals(check, 0);
	}

	@Test
	public void shouldHaveBoredomOf0AfterPlaying25() {
		VirtualPet underTest = new VirtualPet("", 0, 0, 0, false, false, "", 0);
		underTest.play(25);
		int check = underTest.getBoredom();
		assertEquals(check, 0);
	}

	@Test
	public void shouldHaveHungerOf10AfterTick() {
		VirtualPet underTest = new VirtualPet("", 0, 0, 0, false, false, "", 0);
		underTest.tick();
		int check = underTest.getHunger();
		assertEquals(check, 10);
	}

	@Test
	public void shouldHaveHungerOf100AfterTick() {
		VirtualPet underTest = new VirtualPet("", 100, 100, 100, false, false, "", 0);
		underTest.tick();
		int check = underTest.getHunger();
		assertEquals(check, 100);
	}

	@Test
	public void petIsSickShouldBeFalse() {
		VirtualPet underTest = new VirtualPet("", 0, 0, 0, false, false, "", 0);
		boolean check = underTest.getSickness();
		assertFalse(check);
	}

	@Test
	public void petIsSickShouldBeTrue() {
		VirtualPet underTest = new VirtualPet("", 0, 0, 0, true, false, "", 0);
		boolean check = underTest.getSickness();
		assertTrue(check);
	}

	@Test
	public void petIsSickShouldBeFalseAfterMedicine() {
		VirtualPet underTest = new VirtualPet("", 0, 0, 0, true, false, "", 0);
		underTest.giveMedicine();
		boolean check = underTest.getSickness();
		assertFalse(check);
	}

	@Test
	public void shouldReturnNameJulius() {
		VirtualPet underTest = new VirtualPet("Julius", 0, 0, 0, false, false, "", 0);
		String check = underTest.getName();
		assertEquals(check, "Julius");
	}

	@Test
	public void shouldReturnNameTrevor() {
		VirtualPet underTest = new VirtualPet("Trevor", 0, 0, 0, false, false, "", 0);
		String check = underTest.getName();
		assertEquals(check, "Trevor");
	}

	@Test
	public void shouldReturnDescriptionOfLovesToPlay() {
		VirtualPet underTest = new VirtualPet("", 0, 0, 0, false, false, "Loves to play!", 0);
		String check = underTest.getDescription();
		assertEquals(check, "Loves to play!");
	}

	@Test
	public void shouldBeAbleToAddPet() {
		underTest.add(pet1);
		VirtualPet check = underTest.getPet("Julius");
		assertThat(check, is(pet1));
	}

	@Test
	public void shouldBeAbleToAddTwoPets() {
		underTest.add(pet1);
		underTest.add(pet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(pet1, pet2));
	}
	
	@Test
	public void shouldHaveHungerOf30() {
		VirtualPet newPet = new VirtualPet("Julius", "Loves to play!");
		int checkHunger = newPet.getHunger();
		assertThat(checkHunger, is(30));
	}
	
	@Test
	public void shouldHaveThirstOf30AfterAdding() {
		VirtualPet newPet = new VirtualPet("Julius", "Loves to play!");
		underTest.add(newPet);
		VirtualPet check = underTest.getPet("Julius");
		int checkThirst = check.getThirst();
		assertThat(checkThirst, is(30));
	}
	
	@Test
	public void allPetsShouldHaveHungerOf0AfterFeeding() {
		VirtualPet pet1 = new VirtualPet("Julius", 100, 100, 100, false, false, "Loves to play!", 0);
		VirtualPet pet2 = new VirtualPet("Trevor", 100, 100, 100, false, false, "Is a little shy.", 0);
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.feedAllPets();
		VirtualPet check1 = underTest.getPet("Julius");
		VirtualPet check2 = underTest.getPet("Trevor");
		int checkHunger1 = check1.getHunger();
		int checkHunger2 = check2.getHunger();
		assertThat(checkHunger1, is(0));
		assertThat(checkHunger2, is(0));
	}
	
	@Test
	public void allPetsShouldHaveThirstOf0AfterWatering() {
		VirtualPet pet1 = new VirtualPet("Julius", 100, 100, 100, false, false, "Loves to play!", 0);
		VirtualPet pet2 = new VirtualPet("Trevor", 100, 100, 100, false, false, "Is a little shy.", 0);
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.waterAllPets();
		VirtualPet check1 = underTest.getPet("Julius");
		VirtualPet check2 = underTest.getPet("Trevor");
		int checkThirst1 = check1.getThirst();
		int checkThirst2 = check2.getThirst();
		assertThat(checkThirst1, is(0));
		assertThat(checkThirst2, is(0));
	}
	
	@Test
	public void allPetsShouldHaveHungerOf40AfterTick() {
		VirtualPet pet1 = new VirtualPet("Julius", 30, 100, 100, false, false, "Loves to play!", 0);
		VirtualPet pet2 = new VirtualPet("Trevor", 30, 100, 100, false, false, "Is a little shy.", 0);
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.tick();
		VirtualPet check1 = underTest.getPet("Julius");
		VirtualPet check2 = underTest.getPet("Trevor");
		int checkHunger1 = check1.getHunger();
		int checkHunger2 = check2.getHunger();
		assertThat(checkHunger1, is(40));
		assertThat(checkHunger2, is(40));
	}
	
	@Test
	public void shouldBeAbleToRemovePet() {
		underTest.add(pet1);
		underTest.add(pet2);
		underTest.remove(pet1);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(pet2));
	}
	
}
