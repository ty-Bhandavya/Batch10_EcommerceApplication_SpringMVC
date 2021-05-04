package com.te.ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.ecommerce.bean.AdminInfoBean;
import com.te.ecommerce.bean.ItemInfoBean;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	public AdminInfoBean authenticate(Integer id, String password) {
		AdminInfoBean admin = null;
		try {
			//EntityManagerFactory factory = Persistence.createEntityManagerFactory("cart");
			EntityManager manager = factory.createEntityManager();
			String ql = "from admin where id =:id and password =:password";
			Query query = manager.createQuery(ql);
			query.setParameter("id", id);
			query.setParameter("password", password);
			admin = (AdminInfoBean) query.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public boolean addItem(ItemInfoBean item) {
		
		try {
			//EntityManagerFactory factory = Persistence.createEntityManagerFactory("cart");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(item);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean removeItem(Integer id) {
		
		try {
			//EntityManagerFactory factory = Persistence.createEntityManagerFactory("cart");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			ItemInfoBean item = manager.find(ItemInfoBean.class, id);
			manager.remove(item);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ItemInfoBean searchItem(Integer id) {
		
		ItemInfoBean item = null;
		try {
			//EntityManagerFactory factory = Persistence.createEntityManagerFactory("cart");
			EntityManager manager = factory.createEntityManager();
			item = manager.find(ItemInfoBean.class, id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public List<ItemInfoBean> getAllItems() {
		
		List<ItemInfoBean> list = null;
		try {
			//EntityManagerFactory factory = Persistence.createEntityManagerFactory("cart");
			EntityManager manager = factory.createEntityManager();
			String sql = "from item";
			Query query = manager.createQuery(sql);
			list  = query.getResultList();
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean updateItem(ItemInfoBean item) {
		
		try {
		//	EntityManagerFactory factory = Persistence.createEntityManagerFactory("cart");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			System.out.println("id "+item.getId());
			ItemInfoBean originalItem = manager.find(ItemInfoBean.class, item.getId());
			
			if(item.getName() != null && item.getName() != "") {
				originalItem.setName(item.getName());
			}

			transaction.commit();
			return true;
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}