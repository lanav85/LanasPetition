package com.lana.model;

import java.util.concurrent.atomic.AtomicLong;

public class Petition {

	private static final AtomicLong idGenerator = new AtomicLong();

	private Long petitionId; // Unique ID
	private String petitionName;
	private String name;
	private String text;
	private String email;

	// Constructors
	public Petition() {
	}

	public Petition(String petitionName, String name, String email, String text) {
		this.setPetitionId(idGenerator.incrementAndGet());
		this.setPetitionName(petitionName);
		this.name = name;
		this.email = email;
		this.text = text;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getPetitionId() {
		return petitionId;
	}

	public void setPetitionId(Long petitionId) {
		this.petitionId = petitionId;
	}

	public String getPetitionName() {
		return petitionName;
	}

	public void setPetitionName(String petitionName) {
		this.petitionName = petitionName;
	}
	
	public void generateRandomPetitionId() {
		this.setPetitionId(idGenerator.incrementAndGet());
	}

}
