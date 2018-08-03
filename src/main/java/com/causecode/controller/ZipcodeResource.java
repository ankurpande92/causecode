package com.causecode.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.causecode.dao.ZipcodeDao;
import com.causecode.model.Zipcode;
 
/**
 * ZipcodeResource is controller class responsible for zipcode related services.
 * 
 * 
 * @author Ankur Pande
 *
 */
 
 
@Path("/zipcode")
public class ZipcodeResource {
 
	// Get zipcode data
    @GET
    @Path("/getZipcode")
    @Produces("application/json")
    public List<Zipcode> getZipcode() {
        ZipcodeDao dao = new ZipcodeDao();
        List<Zipcode> zipcodes = dao.getZipcodes();
        return zipcodes;
    }
    
    // Create new zipcode location
    @POST
    @Path("/createZipcode")
    @Consumes("application/json")
    public Response addZipcode(Zipcode bean){
        
    	bean.setCountry(bean.getCountry());
    	bean.setState(bean.getState());
    	bean.setZipcode_id(bean.getZipcode_id());
    	bean.setLatitude(bean.getLatitude());
    	bean.setLongitude(bean.getLongitude());
    	
        ZipcodeDao dao = new ZipcodeDao();
        dao.addZipcodeDetails(bean);
   
        return Response.ok("Zipcode added sucessfully .").build();
    }
    
    // Delete an existing zipcode which is not associated with any store 
    @DELETE
    @Path("/deleteZipcode/{id}")
    @Consumes("application/json")
    public Response deleteZipcode(@PathParam("id") int id){
    	ZipcodeDao dao = new ZipcodeDao();
        int count = dao.deleteZipcode(id);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(id + " ==> Deleted from DB table.").build();
    }
    
   
    // Update an existing zipcode
    @PUT
    @Path("/updateZipcode/{zipcode_id}")
    @Consumes("application/json")
    public Response updateZipcode(@PathParam("zipcode_id") int zipcode_id, Zipcode zip){
    	ZipcodeDao dao = new ZipcodeDao();
        int count = dao.updateZipcode(zipcode_id,zip);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(zipcode_id + " ==> Updated in DB.").build();
    }
    
    
}
