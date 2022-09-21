package com.fooddeliveryapp;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu {
	    @Id
	    @GeneratedValue
	    private Long id;

	    private String type;

	    private String info;

	    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	    private List<MenuItem> items;

	    
	    @ManyToOne
	    @JoinColumn(name = "restaurant_id")
	    private Restaurant restaurant;

	   
	    public void setRestaurant(Restaurant restaurant) {
	        this.restaurant = restaurant;
	    }

	    
	    public Restaurant getRestaurant() {
	        return restaurant;
	    }

	    
	    public Menu( Long id,  String type,  String info, List<MenuItem> items) {
	        this.id = id;
	        this.type = type;
	        this.info = info;
	        if (items != null) {
	            this.items = items;
	            for (MenuItem item : items)
	                item.setMenu(this);
	        }
	    }

	    public Menu(Long id, String type, String info, Restaurant restaurant) {
	        this.id = id;
	        this.type = type;
	        this.info = info;
	        this.restaurant = restaurant;
	    }

	    @Override
	    public String toString() {
	        return "Menu{" +
	                "id=" + id +
	                ", type='" + type + '\'' +
	                ", info='" + info + '\'' +
	                ", items=" + items +
	                '}';
	    }
	}
	
