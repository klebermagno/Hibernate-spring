package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;

import java.util.List;

public interface CompanyDao {
	
	    Company getForName(String name);
	    
	    List<Company> findAll();

	    void createCompany(Company company);

}
