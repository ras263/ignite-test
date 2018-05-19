package com.lakhno.entity;

/**
 * Abstract type with identification.
 *
 * Created by Lakhno Anton
 * at 0:00 18.05.2018.
 *
 * @author Lakhno Anton
 * @version 1.0.1
 * @since 1.0.1
 */
public abstract class GenericEntity {

	Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GenericEntity{" +
				"id='" + id + '\'' +
				'}';
	}

}
