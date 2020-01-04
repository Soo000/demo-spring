package com.demospringmvc.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demospringmvc.ssm.po.ItemsCustom;
import com.demospringmvc.ssm.service.ItemsService;

@Controller
@RequestMapping("/ItemsController")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/findItemsList")
	public ModelAndView findItemsList() {
		List<ItemsCustom> itemsCustoms = itemsService.findItemsList(null);
		System.out.println(itemsCustoms);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		return mv;
	}
	
}