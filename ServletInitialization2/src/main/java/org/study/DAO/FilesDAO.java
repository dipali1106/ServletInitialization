package org.study.DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.study.entity.Files;

public class FilesDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Files.class).buildSessionFactory();
	
	public void addFileDetails(Files file) {
		Session session =  factory.openSession();
		session.beginTransaction();
		session.persist(file);
		session.getTransaction().commit();
		System.out.println(file.getFileName()+"File saved successfully");
		
	}
	
	
	public List<Files> listFiles() {
		Session session =factory.getCurrentSession();
		session.beginTransaction();
		List<Files> fileslist = session.createQuery("from files", Files.class).getResultList();
		for(int i=0;i<fileslist.size();i++) {
			System.out.println(fileslist.get(i).toString());
		}		
		return fileslist;
		
	}

	
}
