package com.vha.middleware.matrix.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vha.middleware.matrix.bean.SearchResult;

@Controller
public class MatrixController {

   @RequestMapping(value = "/search", method = RequestMethod.GET)
   public ModelAndView grep() {
      return new ModelAndView("grep", "command", new SearchResult());
   }
   
   @RequestMapping(value = "/searchResult", method = RequestMethod.POST)
   public String addSearchResult(@ModelAttribute("SearchQuery")SearchResult grep, 
   ModelMap model) {
      model.addAttribute("name", grep.getServerName());
      model.addAttribute("command", grep.getCommandResults().get(0).getCommand());
      model.addAttribute("commandResult", grep.getCommandResults().get(0).getCommandResult());
      return "result";
   }
}