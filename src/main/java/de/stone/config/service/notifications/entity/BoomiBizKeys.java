package de.stone.config.service.notifications.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "BOOMI_BIZ_KEYS")
public class BoomiBizKeys {

	@Id
	@Column(name = "PK_BIZ_KEY_ID")
	private Integer id;
	
	@Column(name = "KEY_NAME")
	private String key;
	
	@Column(name = "KEY_VAL")
	private String value;
	
	@Column(name = "FK_TRACKING_ID")
	private String trackingId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
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
		BoomiBizKeys other = (BoomiBizKeys) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoomiBizKeys [id=" + id + ", key=" + key + ", value=" + value + ", trackingId=" + trackingId + "]";
	}
}
