package com.food.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * This class responsible to process request filter
 * @author j.a.vasconcelos
 *
 */
@Component
public class PreTimeTransactionFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PreTimeTransactionFilter.class);
	
	/**
	 * Flag to activate filter
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * This class responsible to get time for initial request
	 * Implement logic filter
	 */
	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s execute request a %s", request.getMethod(),request.getRequestURI().toString()));
		
		Long initialTime = System.currentTimeMillis();
		request.setAttribute("initialTime",initialTime);
		
		return null;
	}

	/**
	 * Define filter type
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
