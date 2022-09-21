package com.fooddeliveryapp;

import javax.persistence.*;


@Entity
public class MenuItem {
    	@Id
	    @GeneratedValue
	    private Long id;

	    private String name;

	    private String info;

	    private String imageUrl;

	    private Double price;

	    @ManyToOne
	    @JoinColumn(name = "menu_id")
	    private Menu menu;

	    public MenuItem( Long id,  String name,  String info,
	                     String imageUrl, Double price) {
	        this.id = id;
	        this.name = name;
	        this.info = info;
	        this.imageUrl = imageUrl;
	        this.price = price;
	    }

	    @Override
	    public String toString() {
	        return "MenuItem{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", info='" + info + '\'' +
	                ", imageUrl='" + imageUrl + '\'' +
	                ", price=" + price +
	                '}';
	    }

		public void setMenu(Menu menu2) {
			menu2 = menu;
			
		}
	}
