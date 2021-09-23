package de.stone.config.service.locations.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATION_MAPPING")
@IdClass(LocationMappingId.class)
public class LocationMapping {

	@Id
	@Column(length = 128)
	private String alias;
	
	@Id
	@Column(length = 128)
	private String stage;
	
	@Column(length = 512)
	private String destination;

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public void merge(LocationMapping mapping) {
		this.alias = mapping.alias;
		this.destination = mapping.destination;
		this.stage = mapping.stage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
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
		LocationMapping other = (LocationMapping) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocationMapping [alias=" + alias + ", destination=" + destination + ", stage=" + stage + "]";
	}
}
