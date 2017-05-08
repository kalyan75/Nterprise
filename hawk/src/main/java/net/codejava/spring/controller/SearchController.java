package net.codejava.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.codejava.spring.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nterpise.hawk.bean.SearchQuery;

@Controller
@RequestMapping(value = "/search")
public class SearchController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		SearchQuery searchForm = new SearchQuery();		
		model.put("searchForm", searchForm);
		
		List<String> serverList = new ArrayList<String>();
		serverList.add("DEV");
		serverList.add("QA");
		serverList.add("UAT");
		model.put("serverList", serverList);
		
		return "Search";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("searchForm") SearchQuery query, 
			Map<String, Object> model) {
		
		// for testing purpose:
		System.out.println("Search String: " + query.getCommand());

		
		return "Search";
	}
}
