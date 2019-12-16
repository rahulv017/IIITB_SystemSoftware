package org.iiitb.Spec.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.Spec.Bean.Course;
import org.iiitb.Spec.Bean.Specilisation;
import org.iiitb.Spec.Util.SessionUtil;

public class SpecialiseDAO {

	
	public void insertSpec(Specilisation special,List<String> courseid)
	{
		Session session=SessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		//session.save(special);
		//String hql = "FROM Specilisation WHERE spec_name = :spec_name";
       //Query query = session.createQuery(hql);
        //query.setParameter("spec_name", special.getSpec_name());
        //Specilisation s=(Specilisation) query.getSingleResult();
        
        DomainDAO d=new DomainDAO();
        ArrayList<Course> arr=new ArrayList<Course>();
        Iterator<String>it=courseid.iterator();
          for(String s: courseid)
          {
        	  arr.add(d.find(s));
          }
        	
        
       
       special.setSpec_course(arr);
       session.save(special);
       session.getTransaction().commit();
        
	}
	
	public Specilisation viewSpec(String spec)
	{
		
		Session session=SessionUtil.getSession();
		Transaction trans=session.beginTransaction();
		String hql = "FROM Specilisation WHERE spec_name = :spec_name";
		 Query query = session.createQuery(hql);
	     query.setParameter("spec_name",spec);
	     Specilisation k=(Specilisation)query.getSingleResult();
	     int sid=k.getSpec_id();
	     CourseDAO cd=new CourseDAO();
	 //    ArrayList<Course> res=cd.findbyId(sid);
	  //   k.setSpec_course(res);
	     
	    // Specilisation s=(Specilisation) query.getSingleResult();
	     return k;
		
	}
	
	public ArrayList<Specilisation> viewSpecAll()
	{
		
		Session session=SessionUtil.getSession();
		Transaction trans=session.beginTransaction();
		String hql = "FROM Specilisation ";
		 Query query = session.createQuery(hql);
	   //  query.setParameter("spec_name",spec);
	     ArrayList<Specilisation> k=(ArrayList<Specilisation>)query.list();
	  //   int sid=k.getSpec_id();
	     CourseDAO cd=new CourseDAO();
	 //    ArrayList<Course> res=cd.findbyId(sid);
	  //   k.setSpec_course(res);
	     
	    // Specilisation s=(Specilisation) query.getSingleResult();
	     return k;
		
	}
	
	public boolean updateSpec(Specilisation spec,List<String> courseid)
	{
		
		Session session=SessionUtil.getSession();
		Transaction trans=session.beginTransaction();
//		String hql = "UPDATE Specilisation set"+" spec_name = :sName,"+"spec_min_credit =: scredits ,"+" spec_target_dept = :sdept  where spec_id = :sid";
//		 Query query = session.createQuery(hql);
//	     query.setParameter("sName",spec.getSpec_name());
//	     query.setParameter("scredits",spec.getSpec_min_credit());
//	     query.setParameter("sdept",spec.getSpec_target_dept());
//	     query.setParameter("sid",spec.getSpec_id());
	     DomainDAO d=new DomainDAO();
	        ArrayList<Course> arr=new ArrayList<Course>();
	        Iterator<String>it=courseid.iterator();
	          for(String s: courseid)
	          {
	        	  arr.add(d.find(s));
	          }
	          spec.setSpec_course(arr);
	    // ArrayList<Specilisation> k=(ArrayList<Specilisation>)query.list();
	    // int res=query.executeUpdate();
	  //   int sid=k.getSpec_id();
	     CourseDAO cd=new CourseDAO();
	     session.update(spec);
	     session.getTransaction().commit();
	 //    ArrayList<Course> res=cd.findbyId(sid);
	  //   k.setSpec_course(res);
	     
	    // Specilisation s=(Specilisation) query.getSingleResult();
	    // return k;
	     int res=1;
	     if(res==0)
	    	 return false;
	     else
	    	 return true;
		
	}
	
	public boolean deleteSpec(String str)
	{
		
		Session session=SessionUtil.getSession();
		Transaction trans=session.beginTransaction();
		String hql = "FROM Specilisation WHERE spec_name = :spec_name";
		 Query query = session.createQuery(hql);
	     query.setParameter("spec_name",str);
	     Specilisation k=(Specilisation)query.getSingleResult();
		session.delete(k);
		session.getTransaction().commit();
		
		return true;
	}
}
