package fr.amnezic.qcwebcontrol.model.types;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Transient;
import javax.persistence.PostLoad;


/**
 *
 */

public  class Moderation   implements Serializable {

		
	
		
		protected Moderation(){
		}
	
		
	
	

	
		

	
	//a un pere ? 
	//contient directement des constantes ? true
	//contient des constantes ? true
	//a un pere qui contient des constantes ? false(pas de parent)
	//a un pere qui contient directement des constantes ? false(pas de parent)
	
			@Basic
			protected int id;
			
			@Basic
			protected String shortName;
		
		
			protected Moderation(int id, String shortName){
				this.id=id;
				this.shortName = shortName;
			}
		
		
			public int getId(){return id;}
			public String getShortName(){return shortName;}
		
	
	
		protected static Moderation getById(int id) {
		Moderation type=null;
		if(type==null){
			if(id == ALLOWED.id){
			return ALLOWED;
			}
			if(id == REJECTED.id){
			return REJECTED;
			}
		}
		return type;
	}
	
	@PostLoad
			protected Moderation loadById(){
				Moderation instance = getById(getId());
				this.shortName = instance.shortName;
				return this;
			}
	
	
		
		public static final Moderation ALLOWED = new Moderation(1,"allowed") ; 	
		
		public static final Moderation REJECTED = new Moderation(2,"rejected") ; 	
	
	

}
