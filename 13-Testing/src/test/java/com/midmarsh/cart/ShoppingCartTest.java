package com.midmarsh.cart;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {

	private ShoppingCart cart = new ShoppingCart();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	void testAddingItemToShoppingCart() {
		cart.add("Cornflakes");
		boolean added = cart.contains("Cornflakes");
		Assertions.assertTrue(added, "Cornflakes should be in cart");
	}

	@Disabled
	@Test
	void testingListingShoppingCart() {
		List<String> contents = cart.listContents();
		// ...
	}

	@Test
	void testingRemovingUnavailableItem() {
		Assertions.assertThrows(MissingItemException.class, () -> cart.remove("Bread"));
	}

}
