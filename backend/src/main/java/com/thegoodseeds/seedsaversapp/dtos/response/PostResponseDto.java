package com.thegoodseeds.seedsaversapp.dtos.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thegoodseeds.seedsaversapp.entities.Comment;
import com.thegoodseeds.seedsaversapp.entities.Post;

public class PostResponseDto {

	private Long postId;
	private int likesQuantity;
	private String title;
	private String postMessage;
	private LocalDateTime createdTime;

	@JsonIgnore
	private Long id;

	private UserResponseDto user;

	private SeedResponseDto seed;

	private List<CommentResponseDto> comments = new ArrayList<>();

	public PostResponseDto(Post post) {

		this.postId = post.getPostId();
		this.likesQuantity = post.getLikesQuantity();
		this.title = post.getTitle();
		this.postMessage = post.getPostMessage();
		this.createdTime = LocalDateTime.now();
		this.id = post.getPostId();
		this.user = new UserResponseDto(post.getUser());
		this.seed = new SeedResponseDto(post.getSeed());
		this.comments = convertList(post.getComments());
	}

	private List<CommentResponseDto> convertList(List<Comment> comments) {

		List<CommentResponseDto> commentsDto = comments.stream().map(CommentResponseDto::new)
				.collect(Collectors.toList());

		return commentsDto;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public List<CommentResponseDto> getComments() {
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

	public UserResponseDto getUser() {
		return user;
	}

	public void setUser(UserResponseDto user) {
		this.user = user;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public SeedResponseDto getSeed() {
		return seed;
	}

	public void setSeed(SeedResponseDto seed) {
		this.seed = seed;
	}

	@Override
	public String toString() {
		return "PostResponseDto [postId=" + postId + ", likesQuantity=" + likesQuantity + ", title=" + title
				+ ", postMessage=" + postMessage + ", createdTime=" + createdTime + ", id=" + id + ", user=" + user
				+ ", comments=" + comments + "]";
	}

}
