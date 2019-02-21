package com.demospringmvc.ssm.mapper;

import java.util.List;

import com.demospringmvc.ssm.po.ItemsCustom;
import com.demospringmvc.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom {

	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws RuntimeException;

}