package com.qintess.webapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Essa classe sera inicializada automaticamente pelo spring e efeturará todas as configurações necessárias
//Nos temos que escrever as configurações manualmente
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {  //esse metodo configura componentes externos (ex. hibernate)
		return new Class[] {
				HibernateConfig.class
		};
	} 

	@Override
	protected Class<?>[] getServletConfigClasses() {  //esse metodo configura o mvc do spring
		return new Class[] {
				WebMvcConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {    //esse metodo configura o mapeamento do servlet do spring
		return new String[] {
				"/"  //mapeamento global
		};
	}

}
