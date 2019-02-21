package com.demospringmvc.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demospringmvc.ssm.mapper.ItemsMapperCustom;
import com.demospringmvc.ssm.po.ItemsCustom;
import com.demospringmvc.ssm.po.ItemsQueryVo;
import com.demospringmvc.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws RuntimeException {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

}
