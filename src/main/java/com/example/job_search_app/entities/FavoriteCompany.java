package com.example.job_search_app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteCompany {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String name;
	private String location;
	private String website;

	@ManyToOne
	private User user;


}
