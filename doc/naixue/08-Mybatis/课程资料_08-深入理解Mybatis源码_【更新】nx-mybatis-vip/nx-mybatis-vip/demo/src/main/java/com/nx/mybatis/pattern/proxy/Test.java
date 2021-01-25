package com.nx.mybatis.pattern.proxy;

/**
 * Author:   mkp
 * Date:     2020/11/16 12:47
 * Description:
 */
public class Test {
    public static void main(String[] args) {
        EnglishCourse englishCourse = new EnglishCourse();
        CourseProxy courseProxy = new CourseProxy();
        courseProxy.setTarget(englishCourse);
        Course target = (Course)courseProxy.getTarget();
        target.getCourseInfo();

    }
}
