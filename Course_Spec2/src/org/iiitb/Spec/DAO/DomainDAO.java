package org.iiitb.Spec.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.iiitb.Spec.Bean.Course;
import org.iiitb.Spec.Bean.Specilisation;
import org.iiitb.Spec.Util.SessionUtil;

public class DomainDAO {

	public Course find(String code)
	{
		Session sess=SessionUtil.getSession();
		Transaction trans = sess.beginTransaction();
		String hql = "FROM Course WHERE course_code = :code";
        Query query = sess.createQuery(hql);
        query.setParameter("code", code);
        Course s=(Course) query.getSingleResult();
        sess.getTransaction().commit();
        return s;
	}
}
