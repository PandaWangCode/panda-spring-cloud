package com.nx.edu;


import com.nx.edu.annotation.Select;

import java.util.List;

public interface OrderMapper {
    // 作业： @Select("select  * from `order` where  id = '%s'")
    Order queryById( Long id);
}
