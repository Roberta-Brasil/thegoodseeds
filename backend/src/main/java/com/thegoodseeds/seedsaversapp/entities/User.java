package com.thegoodseeds.seedsaversapp.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String name;
	private String password;
	private String email;
	private String oldPassword;
	private String fullName;
	private String userAddress;
	private String profileImg;
	private LocalDateTime creationDate;
	private LocalDateTime changeDate;
	private String phoneNumber;
	
//	@Column(name = "reset_password_token")
//    private String resetPasswordToken;

	@OneToMany(mappedBy = "user")
	private List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Seed> seeds = new ArrayList<>();

	public User() {
		setCreationDate();
	}

	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
		setCreationDate();
	}

	public User(String name, String password, String email, String oldPassword, String fullName, String userAddress,
			String profileImg, String phoneNumber) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.oldPassword = oldPassword;
		this.fullName = fullName;
		this.userAddress = userAddress;
		this.profileImg = profileImg;
		this.phoneNumber = phoneNumber;
	}

	public void addSeed(Seed seed) {
		this.seeds.add(seed);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getName() {
		return name;
	}

	public List<Seed> getSeeds() {
		return seeds;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(changeDate, comments, creationDate, fullName, oldPassword, password, phoneNumber, posts,
//				profileImg, roles, userAddress, userId, email, name);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		return Objects.equals(changeDate, other.changeDate) && Objects.equals(comments, other.comments)
//				&& Objects.equals(creationDate, other.creationDate) && Objects.equals(fullName, other.fullName)
//				&& Objects.equals(oldPassword, other.oldPassword) && Objects.equals(password, other.password)
//				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(posts, other.posts)
//				&& Objects.equals(profileImg, other.profileImg) && Objects.equals(roles, other.roles)
//				&& Objects.equals(userAddress, other.userAddress) && Objects.equals(userId, other.userId)
//				&& Objects.equals(email, other.email) && Objects.equals(name, other.name);
//	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + name + ", password=" + password + ", usermail=" + email
				+ ", oldPassword=" + oldPassword + ", fullName=" + fullName + ", userAddress=" + userAddress
				+ ", profileImg=" + profileImg + ", creationDate=" + creationDate + ", changeDate=" + changeDate
				+ ", phoneNumber=" + phoneNumber + ", posts=" + posts + ", comments=" + comments + "]";
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public String getPassword() {
		return this.password;
	}
	
	
//	public String getResetPasswordToken() {
//		return resetPasswordToken;
//	}
//
//	public void setResetPasswordToken(String resetPasswordToken) {
//		this.resetPasswordToken = resetPasswordToken;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
