package com.lana.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.lana.model.Petition;
import com.lana.model.Signature;

public class PetitionSignatureCache {

	// Variables
	// use MAP because its list stores attribute-value pairs.
	private HashMap<Long, Petition> petitions; // A map to store Petition objects with their unique IDs.
	private HashMap<Long, List<Signature>> signatures; // A map to store all Signatures for each petition IDs.

	public PetitionSignatureCache() {
		petitions = new HashMap<>(); // Initialize the petitions map to store Petition objects.
		signatures = new HashMap<>(); // Initialize the signatures map to store Signature lists.
		populateSampleData();
	}

	private void populateSampleData() {

		// Hardcode default petitions
		Petition petition1 = new Petition("Save The Whales", "Bryan Barrett", "bryanbarrett@gmail.com",
				"Please support our cause.");
		Petition petition2 = new Petition("Save Amazon", "Jane Smith", "jane.smith@hotmail.com",
				"We need your help for a better future.");
		Petition petition3 = new Petition("Protect the universe", "Peter Pan", "patrick.peterson@gmail.com",
				"Peter Pan is a fictional character created by Scottish novelist and playwright J. M. Barrie. "
				+ "A free-spirited and mischievous young boy who can fly and never grows up, Peter Pan spends his "
				+ "never-ending childhood having adventures on the mythical island of Neverland as the leader of "
				+ "the Lost Boys");

		// Add the petition1 object to the petitions map with its unique ID (retrieved
		// from petition1.getPetitionId()) as the key.
		petitions.put(petition1.getPetitionId(), petition1);
		petitions.put(petition2.getPetitionId(), petition2);
		petitions.put(petition3.getPetitionId(), petition3);

		// Hardcode default signatures for the petitions
		Signature signature1 = new Signature(petition1.getPetitionId(), "Jim Murphy", "signature1@gmail.com");
		Signature signature2 = new Signature(petition1.getPetitionId(), "John Smith", "signature2@gmail.com");
		Signature signature3 = new Signature(petition2.getPetitionId(), "Mary Jones", "signature3@gmail.com");
		Signature signature4 = new Signature(petition2.getPetitionId(), "Lucy King", "signature4@gmail.com");

		List<Signature> p1Signature = new ArrayList<>();
		List<Signature> p2Signature = new ArrayList<>();
		List<Signature> p3Signature = new ArrayList<>();

		// Add the default signatures to their respective petition's signature list.
		p1Signature.add(signature1);
		p1Signature.add(signature2);
		p2Signature.add(signature3);
		p3Signature.add(signature4);

		// Store the signature lists in the map with petition IDs as keys.
		signatures.put(petition1.getPetitionId(), p1Signature);
		signatures.put(petition2.getPetitionId(), p2Signature);
		signatures.put(petition3.getPetitionId(), p3Signature);
	}

	public List<Petition> getAllPetitions() {
		return new ArrayList<Petition>(petitions.values());
	}

	public Petition getPetition(long petitionId) {
		return petitions.get(petitionId);
	}

	public Petition getPetition(String petitionName) {
		for (Entry<Long, Petition> p : petitions.entrySet()) {
			if (p.getValue().getName().toLowerCase().trim().equals(petitionName.toLowerCase().trim())) {
				return p.getValue();
			}
		}
		return null;
	}

	public void addPetition(Petition p) {
		long newPetitionId = generateUniquePetitionId();
		p.setPetitionId(newPetitionId);
		petitions.put(newPetitionId, p); // this.petitions.put(p.getPetitionId(), p);
	}
	
	public void addSignature(Signature s) {
		List<Signature> petitionSignatures = signatures.get(s.getPetitionId());
		petitionSignatures.add(s);
		signatures.put(s.getPetitionId(), petitionSignatures);
	}

	private synchronized long generateUniquePetitionId() {
		long maxId = 0;
		for (Long id : petitions.keySet()) {
			if (id > maxId) {
				maxId = id;
			}
		}
		return maxId + 1;
	}

	public List<Signature> getSignatures(Long petitionId) {
		return signatures.get(petitionId);
	}

}