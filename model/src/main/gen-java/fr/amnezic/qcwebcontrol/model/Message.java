package fr.amnezic.qcwebcontrol.model;

import java.io.Serializable;
import  java.util.Date;
import  fr.amnezic.qcwebcontrol.model.Aggregat;
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
		
		@Temporal(TemporalType.TIMESTAMP)
			private Date datePost;
		
		@OneToOne
		
		
			private Aggregat aggregat;
		
		
			private String contenu;
		
		
			private String ip;
		
	
		
		public Message(){
		}
	
			public long getId(){return this.id;}
			public void setId(long id){this.id=id;}
		
		
			public Date getDatePost(){
				return this.datePost ;
			}
			public void setDatePost( Date datePost){
				this.datePost = datePost ;
			}
		
			public Aggregat getAggregat(){
				return this.aggregat ;
			}
			public void setAggregat( Aggregat aggregat){
				this.aggregat = aggregat ;
			}
		
			public String getContenu(){
				return this.contenu ;
			}
			public void setContenu( String contenu){
				this.contenu = contenu ;
			}
		
			public String getIp(){
				return this.ip ;
			}
			public void setIp( String ip){
				this.ip = ip ;
			}
		
	
	

	
		

	

}
