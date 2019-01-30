package com.shop.domain;

import java.util.Calendar;
import com.shop.utilities.InvalidParamException;


import com.shop.domain.Picture;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "Picture")
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="idPicture")
	private Integer id;
	@Column(name="author")
	private String author;
	@Column(name="name")
	private String name;
	@Column(name="price")
	private double price;
	@Column(name="dateIn")
	private Calendar dateIn;
	/*Meto Shop como parametro para poder mostrar el join*/

	
	public Picture() {
		/* constructor vacio */

	}

	public Picture(String name, String author, double price) throws InvalidParamException {

		if (author == null || author.equals(""))
			author = "Anonymous";
		if (name == null || name.equals(""))
			throw new InvalidParamException();
		if (price < 0)
			throw new InvalidParamException();
		
		this.name = name;
		this.author = author;
		this.price = price;
		this.dateIn = Calendar.getInstance();

	}

	public Integer getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public Calendar getDateIn() {
		return dateIn;
	}

}
