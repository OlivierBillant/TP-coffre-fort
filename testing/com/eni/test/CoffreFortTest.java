package com.eni.test;

import static org.junit.Assert.*;

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
	
	@Test (expected = BLLException.class)
	public void ouverture() throws BLLException {
		boolean excpected = false;
		String password = "motdepasse";
		this.vault.lock("motdepasse");
		this.vault.unlock(password);
		
		Assert.assertEquals(excpected, this.vault.isLocked());
		
		String password2 = "mauvaisMdp";
		//Commenter ligne suivante pour levée d'expection
		this.vault.lock("motdepasse");
		this.vault.unlock(password2);
		Assert.assertNotEquals(excpected, this.vault.isLocked());
		
		
		
	}
	
	@Test
	public void ajouter() throws BLLException {
		int excpected = 1;
		//Décommenter ligne suivante pour lever d'exception
//		this.vault.lock("motdepasse");
		
		Assert.assertEquals(excpected, this.vault.addObject(gold));
	}
}
