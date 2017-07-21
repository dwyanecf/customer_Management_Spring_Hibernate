package com.dwyanecf.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dwyanecf.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query  ... sort by last name
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer order by firstName",
						Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer ... finally LOL
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer =currentSession.get(Customer.class,id);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
	Session currentSession = sessionFactory.getCurrentSession();
	Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
	theQuery.setParameter("customerId",id);
	 theQuery.executeUpdate();
	}


}






