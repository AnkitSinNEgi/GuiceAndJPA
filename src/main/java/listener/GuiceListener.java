package listener;

import javax.servlet.annotation.WebListener;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
//import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import controller.GuiceController;
@WebListener
public class GuiceListener extends GuiceServletContextListener{
		@Override
		protected Injector getInjector() {
			Injector injector = Guice.createInjector(new JerseyServletModule() {
				@Override
				protected void configureServlets() {
					bind(GuiceController.class);
					serve("/google/").with(GuiceContainer.class);
					serve("/login").with(GuiceContainer.class);
				//	serve("/rest/*").with(GuiceContainer.class);
				}
			},new JpaPersistModule("db_manager"));
			injector.getInstance(JpaInitializer.class);
				return injector;	
		}		
}
class JpaInitializer{
	
		@Inject
		public JpaInitializer(PersistService persistService) {
			persistService.start();
		}
}