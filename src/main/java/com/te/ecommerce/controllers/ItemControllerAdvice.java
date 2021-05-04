package com.te.ecommerce.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.ecommerce.customexp.ItemException;



@ControllerAdvice
public class ItemControllerAdvice {

	@ExceptionHandler(ItemException.class)
	public String handleExp(ItemException exception, HttpServletRequest request) {
		request.setAttribute("expMsg", exception.getMessage());
		return "header";
	}
}
