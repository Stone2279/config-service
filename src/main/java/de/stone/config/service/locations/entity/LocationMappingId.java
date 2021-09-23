package de.stone.config.service.locations.entity;

import java.io.Serializable;

public class LocationMappingId implements Serializable {

	private String alias;
	private String stage;
	
	public LocationMappingId() {}

	public LocationMappingId(String alias, String stage) {
		super();
		this.alias = alias;
		this.stage = stage;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + ((stage == null) ? 0 : stage.hashCode());
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
		LocationMappingId other = (LocationMappingId) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (stage == null) {
			if (other.stage != null)
				return false;
		} else if (!stage.equals(other.stage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocationMappingId [alias=" + alias + ", stage=" + stage + "]";
	}
}
