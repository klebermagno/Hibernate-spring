package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "GARAGE_SPRING")
public class Garage {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;
    
    @Column
    private String initials;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="id")
    public List<Company> company;



	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
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
