package orf.wifi;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.quarkus.logging.Log;

@Path("/")
public class DemoResource {

@Inject
DemoService demoService;
@Inject
DemoServiceDb demoServiceDb;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Gibt mir den REST";
    }

    @GET
    @Path(value = "persist/{input}")
    public String greeting(@PathParam String input){
        Log.info("persisting input");
        return demoServiceDb.persistMessage(input);
    }
    @GET
    @Path(value = "anacheck/{input}/{testinput}")
    public String anacheck(@PathParam String input,@PathParam String testinput){
        Log.info("reversing input");
        return demoService.isAnagram(input, testinput).toString();
    }
    @GET
    @Path(value = "palcheck/{input}")
    public String palCheck(@PathParam String input){
        Log.info("reversing input");
        return demoService.isPalindrom(input).toString();
    }
}