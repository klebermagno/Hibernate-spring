/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.spring.quickstarts.greeter.greeter_spring.web;

import java.util.List;

import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Company;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.CompanyDao;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Garage;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.GarageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("searchGarage")
public class SearchGarageController {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private GarageDao garageDao;
    
    /**
     * Ação invocada ao entrar na tela SearchGarage.
     * @return retorna uma lista de Companies para adicionar ao formulário.
     */
    @RequestMapping(method = RequestMethod.GET)    
    public
    @ModelAttribute("companies")
    List<Company> getCompanies() {
    	 List<Company> companies = companyDao.findAll();
        return companies;
    }

    /**
     * Ação invocada pelo  submit da form searchGarage.
     * Recupera as Garages associadas a uma Company.
     * @param companyId identificador da company 
     * @return retorna uma lista  de garage
     */
    @RequestMapping(method = RequestMethod.POST)
    public
    @ModelAttribute("garages")
    List<Garage> getSearchGarage(@RequestParam("id") String companyId) {
        List<Garage> garares = garageDao.getForCompanyId(companyId);
        if (garares != null) {
            return garares;
        } else {
            return null;
        }
    }
}