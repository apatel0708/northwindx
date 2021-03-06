package com.northwindx;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.northwindx.model.jpa.Customer;
import com.northwindx.model.jpa.Product;
import com.northwindx.util.PersistenceUtil;

public class App {

	public static void main(String[] args) {
		
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		//em.getTransaction().begin();
		List<Product> productsList = new ArrayList<Product>(em.createQuery("Select p From Product p ORDER BY p.unitsInStock DESC", Product.class).setMaxResults(6).getResultList());
		//System.out.println(productsList.size());
		for(Product p : productsList) {
			System.out.println(p.getUnitsInStock());
		}
//		List<Customer> customerList = em.createQuery("from Customer", Customer.class).getResultList();
//		for (Customer customer : customerList) {
//			System.out.println(customer);
//		}
		
//		Customer johnny = new Customer();
//		johnny.setCustomerID("APPLE");
//		johnny.setContactName("Johnny Appleseed");
//		johnny.setCompanyName("Apples R Us");
//		em.persist(johnny);
		
//		Customer johnny = em.find(Customer.class, "APPLE");
//		System.out.println(johnny);
//		johnny.setCountry("United States");
//		johnny.setPassword("password");
		
//		em.find(Customer.class, "APPLE");
//		Customer johnnyClone = new Customer();
//		johnnyClone.setCustomerID("APPLE");
//		johnnyClone.setContactName("Johnny Orangeseed");
//		johnnyClone.setCompanyName("Orange You Glad We're Not Apples");
//		johnnyClone = em.merge(johnnyClone);
//		johnnyClone.setCompanyName("Glorious Oranges");
		
//		Customer johnny = em.find(Customer.class, "APPLE");
//		em.remove(johnny);
		
		
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Sample method to use for JUnit lab
	 * @param a
	 * @param b
	 * @return
	 */
	public double divide(Integer a, Integer b) {
        return a/b;
    }

	public Integer add(Integer a, Integer b) {
        return a + b;
    }
	
	public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

}




























