package com.blogapis.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer postId;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	
	
	
	@ManyToOne
	@JoinColumn(name="Category_id")
	private Category category;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private Set<Comment>comments = new HashSet<>();
}
