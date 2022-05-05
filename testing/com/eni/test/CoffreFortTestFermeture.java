package com.eni.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eni.vault.bll.BLLException;


public class CoffreFortTestFermeture extends CoffreFortTest{
//	Vault vault;
//	Gold gold;
//
//	
//	@Before
//	public void initTest() {
//		this.vault = new Vault();
//	}
	
	@Test
	public void fermeture() throws BLLException {
		boolean excpected = true;

		this.vault.lock(goodPassword);
		
		Assert.assertEquals(excpected, this.vault.isLocked());
		/*
		 * Autre option
		 * Assert.assertTrue(this.vault.lock(goodPassword));
		 */
	}
	
	@Test (expected = BLLException.class)
	public void fermetureDejaFerme() throws BLLException {
		
		this.vault.lock(goodPassword);
		this.vault.lock(otherPassword);
	}
	
}
