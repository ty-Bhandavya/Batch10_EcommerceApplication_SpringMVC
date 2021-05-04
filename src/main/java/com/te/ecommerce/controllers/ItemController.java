package com.te.ecommerce.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.ecommerce.bean.AdminInfoBean;
import com.te.ecommerce.bean.ItemInfoBean;
import com.te.ecommerce.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService service;
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String getHomePage(Integer id, String password, HttpServletRequest request, ModelMap map) {
		
		AdminInfoBean admin = service.authenticate(id, password);
		if(admin != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("loginInfo", admin);
			return "homePage";
		} else {
			map.addAttribute("message", "Not a valid id or password");
			return "login";
		}
	}
	
	@GetMapping("/add")
	public String getAddItem(@SessionAttribute(name = "loginInfo", required = false) AdminInfoBean admin,
			ModelMap map) {
		
		if(admin != null) {
			return "addItem";
		} else {
			map.addAttribute("message","Please login before adding Item");
			return "login";
		}
	}

	
	@PostMapping("/add")
	public String addItem(ModelMap map, ItemInfoBean item) {
		
		if(service.addItem(item)) {
			map.addAttribute("message", "Item added successfully");
		} else {
			map.addAttribute("message", "Item already exists");
		}
		return "addItem";
		
	}
	
	@GetMapping("/remove")
	public String getRemoveItem(@SessionAttribute(name = "loginInfo", required = false) AdminInfoBean admin,
			ModelMap map) {
		if(admin != null) {
			return "removeItem";
		} else {
			map.addAttribute("message", "Please login before removing Item");
			return "login";
		}
	}
	
	@PostMapping("/remove")
	public String removeItem(ModelMap map , Integer id) {
		
		if(service.removeItem(id)) {
			map.addAttribute("message", "Item removed successfully");
			return "removeItem";
		} else {
			map.addAttribute("message", "Item is not present");
			return "removeItem";
		}

	}
	
	@GetMapping("searchAll")
	public String getAllItemsDetails(@SessionAttribute(name = "loginInfo", required = false) AdminInfoBean admin,
			ModelMap map) {
		
		if(admin != null) {
			return "searchAll";
		}else {
			map.addAttribute("message", "Please login first");
			return "login";
		}
	}
	
	@PostMapping("searchAll")
	public String getAllItems(ModelMap map) {
		List<ItemInfoBean> list = service.getAllItems();
		if(list != null) {
			map.addAttribute("list",list);
			return "searchAll";
		} else {
			map.addAttribute("message", "there is not items...");
			return "searchAll";
		}
	}

	
	@GetMapping("/search") 
	public String getSearchItem(@SessionAttribute(name = "loginInfo", required = false) AdminInfoBean admin,
			ModelMap map) {
		if(admin != null) {
			return "searchItem";
		} else {
			map.addAttribute("message", "Please login before searching items");
			return "login";
		}
	}
	
	@PostMapping("/search")
	public String searchItem(Integer id, ModelMap map) {
		ItemInfoBean item = service.searchItem(id);
		if(item != null) {
			map.addAttribute("item", item);
			return "searchItem";
		} else {
			map.addAttribute("message", "Item does not exist");
			return "searchItem";
		}
	}
	
	
	@GetMapping("/update")
	public String getItemUpdate(@SessionAttribute(name = "loginInfo", required = false) AdminInfoBean admin,
			ModelMap map) {
		if(admin != null) {
			return "update";
		} else {
			map.addAttribute("message", "Please login before updating items");
			return "login";
		}
	}
	
	@PostMapping("/update")
	public String updateItem(ItemInfoBean item, ModelMap map) {
		if(service.updateItem(item)) {
			map.addAttribute("message", "Item updated successfully");
			return "update";
		} else {
			map.addAttribute("message", "Item does not exist");
			return "update";
		}
	}
	
	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		session.invalidate();
		map.addAttribute("message", "logged out successfully");
		return "login";
	}


}
