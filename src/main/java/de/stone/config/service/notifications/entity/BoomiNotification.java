package de.stone.config.service.notifications.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "BOOMI_NOTIFICATION")
public class BoomiNotification {

	@Id
	@Column(name = "PK_NOTIFICATION_ID")
	private Integer id;
	
	private String level;
	
	private Date ts;
	
	private String state;
	
	@Column(name = "CLASS")
	private String errorClass;
	
	private String message;
	
	@Column(name = "FK_PS_AUDITLOG_ID")
	private Integer auditLogId;
	
	@Column(name = "FK_TRACKING_ID")
	private String trackingId;
	
	@Column(name = "POLICY_OVERRIDE")
	private String policyOverride;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getErrorClass() {
		return errorClass;
	}

	public void setErrorClass(String errorClass) {
		this.errorClass = errorClass;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getAuditLogId() {
		return auditLogId;
	}

	public void setAuditLogId(Integer auditLogId) {
		this.auditLogId = auditLogId;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getPolicyOverride() {
		return policyOverride;
	}

	public void setPolicyOverride(String policyOverride) {
		this.policyOverride = policyOverride;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BoomiNotification that = (BoomiNotification) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "BoomiNotification{" +
				"id=" + id +
				", level='" + level + '\'' +
				", ts=" + ts +
				", state='" + state + '\'' +
				", errorClass='" + errorClass + '\'' +
				", message='" + message + '\'' +
				", auditLogId=" + auditLogId +
				", trackingId='" + trackingId + '\'' +
				", policyOverride='" + policyOverride + '\'' +
				'}';
	}
}
