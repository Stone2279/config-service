package de.stone.config.service.notifications.entity;

import java.util.Date;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoomiNotification other = (BoomiNotification) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoomiNotification [id=" + id + ", level=" + level + ", ts=" + ts + ", state=" + state + ", errorClass="
				+ errorClass + ", message=" + message + ", auditLogId=" + auditLogId + ", trackingId=" + trackingId
				+ ", policyOverride=" + policyOverride + "]";
	}
	
	
}
