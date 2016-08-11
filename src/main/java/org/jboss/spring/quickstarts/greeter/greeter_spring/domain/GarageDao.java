package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;

import java.util.List;

public interface GarageDao {

	
    public Garage getForName(String name);
    
    public List<Garage> getForCompanyId(String company);
    
    void createGarage(Garage garage);
    
}
