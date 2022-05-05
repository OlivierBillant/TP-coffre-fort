package com.eni.test;

import org.junit.Assert;
import org.junit.Test;

import com.eni.vault.bll.BLLException;

public class CoffreFortTestOuverture extends CoffreFortTest{
//	Vault vault = new Vault();

	@Test
	public void ouverture() throws BLLException {
		boolean excpected = false;
		this.vault.lock(goodPassword);
		this.vault.unlock(goodPassword);
		
		Assert.assertEquals(excpected, this.vault.isLocked());
		/*
		 * Alternative
		 * Assert.assertFalse(this.vault.isLocked());
		 */
	}
	
	@Test
	public void ouvertureWPW() throws BLLException {
		boolean excpected = false;
		this.vault.lock(goodPassword);
		this.vault.unlock(wrongPassword);
		Assert.assertNotEquals(excpected, this.vault.isLocked());
	}	
		
	@Test (expected = BLLException.class)
	public void ouvertureDejaOuvert() throws BLLException {
		this.vault.unlock(goodPassword);
	}	

}
