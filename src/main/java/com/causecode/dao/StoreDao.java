package com.causecode.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.causecode.model.Store;
import com.causecode.model.Zipcode;
import com.causecode.utility.SessionUtil;

/**
 * Store DAO layer for accessing store table from DB.
 * 
 * @author Ankur Pande
 *
 */
public class StoreDao {

	 public void addstoreDetails(Store bean){
	        Session session = SessionUtil.getSession();        
	        Transaction tx = session.beginTransaction();
	        addStore(session,bean);        
	        tx.commit();
	        session.close();
	        
	 }
	 
	 private void addStore(Session session, Store bean){
	    	Store store = new Store();
	        
	    	store.setStoreAddress(bean.getStoreAddress());
	    	store.setStoreName(bean.getStoreName());
	    	store.setStoreId(bean.getStoreId());
	    	store.setLatitude(bean.getLatitude());
	    	store.setLongitude(bean.getLongitude());
	    	Zipcode zip =  new Zipcode();
	    	zip.setZipcode_id(bean.getZipcode().getZipcode_id());
	    	store.setZipcode(zip);
	        
	        
	        session.save(store);
    }
	 
	 public List<Store> getStores(int zipcode){
	        Session session = SessionUtil.getSession();    
	        String hql = "SELECT S FROM Store S WHERE S.zipcode = :zipcode";
	        Query query = session.createQuery(hql);
	        query.setInteger("zipcode", zipcode);
			List<Store> store =  query.list();
	        
	        session.close();
	        return store;
	 }
	 
	 public int deleteStore(int storeId) {
	        Session session = SessionUtil.getSession();
	        Transaction tx = session.beginTransaction();
	        String hql = "delete from Store where storeId = :storeId";
	        Query query = session.createQuery(hql);
	        query.setInteger("storeId",storeId);
	        int rowCount = query.executeUpdate();
	        tx.commit();
	        session.close();
	        return rowCount;
	 }
	 
	 public int updateStore(int storeId, Store store){
	        if(storeId <=0)  
	              return 0;  
	           Session session = SessionUtil.getSession();
	           Transaction tx = session.beginTransaction();
	           String hql = "update Store set " + 
	      			 "storeName = :storeName, " +
	      		     "storeAddress = :storeAddress " +
	      			 "where storeId = :storeId";
			      Query query = session.createQuery(hql);
			      query.setInteger("storeId",storeId);
			      query.setString("storeName",store.getStoreName());
			      query.setString("storeAddress",store.getStoreAddress());
			        
	           int rowCount = query.executeUpdate();
	           tx.commit();
	           session.close();
	           return rowCount;
	   }
	    
}
