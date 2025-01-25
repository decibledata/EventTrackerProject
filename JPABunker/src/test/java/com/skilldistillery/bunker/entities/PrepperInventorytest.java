package com.skilldistillery.bunker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class PrepperInventorytest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private PrepperInventory prep;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPABunker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		prep = em.find(PrepperInventory.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		prep = null;
	}

	@Test
	void test() {
		assertNotNull(prep);
		assertEquals("Food", prep.getName());
	}

}
