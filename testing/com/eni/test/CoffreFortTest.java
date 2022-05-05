package com.eni.test;

import com.eni.vault.bll.Vault;
import com.eni.vault.bo.Gold;

public class CoffreFortTest {
	Vault vault = new Vault();
	Gold gold = new Gold(1000);
	String goodPassword = "password";
	String otherPassword = "123";
	String wrongPassword = "Password";
	
}
