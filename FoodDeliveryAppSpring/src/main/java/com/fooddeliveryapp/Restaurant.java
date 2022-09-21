package com.fooddeliveryapp;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;



@Entity
public class Restaurant {


		    @GeneratedValue
		    @Id
		    private Long id;

		    private String name;

		    private String location;


		    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
		    private List<Menu> menus;

		    
		    public Restaurant(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("location") String location, @JsonProperty("menus") List<Menu> menus) {
		        this.name = name;
		        this.location = location;
		        if (menus != null ) {
		            this.menus = menus;
		            for (Menu menu : menus)
		                menu.setRestaurant(this);
		        }
		    }

		    @Override
		    public String toString() {
		        return "Restaurant{" +
		                "id=" + id +
		                ", name='" + name + '\'' +
		                ", location='" + location + '\'' +
		                ", menus=" + menus +
		                '}';
		    }
		}
