package com.thegoodseeds.seedsaversapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_likesPostUser")
public class LikesPostUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Boolean likes;

	@ManyToOne
	@JoinColumn(name = "postId")
	private Post post;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public LikesPostUser() {
		
		// TODO Auto-generated constructor stub
	}

	public LikesPostUser(Post post, User user) {
		this.post = post;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getLike() {
		return likes;
	}

	public void setLike(Boolean like) {
		this.likes = like;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
