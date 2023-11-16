package com.lana.model;

import java.util.concurrent.atomic.AtomicLong;

public class Signature {
	
	private static final AtomicLong idGenerator = new AtomicLong();

	private Long id; // Unique ID for the signature
	private Long petitionId; // Unique ID of the associated petition
	private String petitionerName;
	private String petitionerEmail;

	// Constructors
	public Signature() {
		this.id = idGenerator.incrementAndGet();
	}

	public Signature(Long petitionId, String petitionerName, String petitionerEmail) {
		this.id = idGenerator.incrementAndGet();
		this.petitionId = petitionId;
		this.petitionerName = petitionerName;
		this.petitionerEmail = petitionerEmail;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPetitionId() {
		return petitionId;
	}

	public void setPetitionId(Long petitionId) {
		this.petitionId = petitionId;
	}

	public String getPetitionerName() {
		return petitionerName;
	}

	public void setPetitionerName(String petitionerName) {
		this.petitionerName = petitionerName;
	}

	public String getPetitionerEmail() {
		return petitionerEmail;
	}

	public void setPetitionerEmail(String petitionerEmail) {
		this.petitionerEmail = petitionerEmail;
	}
}