package com.thegoodseeds.seedsaversapp.dtos.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thegoodseeds.seedsaversapp.entities.Comment;
import com.thegoodseeds.seedsaversapp.entities.Post;

public class PostResponseDTO {

	private Long postId;
	private int likesQuantity;
	private String title;
	private String postMessage;
	private LocalDateTime createdTime;

	@JsonIgnore
	private Long id;

	private UserResponseDTO user;

	private SeedResponseDTO seed;

	private List<CommentResponseDTO> comments = new ArrayList<>();

	public PostResponseDTO(Post post) {

		this.postId = post.getPostId();
		this.likesQuantity = post.getLikesQuantity();
		this.title = post.getTitle();
		this.postMessage = post.getPostMessage();
		this.createdTime = LocalDateTime.now();
		this.id = post.getPostId();
		this.user = new UserResponseDTO(post.getUser());
		this.seed = new SeedResponseDTO(post.getSeed());
		this.comments = convertList(post.getComments());
	}

	private List<CommentResponseDTO> convertList(List<Comment> comments) {

		List<CommentResponseDTO> commentsDto = comments.stream().map(CommentResponseDTO::new)
				.collect(Collectors.toList());

		return commentsDto;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public List<CommentResponseDTO> getComments() {
		return comments;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserResponseDTO getUser() {
		return user;
	}

	public void setUser(UserResponseDTO user) {
		this.user = user;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public SeedResponseDTO getSeed() {
		return seed;
	}

	public void setSeed(SeedResponseDTO seed) {
		this.seed = seed;
	}

	@Override
	public String toString() {
		return "PostResponseDto [postId=" + postId + ", likesQuantity=" + likesQuantity + ", title=" + title
				+ ", postMessage=" + postMessage + ", createdTime=" + createdTime + ", id=" + id + ", user=" + user
				+ ", comments=" + comments + "]";
	}

}
