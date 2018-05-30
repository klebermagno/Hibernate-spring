package org.jboss.spring.quickstarts.greeter.greeter_spring.web;

import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.Company;
import org.jboss.spring.quickstarts.greeter.greeter_spring.domain.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("createCompany")
public class CompanyController {

	@Autowired
	private CompanyDao companyDao;

	/**
	 * Ação invocada ao carregar a tela de cadatro de empresa.
	 */
	@RequestMapping(method = RequestMethod.GET)
	void getInitialMessage() {
		// do nothing
	}

	/**
	 * Ação invocada pelo form create. Deve persistir uma Company no banco.
	 * 
	 * @param company
	 *            epreenchida pelo usuário.
	 * @return uma mensagem para o usuário informando se foi possível criar a
	 *         Company e seu ID. Caso tenha ocorrido um erro informa ao ususário
	 *         que não foi possível cadastrar a Company.
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ModelAttribute("message") String create(Company company) {
		try {
			companyDao.createCompany(company);
			return "Uma nova empresa com o id " + company.getId()
					+ " foi criada com sucesso.";
		} catch (Exception e) {
			return "Ocorreu um erro ao cadastrar a Empresa.";
		}
	}

}
