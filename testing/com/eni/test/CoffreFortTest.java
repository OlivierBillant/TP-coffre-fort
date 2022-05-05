package com.eni.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.eni.vault.bll.BLLException;
import com.eni.vault.bll.Vault;

public class CoffreFortTest {
	Vault vault = new Vault();
	boolean statut;

	@Test
	public void fermeture() throws BLLException {
		boolean excpected = true;
		statut = false;
		
		String password = "motdepasse";

		this.vault.lock(password);
		
		Assert.assertEquals(excpected, this.vault.isLocked());
	}
	
	@Test
	public void ouverture() throws BLLException {
		boolean excpected = false;
		String password = "mauvaisMdp";
		this.vault.lock("motdepasse");
		this.vault.unlock(password);
		
		Assert.assertEquals(excpected, this.vault.isLocked());
	}
}
