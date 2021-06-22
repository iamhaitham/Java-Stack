package com.codingdojo.OneToMany.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="dojos")
public class Dojo {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
	    private List<Ninja> ninjas;
	    
	    public Dojo() {
	        
	    }
	    
	    
	    
	    public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public List<Ninja> getNinjas() {
			return ninjas;
		}



		public void setNinjas(List<Ninja> ninjas) {
			this.ninjas = ninjas;
		}



		public Long getId() {
			return id;
		}



		public Date getCreatedAt() {
			return createdAt;
		}



		public Date getUpdatedAt() {
			return updatedAt;
		}



		@PrePersist
		public void setCreatedAt() {
			this.createdAt = new Date();
		}
	    
	    @PreUpdate
		public void setUpdatedAt() {
			this.updatedAt = new Date();
		}
}
