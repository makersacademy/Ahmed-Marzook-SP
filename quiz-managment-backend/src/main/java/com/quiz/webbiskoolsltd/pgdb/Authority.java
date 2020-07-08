package com.quiz.webbiskoolsltd.pgdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Table(name = "authority", schema = "public")
@Entity()
public class Authority implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(
	        name = "sequence",
	        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	        parameters = {
	                @Parameter(name = "sequence_name", value = "authority_seq"),
	                @Parameter(name = "increment_size", value = "1")
	        }
	)
	@GeneratedValue(generator = "sequence")
	@Column(name = "authority_id", unique = true, nullable = false)
	private Integer authorityId;
	
	@Column(name = "role", nullable = false)
	private String role;	

	public Authority() {
		super();
	}

	public Authority(Integer roleId, String roles) {
		super();
		this.authorityId = roleId;
		this.role = roles;
	}

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
