/*************************************************************************
 *
 * DELOITTE CONSULTING
 * ___________________
 *
 *  [2013] - [2014] Deloitte Consulting, LLP
 *  All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Deloitte Consulting, LLP and its suppliers,
 * if any. The intellectual and technical concepts contained
 * herein are proprietary to Deloitte Consulting, LLP
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Deloitte Consulting, LLP.
 *
 *************************************************************************/
package com.northwindx.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import com.northwindx.model.jpa.Product;
import com.northwindx.util.PersistenceUtil;

@ManagedBean
@RequestScoped
public class SpecialDealsBean {

	private List <Product> productsList = new ArrayList<Product>();

	public SpecialDealsBean() {

		try {
			EntityManager em = PersistenceUtil.getEntityManager();
			productsList = new ArrayList<Product>(em.createQuery("Select p From Product p ORDER BY p.unitsInStock DESC", Product.class).setMaxResults(6).getResultList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Product> getProductsList() {
		return this.productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}
}