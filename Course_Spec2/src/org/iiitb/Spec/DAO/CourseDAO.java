package org.iiitb.Spec.DAO;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.Spec.Bean.Course;
import org.iiitb.Spec.Bean.Specilisation;
import org.iiitb.Spec.Util.SessionUtil;

public class CourseDAO {

	
	public ArrayList<Course> findbyId(int sid)
	{
		Session s=SessionUtil.getSession();
		Transaction trans=s.beginTransaction();
		String hql="FROM spec_course where Course_Spec_ID = :sid";
		Query qury=s.createQuery(hql);
		qury.setParameter("sid", sid);
		ArrayList<Integer> cid=(ArrayList<Integer>) qury.list();
		s.getTransaction().commit();
		
		Iterator it=cid.iterator();
		ArrayList<Course> cou=new ArrayList<Course>();
		while(it.hasNext())
		{
			int k=(int) it.next();
			Session s1=SessionUtil.getSession();
			Transaction trans1=s1.beginTransaction();
			String hql1="FROM Course where course_id = :k";
			Query qury1=s.createQuery(hql);
			qury1.setParameter("k", k);
			Course c= (Course) qury.getSingleResult();
			cou.add(c);
		}
		return cou;
		
	}
	
	public ArrayList<Course> findAll()
	{
		Session session=SessionUtil.getSession();
		Transaction transaction= session.getTransaction();
		String hql1="FROM Course ";
		Query query=session.createQuery(hql1);
		ArrayList<Course> cou= (ArrayList<Course>) query.list();
		return cou;
	}
}
