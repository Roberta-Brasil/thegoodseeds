package com.thegoodseeds.seedsaversapp.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	private LocalDateTime createdAt;
	private int likesQuantity;
	private String title;
	private String postMessage;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Post() {
		instanceLocalDateTime();
	}

	public Post(int likesQuantity, String title, String postMessage) {
		this.likesQuantity = likesQuantity;
		this.title = title;
		this.postMessage = postMessage;
	    instanceLocalDateTime();
	}
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	private void instanceLocalDateTime() {
		this.createdAt = LocalDateTime.now();
	}

	
	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public int getLikesQuantity() {
		return likesQuantity;
	}

	public void setLikesQuantity(int likesQuantity) {
		this.likesQuantity = likesQuantity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public List<Comment> getComments() {
		return comments;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", createdAt=" + createdAt + ", likesQuantity=" + likesQuantity + ", title="
				+ title + ", postMessage=" + postMessage +", comments=" + comments + ", user="
				+ user + "]";
	}


}
