package com.mall.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.security.mbg.mapper.PmsBrandMapper;
import com.mall.security.mbg.model.PmsBrand;
import com.mall.security.mbg.model.PmsBrandExample;
import com.mall.security.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
  * @desc PmsBrandService实现类
  * @author created by Administrator on 2021-02-15
**/
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    private static final Logger logger = LoggerFactory.getLogger(PmsBrandServiceImpl.class);

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return pmsBrandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return pmsBrandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        try{
            PageHelper.startPage(pageNum, pageSize);
            return pmsBrandMapper.selectByExample(new PmsBrandExample());
        }catch (Exception e){
            logger.error("listBrand:"+e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public PageInfo<PmsBrand> listBrand2(int pageNum, int pageSize) {
        try{
            PageHelper.startPage(pageNum, pageSize);
            List<PmsBrand> pmsBrandList =  pmsBrandMapper.selectByExample(new PmsBrandExample());
            return  new PageInfo<PmsBrand>(pmsBrandList);
        }catch (Exception e){
            logger.error("listBrand:"+e.getMessage());
            return  new PageInfo<PmsBrand>();
        }
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
