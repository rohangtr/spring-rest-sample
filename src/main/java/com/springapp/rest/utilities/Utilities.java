package com.springapp.rest.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springapp.rest.repository.EmployeeRepository;

public class Utilities {
	@Autowired
	EmployeeRepository employeeRepository;

	public static <E> List<E> makeList(Iterable<E> iter) {
		List<E> list = new ArrayList<E>();
		for (E item : iter) {
			list.add(item);
		}
		return list;
}
