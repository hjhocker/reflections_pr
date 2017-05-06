package com.harrison.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.cb.CouchbaseClient;

@RestController
@RequestMapping(value = "/api/cb")
public class CouchbaseController {

	@Autowired
	private CouchbaseClient client;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<String> doStuff() {
		return client.doCbStuff();
	}
	
}
