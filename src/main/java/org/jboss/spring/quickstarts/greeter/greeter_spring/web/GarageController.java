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

@Controller
@RequestMapping("createGarage")
public class GarageController {

    @Autowired
    private GarageDao garageDao;
    
    @Autowired
    private CompanyDao companyDao;


	/**
	 * Ação invocada ao carregar a tela de cadatro de Garagem.
	 * @return retorna uma lista de Companies para adicionar ao formulário.
	 */
    @RequestMapping(method = RequestMethod.GET)
    @ModelAttribute("companies")
    List<Company> getCompanies() {
    	 List<Company> companies = companyDao.findAll();
        return companies;
    }

	/**
	 * Ação invocada pelo form create. Deve persistir uma Garage no banco.
	 * 
	 * @param garage
	 *            epreenchida pelo usuário.
	 * @return uma mensagem para o usuário informando se foi possível criar a
	 *         Company e seu ID. Caso tenha ocorrido um erro informa ao ususário
	 *         que não foi possível cadastrar a Company.
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ModelAttribute("message") String create(Garage garage) {
		try {
			garageDao.createGarage(garage);
			return "Uma nova garagem com o id " + garage.getId()
					+ " foi criada com sucesso.";
		} catch (Exception e) {
			return "Ocorreu um erro ao cadastrar a garagem.";
		}
	}
}
