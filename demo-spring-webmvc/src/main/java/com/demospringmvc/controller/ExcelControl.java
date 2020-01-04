package com.demospringmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ExcelControl extends AbstractController {
	@Override  
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)  throws Exception {  
        Map map = new HashMap();  
        List wordList = new ArrayList();  
  
        wordList.add("first");  
        wordList.add("second");  
        wordList.add("third");  
  
        map.put("wordList", wordList);  
        return new ModelAndView("exl", map);  
    }  

}
