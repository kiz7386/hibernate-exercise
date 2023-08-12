package web.member.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import core.pojo.Core;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class Member extends Core {
	private static final long serialVersionUID = 1062017833925367218L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "NICKNAME")
	private String nickname;
	@Column(insertable = false)
	private Boolean pass;
	@Column(name = "ROLE_ID", insertable = true)
	private Integer roleId;
	@Column(insertable = false)
	private String creator;
	@Column(name = "CREATED_DATE", insertable = false)
	private Timestamp createdDate;
	@Column(insertable = false)
	private String updater;
	@Column(name = "LAST_UPDATED_DATE", insertable = false)
	private Timestamp lastUpdatedDate;
	public Member() {
		
	}
//	
//	public Member(String username, String nickname) {
//		this.username = username;
//		this.nickname = nickname;
//	}
//
//
//
//	public Member(Integer id, String username, String password, String nickname, Boolean pass, Integer roleId,
//			String creator, Timestamp createdDate, String updater, Timestamp lastUpdatedDate) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.nickname = nickname;
//		this.pass = pass;
//		this.roleId = roleId;
//		this.creator = creator;
//		this.createdDate = createdDate;
//		this.updater = updater;
//		this.lastUpdatedDate = lastUpdatedDate;
//	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Boolean getPass() {
		return pass;
	}
	public void setPass(Boolean pass) {
		this.pass = pass;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Timestamp getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
