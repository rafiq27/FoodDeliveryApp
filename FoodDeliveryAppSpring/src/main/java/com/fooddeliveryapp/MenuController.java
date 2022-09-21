package com.fooddeliveryapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1.0/ foodapp")
@CrossOrigin(origins = "http://localhost:8081")
public class MenuController {


	    @Autowired
	    private MenuRepository mr;

	    @Autowired
	    private MenuItemRepository mir;

	    @GetMapping("/")
	    public List<Menu> getMenus() {
	        return mr.findAll();
	    }

	    @GetMapping("/{id}")
	    public Menu findMenuById(@PathVariable("id") Long id) {
	        return mr.findOne(id);
	    }

	    @PostMapping("/")
	    @ResponseStatus(HttpStatus.CREATED)
	    public void upload(@RequestBody List<Menu> menuList) {
	        mr.save(menuList);
	    }

	    @DeleteMapping("/")
	    public void deleteAll() {
	        
	        mr.deleteAll();
	    }

	    @DeleteMapping("/{id}")
	    public void deleteById(@PathVariable("id") Long id) {
	        mr.delete(id);
	    }

	    @RequestMapping("/{id}/items/")
	    public List<MenuItem> getItems(@PathVariable("id") Long id) {
	        Menu menu = mr.findOne(id);
	        if (menu == null)
	            return null;
	        return mir.findByMenu_Id(id);
	    }

	    @PostMapping("/{id}/items/")
	    public void addItems(@PathVariable("id") Long id,@RequestBody List<MenuItem> items) {
	        Menu menu = mr.findOne(id);
	        if (menu == null)
	            return ;

	        for (MenuItem item : items)
	            item.setMenu(menu);

	        mir.save(items);
	    }
	}
	
	
	
}
