package com.nx.mybatis.pattern.proxy;

/**
 * Author:   mkp
 * Date:     2020/11/16 11:45
 * Description:
 */
public class EnglishCourse implements Course {
    @Override
    public String getCourseInfo() {
        return "让每个人持续提升职业能力";
    }
}
