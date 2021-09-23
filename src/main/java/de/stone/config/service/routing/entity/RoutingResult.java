package de.stone.config.service.routing.entity;

public class RoutingResult {

	private String destination;
	
	public RoutingResult() {
	}
	
	public RoutingResult(String destination) {
		super();
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
