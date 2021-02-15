package com.mall.mybatis.service;


import com.github.pagehelper.PageInfo;
import com.mall.mybatis.mbg.model.PmsBrand;

import java.util.List;

/**
  * @desc
  * @author created by Administrator on 2021-02-15
**/
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PageInfo<PmsBrand> listBrand2(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);

}
