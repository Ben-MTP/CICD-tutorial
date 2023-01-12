package com.msoft.core.config;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

/**
 * @author ManhKM on 1/12/2023
 * @project cicd-tutorial
 */
@Configuration
public class ServletConfig {

  @Bean
  public DispatcherServlet dispatcherServlet() {
    DispatcherServlet dispatcherServlet = new DispatcherServlet();
    dispatcherServlet.setThreadContextInheritable(true);
    dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    return dispatcherServlet;
  }

  @Bean
  public ServletRegistrationBean dispatcherServletRegistration() {

    ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet());
    registration.setLoadOnStartup(0);
    registration.setName(
        DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);

    return registration;
  }

  @Bean
  public DispatcherServletRegistrationBean dispatcherServletRegistrationBean() {
    return new DispatcherServletRegistrationBean(dispatcherServlet(), "/");
  }

  @Bean
  public FileTemplateResolver templateResolver() {
    FileTemplateResolver templateResolver = new FileTemplateResolver();
    templateResolver.setPrefix("resources/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setCharacterEncoding("UTF-8");
    templateResolver.setOrder(0);
    templateResolver.setCacheable(false);
    //		templateResolver.setCheckExistence(true);

    return templateResolver;
  }

  @Bean
  public SpringTemplateEngine templateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver());
    return templateEngine;
  }

  @Bean
  public ThymeleafViewResolver viewResolver() {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(templateEngine());
    return viewResolver;
  }
}
