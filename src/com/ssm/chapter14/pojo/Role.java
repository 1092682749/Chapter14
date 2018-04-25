package com.ssm.chapter14.pojo;

public class Role {
	private Long id;
	private String roleName;
	private String note;
	private Long uid;
	private PageParams pageParams = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public PageParams getPageParams() {
		return pageParams;
	}

	public void setPageParams(PageParams pageParams) {
		this.pageParams = pageParams;
	}
}
