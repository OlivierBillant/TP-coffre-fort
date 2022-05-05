package com.eni.vault.bll;

import java.util.ArrayList;


public class Vault {
	

		private ArrayList<Storable> objectsInside;
		private String password;
		
		private boolean locked ;
		
		public Vault() {
			this.locked = false;			
			objectsInside = new ArrayList<Storable>();
		}
		
		public boolean isLocked() {
			return locked;
		}
		
		
		/*
		 * Description : Verrouille le coffre-fort
		 */
		public boolean lock(String password) throws BLLException {
			if(locked) {
				throw new BLLException("Coffre déjà fermé.");
			}
			this.password = password;
			locked = true;
			return locked;
		}
		
		/*
		 * Description : D�verrouille le coffre-fort
		 */
		public void unlock(String password) throws BLLException {
			if(!locked) {
				throw new BLLException("Coffre déjà ouvert.");
			}
			locked =  !password.equals(this.password);
		}
		
		/*
		 * Description : Ajoute un objet dans le coffre fort
		 * Retourne : le nombre d'objets dans le coffre
		 */
		public int addObject(Storable object) throws BLLException {
			if(locked) {
				throw new BLLException("Coffre fermé");
			}
			objectsInside.add(object);
			return objectsInside.size() ;
			
		}
	
		/*
		 * Description : Enl�ve un objet du coffre fort
		 */
		public int removeObject(Storable object) {
			objectsInside.remove(object);
			return  objectsInside.size() ;
		}

		


}
