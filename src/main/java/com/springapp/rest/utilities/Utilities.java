package com.springapp.rest.utilities;

import com.springapp.rest.repository.StaticEmployeeDAO;

public class Utilities {

	public static void main(String[] args) {
		StaticEmployeeDAO sedao = new StaticEmployeeDAO();
		
		System.out.println(sedao.getEmployee(2));
		System.out.println(sedao.deleteEmployee(2));
		System.out.println(sedao.getEmployee(2));

	}

}
