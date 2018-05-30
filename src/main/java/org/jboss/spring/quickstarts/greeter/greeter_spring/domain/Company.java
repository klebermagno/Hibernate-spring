package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY_SPRING")
public class Company {
	
	
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;
    
    @Column
    private String initials;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="garage_id")
    public Garage garage;

    
	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}
    
    

}
