package com.causecode.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.causecode.dao.StoreDao;
import com.causecode.model.Store;
import com.causecode.model.Zipcode;

/**
 * StoreResource is controller class responsible for store related services.
 * 
 * 
 * @author Ankur Pande
 *
 */
@Path("/store")
public class StoreResource {

		// Find list of store from given zipcode location 
	    @POST
	    @Path("/findStore/{zipcode}")
	    @Produces("application/json")
	    @Consumes("application/json")
	    public List<Store> getStore(@PathParam("zipcode") int zipcode) {
	        StoreDao dao = new StoreDao();
	        List<Store> stores = dao.getStores(zipcode);
	        return stores;
	    }
	    
	    // Create a new store 
	    @POST
	    @Path("/createStore")
	    @Consumes("application/json")
	    public Response addStore(Store bean){
	        
	    	bean.setStoreAddress(bean.getStoreAddress());
	    	bean.setStoreName(bean.getStoreName());
	    	bean.setStoreId(bean.getStoreId());
	    	bean.setLatitude(bean.getLatitude());
	    	bean.setLongitude(bean.getLongitude());
	    	Zipcode zip =  new Zipcode();
	    	zip.setZipcode_id(bean.getZipcode().getZipcode_id());
	    	bean.setZipcode(zip);
	    	
	    	StoreDao dao = new StoreDao();
	        dao.addstoreDetails(bean);
	   
	        
	        return Response.ok().build();
	    }
	    
	    // Delete an existing store 
	    @DELETE
	    @Path("/deleteStore/{storeId}")
	    @Consumes("application/json")
	    public Response deleteStore(@PathParam("storeId") int storeId){
	    	StoreDao dao = new StoreDao();
	        int count = dao.deleteStore(storeId);
	        if(count==0){
	            return Response.status(Response.Status.BAD_REQUEST).build();
	        }
	        return Response.ok(storeId + " ==> Deleted from DB table.").build();
	    }
	    
	    // Update an existing store
	    @PUT
	    @Path("/updateStore/{storeId}")
	    @Consumes("application/json")
	    public Response updateStore(@PathParam("storeId") int storeId, Store store){
	    	StoreDao dao = new StoreDao();
	        int count = dao.updateStore(storeId,store);
	        if(count==0){
	            return Response.status(Response.Status.BAD_REQUEST).build();
	        }
	        return Response.ok(storeId + " ==> Updated in DB.").build();
	    }
	 
}
