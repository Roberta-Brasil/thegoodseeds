package com.thegoodseeds.seedsaversapp.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String username;
	private String password;
	private String usermail;
	private String oldPassword;
	private String fullName;
	private String userAddress;
	private String profileImg;
	private LocalDateTime creationDate;
	private LocalDateTime changeDate;
	private String phoneNumber;

	@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();

	@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<>();
	
	public User() {
	}

	public User(String username, String password, String usermail, String oldPassword, String fullName,
			String userAddress, String profileImg, String phoneNumber) {
		this.username = username;
		this.password = password;
		this.usermail = usermail;
		this.oldPassword = oldPassword;
		this.fullName = fullName;
		this.userAddress = userAddress;
		this.profileImg = profileImg;
		this.phoneNumber = phoneNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

//	@PrePersist
	public void setCreationDate() {
		this.creationDate = LocalDateTime.now();
		;
	}

	public LocalDateTime getChangeDate() {
		return changeDate;
	}

	// @PrePersist
	public void setChangeDate() {
		this.changeDate = LocalDateTime.now();
		;
	}

	public List<Post> getPost() {
		return posts;
	}

	public void setPost(List<Post> posts) {
		this.posts = posts;
	}
	
	public void addPost(Post post) {
		this.posts.add(post);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@PrePersist
	public void creationAt() {
		this.creationDate = LocalDateTime.now();
	}

	public void setChangeDate(LocalDateTime changeDate) {
		this.changeDate = changeDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", usermail=" + usermail
				+ ", oldPassword=" + oldPassword + ", fullName=" + fullName + ", userAddress=" + userAddress
				+ ", profileImg=" + profileImg + ", creationDate=" + creationDate + ", changeDate=" + changeDate
				+ ", phoneNumber=" + phoneNumber + ", posts=" + posts + ", comments=" + comments + "]";
	}

	
}
