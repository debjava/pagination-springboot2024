package com.ddlab.rnd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "AppUser")
@Table(name = "app_user")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AppUser {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "city")
	private String city;

	public AppUser(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
}
