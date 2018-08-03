package com.causecode.dao;



import java.util.List;

import com.causecode.model.Zipcode;
import com.causecode.utility.SessionUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


 /**
 * Zipcode DAO layer for accessing zipcode table from DB.
 * 
 * @author Ankur Pande
 *
 */

public class ZipcodeDao {
    
	
    public void addZipcodeDetails(Zipcode bean){
        Session session = SessionUtil.getSession();        
        Transaction tx = session.beginTransaction();
        addZipcode(session,bean);        
        tx.commit();
        session.close();
        
    }
    
    private void addZipcode(Session session, Zipcode bean){
    	Zipcode zipcode = new Zipcode();
        
    	zipcode.setCountry(bean.getCountry());
    	zipcode.setState(bean.getState());
    	zipcode.setZipcode_id(bean.getZipcode_id());
    	zipcode.setLatitude(bean.getLatitude());
    	zipcode.setLongitude(bean.getLongitude());
             
        session.save(zipcode);
    }
    
    public List<Zipcode> getZipcodes(){
        Session session = SessionUtil.getSession();    
        Query query = session.createQuery("FROM Zipcode");
		List<Zipcode> zipcode =  query.list();
        return zipcode;
    }
    
    public int deleteZipcode(int zipcode_id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from Zipcode where zipcode_id = :zipcode_id";
        Query query = session.createQuery(hql);
        query.setInteger("zipcode_id",zipcode_id);
        int rowCount = query.executeUpdate();
       
        tx.commit();
        session.close();
        return rowCount;
    }
    
    public int updateZipcode(int zipcode_id, Zipcode zip){
    	if(zipcode_id <=0)  
            return 0;  
            Session session = SessionUtil.getSession();
            Transaction tx = session.beginTransaction();
            String hql = "update Zipcode set " + 
            			 "state = :state, " +
            		     "country = :country " +            		
            			 "where zipcode_id = :zipcode_id";
            Query query = session.createQuery(hql);
            query.setInteger("zipcode_id",zipcode_id);
            query.setString("state",zip.getState());
            query.setString("country",zip.getCountry());
         
            int rowCount = query.executeUpdate();           
            tx.commit();
            session.close();
            return rowCount;
    }
}