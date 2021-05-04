package com.te.ecommerce.dao;

import java.util.List;

import com.te.ecommerce.bean.AdminInfoBean;
import com.te.ecommerce.bean.ItemInfoBean;

public interface ItemDAO {

public AdminInfoBean authenticate(Integer id, String password);
	
	public boolean addItem(ItemInfoBean item);
	
	public boolean removeItem(Integer id);
	
	public ItemInfoBean searchItem(Integer id);
	
	public boolean updateItem(ItemInfoBean item);
	
	public List<ItemInfoBean> getAllItems();
	
	
}
