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
 * 
 * @author j.a.vasconcelos
 *
 */
@Component
public class PosTimeTransactionFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PosTimeTransactionFilter.class);

	/**
	 * Flag to activate filter
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * This class responsible to get time for final request Implement logic filter
	 */
	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		log.info("execute post filter");

		Long initialTime = (Long) request.getAttribute("initialTime");
		Long finalTime = System.currentTimeMillis();
		Long diffTime = finalTime - initialTime;

		log.info(String.format("diff time in seconds %s", diffTime.doubleValue() / 1000.00));
		log.info(String.format("diff time in milesecons %s", diffTime));

		return null;
	}

	/**
	 * Define filter type
	 */
	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
