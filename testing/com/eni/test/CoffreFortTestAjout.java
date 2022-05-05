package com.eni.test;

import org.junit.Assert;
import org.junit.Test;

import com.eni.vault.bll.BLLException;


public class CoffreFortTestAjout extends CoffreFortTest {
//	Vault vault = new Vault();
//	Gold gold;
	
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

}
