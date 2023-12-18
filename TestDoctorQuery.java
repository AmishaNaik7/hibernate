import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDoctorQuery {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.addAnnotatedClass(student.class);
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
	// GetAll
		// select * from student -JDBC
		Query query=ss.createQuery("from student"); // hibernate
		
		List<student> list=query.list();
		
		System.out.println("student table");
		System.out.println("ID      " +     "NAME   "     +    "CITY   ");
		
		for (student student : list) {
			
			System.out.println(student.getId()+" - - "+student.getName()+" - - "+ student.getCity());
		}
		
	}
}