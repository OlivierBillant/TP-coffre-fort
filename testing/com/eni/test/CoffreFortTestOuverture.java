package com.eni.test;

import org.junit.Assert;
import org.junit.Test;

import com.eni.vault.bll.BLLException;

public class CoffreFortTestOuverture extends CoffreFortTest{
//	Vault vault = new Vault();

	@Test
	public void ouverture() throws BLLException {
		boolean excpected = false;
		String password = "motdepasse";
		this.vault.lock("motdepasse");
		this.vault.unlock(password);
		
		Assert.assertEquals(excpected, this.vault.isLocked());
	}
	
	@Test
	public void ouvertureWPW() throws BLLException {
		boolean excpected = false;
		String password = "mauvaisMdp";
		this.vault.lock("motdepasse");
		this.vault.unlock(password);
		Assert.assertNotEquals(excpected, this.vault.isLocked());
	}	
		
	@Test (expected = BLLException.class)
	public void ouvertureDejaOuvert() throws BLLException {
		boolean excpected = false;
		String password = "password";
		this.vault.unlock(password);
		Assert.assertNotEquals(excpected, this.vault.isLocked());
	}	

}
