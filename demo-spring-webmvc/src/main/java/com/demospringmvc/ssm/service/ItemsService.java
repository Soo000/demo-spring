package com.demospringmvc.ssm.service;

import java.util.List;

import com.demospringmvc.ssm.po.ItemsCustom;
import com.demospringmvc.ssm.po.ItemsQueryVo;

public interface ItemsService {

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws RuntimeException;
	
}
