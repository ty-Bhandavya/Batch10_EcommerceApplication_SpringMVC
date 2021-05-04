package com.te.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecommerce.bean.AdminInfoBean;
import com.te.ecommerce.bean.ItemInfoBean;
import com.te.ecommerce.dao.ItemDAO;
import com.te.ecommerce.dao.ItemDAOImpl;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDAOImpl ItemDAO;
	
	@Override
	public AdminInfoBean authenticate(Integer id, String password) {
		
		AdminInfoBean admin = ItemDAO.authenticate(id, password);
		return admin;
	}

	@Override
	public boolean addItem(ItemInfoBean item) {
		boolean result = ItemDAO.addItem(item) ;
		return result;
	}

	@Override
	public boolean removeItem(Integer id) {
		boolean result = ItemDAO.removeItem(id);
		return result;
	}

	@Override
	public ItemInfoBean searchItem(Integer id) {
		ItemInfoBean item = ItemDAO.searchItem(id);
		return item;
	}

	@Override
	public List<ItemInfoBean> getAllItems() {
		List<ItemInfoBean> list = ItemDAO.getAllItems();
		return list;
	}

	@Override
	public boolean updateItem(ItemInfoBean item) {
		boolean result = ItemDAO.updateItem(item);
		return result;
	}

}
