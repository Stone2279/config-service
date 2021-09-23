package de.stone.config.service.notifications.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "BOOMI_PS_AUDITLOG")
public class BoomiAuditLog {

	@Id
	@Column(name = "PK_PS_AUDITLOG_ID")
	private Integer id;
	
	@Column(name = "INTERNAL_ID")
	private String internalId;
	
	private Date ts;
	
	@Column(name = "ACCOUNT_ID")
	private String accountId;
	
	private String environment;
	
	private String classification;
	
	@Column(name = "ATOM_ID")
	private String atomId;
	
	@Column(name = "ATOM_NAME")
	private String atomName;
	
	@Column(name = "CONTAINER_ID")
	private String containerId;
	
	@Column(name = "PROCESS_NAME")
	private String processName;
	
	@Column(name = "PROCESS_COMPONENT_ID")
	private String processComponentId;
	
	@Column(name = "API_NAME")
	private String apiName;
	
	@Column(name = "EXECUTION_ID")
	private String executionId;
	
	@Column(name = "TRACKING_ID")
	private String trackingId;
	
	@Column(name = "PROC_CALL_STACK")
	private String processCallStack;
	
	private String step;
	
	@Column(name = "STEP_DETAILS")
	private String stepDetails;
	
	@Column(name = "ORIG_DOC_BASE64")
	private String documentBase64;
	
	@Column(name = "ERROR_FLAG")
	private String errorFlag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInternalId() {
		return internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getAtomId() {
		return atomId;
	}

	public void setAtomId(String atomId) {
		this.atomId = atomId;
	}

	public String getAtomName() {
		return atomName;
	}

	public void setAtomName(String atomName) {
		this.atomName = atomName;
	}

	public String getContainerId() {
		return containerId;
	}

	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessComponentId() {
		return processComponentId;
	}

	public void setProcessComponentId(String processComponentId) {
		this.processComponentId = processComponentId;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getProcessCallStack() {
		return processCallStack;
	}

	public void setProcessCallStack(String processCallStack) {
		this.processCallStack = processCallStack;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getStepDetails() {
		return stepDetails;
	}

	public void setStepDetails(String stepDetails) {
		this.stepDetails = stepDetails;
	}

	public String getDocumentBase64() {
		return documentBase64;
	}

	public void setDocumentBase64(String documentBase64) {
		this.documentBase64 = documentBase64;
	}

	public String getErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(String errorFlag) {
		this.errorFlag = errorFlag;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BoomiAuditLog that = (BoomiAuditLog) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "BoomiAuditLog{" +
				"id=" + id +
				", internalId='" + internalId + '\'' +
				", ts=" + ts +
				", accountId='" + accountId + '\'' +
				", environment='" + environment + '\'' +
				", classification='" + classification + '\'' +
				", atomId='" + atomId + '\'' +
				", atomName='" + atomName + '\'' +
				", containerId='" + containerId + '\'' +
				", processName='" + processName + '\'' +
				", processComponentId='" + processComponentId + '\'' +
				", apiName='" + apiName + '\'' +
				", executionId='" + executionId + '\'' +
				", trackingId='" + trackingId + '\'' +
				", processCallStack='" + processCallStack + '\'' +
				", step='" + step + '\'' +
				", stepDetails='" + stepDetails + '\'' +
				", documentBase64='" + documentBase64 + '\'' +
				", errorFlag='" + errorFlag + '\'' +
				'}';
	}
}
