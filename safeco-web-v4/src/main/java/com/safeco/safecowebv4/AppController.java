package com.safeco;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
//import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired 
	private CustomerService service;
	
	@RequestMapping("/admin")
	public String viewHomePage(Model model, String keyword) {
		 
//		session.insert(customer);
//		session.fireAllRules();
		return listByPage(model,1, "id", "asc", keyword);
		
	}
	@RequestMapping("/")
	public String Home() {
		return "home";	
		}
	
	@RequestMapping("/page/{pageNumber}") 
	  public String listByPage(Model model,
			  @PathVariable("pageNumber") int currentPage,
	   @Param("sortField") String sortField,
	   @Param("sortDir") String sortDir,
	   @Param("keyword") String keyword
	   ) {
		  Page<Customer> page = service.listAll(currentPage,sortField,sortDir, keyword);
		  
		  long totalItems = page.getTotalElements();
		  int totalPages =page.getTotalPages();
		  
		  List<Customer> listCustomers = page.getContent();
			
		  model.addAttribute("currentPage", currentPage);
		  model.addAttribute("totalItems", totalItems);
		  model.addAttribute("totalPages", totalPages);
		  model.addAttribute("listCustomers", listCustomers);
		  model.addAttribute("sortField", sortField);
		  model.addAttribute("sortDir", sortDir);
		  String reverseSortDir = sortDir.equals("asc") ? "desc" : "asc";
		  model.addAttribute("reverseSortDir", reverseSortDir);
		  model.addAttribute("keyword", keyword);

		  return "index";
		}
	@RequestMapping("/new")
	public String showNewCustomerPage(Model model) {
		Customer customer = new Customer();
//		session.insert(customer);
//		session.fireAllRules();
		model.addAttribute("customer", customer);
		
		return "new_customer";
	}

	
	@RequestMapping(value = "/getQuote", method = RequestMethod.GET, produces = "application/json")
	public Customer getQuestions(@RequestParam(required = true) String state) {

		Customer customer = new Customer();
		customer.setQuote(state);
		return customer;
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
		public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		
		
		service.save(customer);
	
				
//		session.insert(customer);
//		session.fireAllRules();
		
		return "redirect:/";
		}
	

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCustomerPage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_customer");
		Customer customer = service.get(id);
		mav.addObject("customer", customer);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable(name = "id") Long id) {
		service.delete(id);
		return "redirect:/";
	}
//	@GetMapping("/403")
//	public String error403() {
//		return "403";
//	}
}
