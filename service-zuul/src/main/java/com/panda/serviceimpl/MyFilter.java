package com.panda.serviceimpl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * ������
 * @author Administrator
 *
 */
@Component
public class MyFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(MyFilter.class);
	
	/**
	 * shouldFilter���������д�߼��жϣ��Ƿ�Ҫ���ˣ�����true,��Զ���ˡ�
	 */
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * filterType������һ���ַ�����������������ͣ���zuul�ж��������ֲ�ͬ�������ڵĹ��������ͣ��������£�
	 * pre��·��֮ǰ
	 * routing��·��֮ʱ
	 * post�� ·��֮��
	 * error�����ʹ������
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * filterOrder�����˵�˳��
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * run���������ľ����߼������úܸ��ӣ�������sql��nosqlȥ�жϸ����󵽵���û��Ȩ�޷��ʡ�
	 */
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>>>>>>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
	}	
}
