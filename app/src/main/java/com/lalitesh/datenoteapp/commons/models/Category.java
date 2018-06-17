/*
 * Copyright (C) 2018 Lalitesh Sahoo (lsdevloper@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.lalitesh.datenoteapp.commons.models;


import java.util.Calendar;


public class Category {

	private Long id;
	private String name;
	private String description;
	private String color;
	private int count;


	public Category() {
		this.id = Calendar.getInstance().getTimeInMillis();
	}


	public Category(Category category) {
		this(category.getId(), category.getName(), category.getDescription(), category.getColor());
	}


	public Category(Long id, String title, String description, String color) {
		super();
		this.id = id;
		this.name = title;
		this.description = description;
		this.color = color;
	}


	public Category(Long id, String title, String description, String color, int count) {
		super();
		this.id = id;
		this.name = title;
		this.description = description;
		this.color = color;
		this.count = count;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String title) {
		this.name = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		try {
			Category c = (Category) obj;
			return getColor().equals(c.getColor()) && getDescription().equals(c.getDescription()) && getName().equals
					(c.getName()) && getId().equals(c.getId());
		} catch (ClassCastException e) {
			return false;
		}
	}
}
