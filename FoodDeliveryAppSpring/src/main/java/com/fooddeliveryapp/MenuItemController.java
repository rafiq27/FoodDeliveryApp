package com.fooddeliveryapp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/ foodapp")
@CrossOrigin(origins = "http://localhost:8081")
public class MenuItemController {

	    @Autowired
	    private MenuItemRepository mir;

	    @GetMapping("/food/all")
	    public List<MenuItem> getMenItems() {
	        return mir.findAll();
	    }

	}
	
