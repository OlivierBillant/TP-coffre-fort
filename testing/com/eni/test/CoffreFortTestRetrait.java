package com.eni.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.eni.vault.bll.BLLException;
import com.eni.vault.bll.Vault;
import com.eni.vault.bo.Gold;

public class CoffreFortTestRetrait {
	Vault vault = new Vault();
	Gold gold;
	
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
		Assert.assertEquals(excpected, this.vault.removeObject(gold));
	}

}
