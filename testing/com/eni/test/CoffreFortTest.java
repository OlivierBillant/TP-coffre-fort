package com.eni.test;

import org.junit.Assert;
import org.junit.Test;

import com.eni.vault.bll.BLLException;
import com.eni.vault.bll.Vault;
import com.eni.vault.bo.Gold;

public class CoffreFortTest {
	Vault vault = new Vault();
	Gold gold;
	
	@Test
	public void fermeture() throws BLLException {
		boolean excpected = true;
		
		String password = "motdepasse";

		this.vault.lock(password);
		
		Assert.assertEquals(excpected, this.vault.isLocked());
	}
	
	@Test (expected = BLLException.class)
	public void fermetureDejaFerme() throws BLLException {
		boolean excpected = true;
		
		String password = "motdepasse";
		String newPassword = "123";

		this.vault.lock(password);
		this.vault.lock(newPassword);
		
		Assert.assertEquals(excpected, this.vault.isLocked());
	}
	
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
	
	@Test
	public void ajouter() throws BLLException {
		int excpected = 1;
		
		Assert.assertEquals(excpected, this.vault.addObject(gold));
	}
	
	@Test (expected = BLLException.class)
	public void ajouterCoffreFerme() throws BLLException {
		int excpected = 1;
		this.vault.lock("motdepasse");
		Assert.assertEquals(excpected, this.vault.addObject(gold));
	}
	
	@Test
	public void enlever() throws BLLException {
		int excpected = 0;
		
		this.vault.addObject(gold);
		Assert.assertEquals(excpected, this.vault.removeObject(gold));
	}
	
	@Test (expected = BLLException.class)
	public void enleverCoffreFerme() throws BLLException {
		int excpected = 0;
		
		this.vault.addObject(gold);
		this.vault.lock("motdepasse");
		this.vault.lock("motdepasse");
		Assert.assertEquals(excpected, this.vault.removeObject(gold));
	}
}
