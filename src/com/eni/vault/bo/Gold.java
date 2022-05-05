package com.eni.vault.bo;

import com.eni.vault.bll.Storable;

public class Gold implements Storable{
	
	//Poids en grammes
	private int weight;

	public Gold(int weight) {
		super();
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	
	

}
