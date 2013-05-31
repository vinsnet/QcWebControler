package fr.amnezic.qcwebcontrol.model;

import java.io.Serializable;
import  fr.amnezic.qcwebcontrol.model.Aggregat;
import  java.util.Date;
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
public  class Message   implements Serializable {

			@Id @GeneratedValue
			private long id;
		
		@OneToOne
		
		
			private Aggregat aggregat;
		
		
			private String ip;
		
		
			private String contenu;
		
		@Temporal(TemporalType.TIMESTAMP)
			private Date datePost;
		
	
		
		public Message(){
		}
	
			public long getId(){return this.id;}
			public void setId(long id){this.id=id;}
		
		
			public Aggregat getAggregat(){
				return this.aggregat ;
			}
			public void setAggregat( Aggregat aggregat){
				this.aggregat = aggregat ;
			}
		
			public String getIp(){
				return this.ip ;
			}
			public void setIp( String ip){
				this.ip = ip ;
			}
		
			public String getContenu(){
				return this.contenu ;
			}
			public void setContenu( String contenu){
				this.contenu = contenu ;
			}
		
			public Date getDatePost(){
				return this.datePost ;
			}
			public void setDatePost( Date datePost){
				this.datePost = datePost ;
			}
		
	
	

	
		

	

}
