package com.pb.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "todotable")
public class ToDo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Description is required")
	private String description;

	private boolean complete;

	private Instant createdDate;

	private Instant modifiedDate;

	@FutureOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;

	private String status;

	public ToDo() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public Instant getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Instant modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		if (dueDate.before(new Date()))
			return "expired";
		return "Not expired"; // or what ever are statuses
	}

	public ToDo(String description) {
		this.description = description;
		this.complete = true;
		this.createdDate = Instant.now();
		this.modifiedDate = Instant.now();
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", description=" + description + ", complete=" + complete + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + ", dueDate=" + dueDate + "]";
	}

}
