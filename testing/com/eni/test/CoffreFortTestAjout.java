package com.eni.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.eni.vault.bll.BLLException;
import com.eni.vault.bll.Vault;
import com.eni.vault.bo.Gold;

public class CoffreFortTestAjout {
	Vault vault = new Vault();
	Gold gold;
	
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
