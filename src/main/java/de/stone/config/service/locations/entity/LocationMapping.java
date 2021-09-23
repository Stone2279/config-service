package de.stone.config.service.locations.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Objects;

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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LocationMapping that = (LocationMapping) o;
		return Objects.equals(alias, that.alias) && Objects.equals(stage, that.stage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(alias, stage);
	}

	@Override
	public String toString() {
		return "LocationMapping{" +
				"alias='" + alias + '\'' +
				", stage='" + stage + '\'' +
				", destination='" + destination + '\'' +
				'}';
	}
}
