import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class TestDoctorCriteria {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(student.class);
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		// GetAll
		// select * from student -JDBC

		Criteria criteria = ss.createCriteria(student.class);
		//                           column, condition/criteria 
		// equal to method
		
		criteria.add(Restrictions.eq("name", "karan"));
		criteria.add(Restrictions.eq("city", "pune"));
		
		//%an = last latter
		//an% = first latter
		//%an% = Middel latter
		
		criteria.add(Restrictions.like("name", "%an"));
		criteria.add(Restrictions.like("city", "%e"));
		criteria.add(Restrictions.like("name", "k%"));
		criteria.add(Restrictions.like("name", "%a%"));
		criteria.add(Restrictions.ilike("name", "%ka%"));
		
		
	//	criteria.add(Restrictions.ilike("name", "%op%"));
	//	criteria.add(Restrictions.ilike("name", "%op%"));
		//criteria.add(Restrictions.ilike("name", "%op%"));
		//criteria.add(Restrictions.ilike("name", "%op%"));
		//criteria.add(Restrictions.ilike("name", "%op%"));
		//criteria.add(Restrictions.gt(null, criteria));
		//criteria.add(Restrictions.le(null, criteria));
		//criteria.add(Restrictions.eq(null, criteria));
		
		// eq() -> 
		// le() -> 
		// gt() - >
		
		// ilike
		// like
		// eq()
		
		List<student> list=criteria.list();

		for (student student : list) {
			System.out.println(student.getId() + " " + student.getName()+" "+ student.getCity());
		}

	}
}