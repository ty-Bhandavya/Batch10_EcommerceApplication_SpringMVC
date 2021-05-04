package com.te.ecommerce.service;

import java.util.List;

import com.te.ecommerce.bean.AdminInfoBean;
import com.te.ecommerce.bean.ItemInfoBean;

public interface ItemService {

public AdminInfoBean authenticate(Integer id, String password);
	
	public boolean addItem(ItemInfoBean item);
	
	public boolean removeItem(Integer id);
	
	public ItemInfoBean searchItem(Integer id);
	
	public List<ItemInfoBean> getAllItems();
	
	public boolean updateItem(ItemInfoBean item);
}