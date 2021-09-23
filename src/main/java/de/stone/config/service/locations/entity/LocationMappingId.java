package de.stone.config.service.locations.entity;

import java.io.Serializable;
import java.util.Objects;

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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LocationMappingId that = (LocationMappingId) o;
		return Objects.equals(alias, that.alias) && Objects.equals(stage, that.stage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(alias, stage);
	}

	@Override
	public String toString() {
		return "LocationMappingId{" +
				"alias='" + alias + '\'' +
				", stage='" + stage + '\'' +
				'}';
	}
}
