package com.demospringmvc.ssm.mapper;

import com.demospringmvc.ssm.po.Orderdetail;

public interface OrderdetailMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    Orderdetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}