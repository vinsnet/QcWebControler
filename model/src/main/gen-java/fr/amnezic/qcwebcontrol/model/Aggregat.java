package fr.amnezic.qcwebcontrol.model;

import java.io.Serializable;
import  fr.amnezic.qcwebcontrol.model.types.Moderation;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType ;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import javax.persistence.Embedded;
import javax.persistence.AttributeOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;


/**
 *
 */
@Entity 
public  class Aggregat   implements Serializable {

			@Id @GeneratedValue
			private long id;
		
		
			private String label;
		
		@Embedded
		    @AttributeOverrides( {
		    @AttributeOverride(name="id", column= @Column(name="etatModeration_id") ),
			@AttributeOverride(name="shortName", column= @Column(name="etatModeration_shortName") )})
			private Moderation etatModeration;
		
		
			private int count;
		
	
		
		public Aggregat(){
		}
	
			public long getId(){return this.id;}
			public void setId(long id){this.id=id;}
		
		
			public String getLabel(){
				return this.label ;
			}
			public void setLabel( String label){
				this.label = label ;
			}
		
			public Moderation getEtatModeration(){
				return this.etatModeration ;
			}
			public void setEtatModeration( Moderation etatModeration){
				this.etatModeration = etatModeration ;
			}
		
			public int getCount(){
				return this.count ;
			}
			public void setCount( int count){
				this.count = count ;
			}
		
	
	

	
		

	

}
