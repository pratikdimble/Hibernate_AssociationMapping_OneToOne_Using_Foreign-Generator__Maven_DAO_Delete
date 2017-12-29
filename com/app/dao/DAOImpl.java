package com.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.HallTicket;
import com.app.model.Student;
import com.app.utility.HibernateUtil;

public class DAOImpl implements DAO {

	
	@Override
	public void deleteDataUsingStudent() {
		
		Session ses=null;
		//get the session
		ses=HibernateUtil.getSession();
			Transaction tx=null;
		//get the Object
			Student st=ses.get(Student.class, 333);
				
					try {
						tx=ses.beginTransaction();
							//delete the object
						ses.delete(st);

						tx.commit();
						System.out.println("\n\n\t\tObject and its asoociated child  Deleted  Successfully");
						
					} catch (Exception e2) {
						tx.rollback();
						e2.printStackTrace();
						System.out.println("\n\n\t\tObject and its asoociated child not  Deleted Successfully");
					}
						//close the session
					HibernateUtil.closeSession(ses);
	
	}//deleteDataUsingStudent()

	@Override
	public void deleteDataUsingHallTicket() {
		Session ses=null;
		//get the session
		ses=HibernateUtil.getSession();
			Transaction tx=null;
		//get the Object
			HallTicket hall=ses.get(HallTicket.class,777);
				
					try {
						tx=ses.beginTransaction();
							//delete the object
						ses.delete(hall);

						tx.commit();
						System.out.println("\n\n\t\tObject and its asoociated parent  Deleted  Successfully");
						
					} catch (Exception e2) {
						tx.rollback();
						e2.printStackTrace();
						System.out.println("\n\n\t\tObject and its asoociated parent not  Deleted Successfully");
					}
						//close the session
					HibernateUtil.closeSession(ses);
	
	}//deleteDataUsingHallTicket
	
	@Override
	public void deleteOnlyHallTicketData() {
		
		Transaction tx=null;
		Session ses=null;
		//get the session
		ses=HibernateUtil.getSession();
		//prepare the query
			Query q=ses.createQuery("delete from HallTicket WHERE ticketId=:id");
			q.setParameter("id", 999);
			try {
				tx=ses.beginTransaction();
			//execute the query
			int id=(Integer)q.executeUpdate();
			tx.commit();
			System.out.println("\n\t\tDeleted Record:: "+id);
			}
			catch (Exception e2) {
				tx.rollback();
				e2.printStackTrace();
				System.out.println("\n\n\t\tObject  not  Deleted Successfully");
			}
			//close the session
			HibernateUtil.closeSession(ses);
	}//deleteOnlyHallTicketData()
}//class
