package com.eni.test;


import org.junit.Assert;
import org.junit.Test;

import com.eni.vault.bll.BLLException;

public class CoffreFortTestRetrait extends CoffreFortTest {
//	Vault vault = new Vault();
//	Gold gold;
	
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
