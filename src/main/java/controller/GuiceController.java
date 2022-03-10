package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.google.inject.Inject;

@Path("/guice")
public class GuiceController {

		@Inject
		private GuiceService guiceService;
		
		@Inject
		private UserService userService;
		
		@GET
		@Path("/authbyquery")
		@Produces(MediaType.TEXT_PLAIN)
		public String authenticate(@QueryParam("userName")String userName,@QueryParam("password")String password) {
			return userService.authenticate(userName, password);
			}
			
		
		@GET
		@Path("/authbyuri")
		@Produces(MediaType.TEXT_PLAIN)
		public String authenticate(@Context UriInfo uriInfo) {
			return userService.authenticate(uriInfo.getQueryParameters().getFirst("userName"),
					uriInfo.getQueryParameters().getFirst("password"));
		}
		@GET
		@Path("/sayHello")
		@Produces(MediaType.TEXT_PLAIN)
		public String sayHello() {
			return guiceService.sayHello();
		}
		
}
