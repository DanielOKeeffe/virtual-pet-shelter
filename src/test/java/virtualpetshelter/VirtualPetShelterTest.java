package virtualpetshelter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualPetShelterTest {
	
	@Test
	public void shouldHaveHungerOf50() {
		VirtualPet underTest = new VirtualPet(50, 0, 0, false, false);
		int check = underTest.getHunger();
		assertEquals(check, 50);
	}

	@Test
	public void shouldHaveHungerOf100() {
		VirtualPet underTest = new VirtualPet(100, 0, 0, false, false);
		int check = underTest.getHunger();
		assertEquals(check, 100);
	}

	@Test
	public void shouldHaveHungerOf25AfterFeeding() {
		VirtualPet underTest = new VirtualPet(50, 0, 0, false, false);
		underTest.feed(25);
		int check = underTest.getHunger();
		assertEquals(check, 25);
	}

	@Test
	public void shouldHaveHungerOf0AfterFeeding25() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, false, false);
		underTest.feed(25);
		int check = underTest.getHunger();
		assertEquals(check, 0);
	}

	@Test
	public void shouldHaveThirstOf100() {
		VirtualPet underTest = new VirtualPet(100, 100, 0, false, false);
		int check = underTest.getThirst();
		assertEquals(check, 100);
	}

	@Test
	public void shouldHaveThirstOf25AfterWatering25() {
		VirtualPet underTest = new VirtualPet(100, 50, 0, false, false);
		underTest.water(25);
		int check = underTest.getThirst();
		assertEquals(check, 25);
	}

	@Test
	public void shoulHaveThirstOf0AfterWatering25() {
		VirtualPet underTest = new VirtualPet(100, 0, 0, false, false);
		underTest.water(25);
		int check = underTest.getThirst();
		assertEquals(check, 0);
	}

	@Test
	public void shouldHaveBoredomOf100AfterPlaying25() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, false, false);
		underTest.play(25);
		int check = underTest.getBoredom();
		assertEquals(check, 0);
	}

	@Test
	public void shouldHaveHungerOf10AfterTick() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, false, false);
		underTest.tick();
		int check = underTest.getHunger();
		assertEquals(check, 10);
	}

	@Test
	public void shouldHaveHungerOf0AfterTick() {
		VirtualPet underTest = new VirtualPet(100, 100, 100, false, false);
		underTest.tick();
		int check = underTest.getHunger();
		assertEquals(check, 100);
	}

	@Test
	public void petIsSickShouldBeFalse() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, false, false);
		boolean check = underTest.getSickness();
		assertFalse(check);
	}

	@Test
	public void petIsSickShouldBeTrue() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, true, false);
		boolean check = underTest.getSickness();
		assertTrue(check);
	}

	@Test
	public void petIsSickShouldBeFalseAfterMedicine() {
		VirtualPet underTest = new VirtualPet(0, 0, 0, true, false);
		underTest.giveMedicine();
		boolean check = underTest.getSickness();
		assertFalse(check);
	}

}
