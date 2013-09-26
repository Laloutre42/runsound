package org.zed.coding;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * This class replaces the "old" web.xml and is automatically scanned at the application startup
 */
public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.getEnvironment().setActiveProfiles("resthub-jpa", "resthub-web-server", "resthub-validation");
		String[] locations = {"classpath*:resthubContext.xml", "classpath*:applicationContext.xml"};
		appContext.setConfigLocations(locations);

		/* Add servlet */
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/*");		

		/* Add no cache filter */
		FilterRegistration.Dynamic noCache = servletContext.addFilter("no-cache", "com.samaxes.filter.NoCacheFilter");
		EnumSet<DispatcherType> disps = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
		noCache.addMappingForServletNames(disps, true, "dispatcher");		

		servletContext.addListener(new ContextLoaderListener(appContext));
	}
}
