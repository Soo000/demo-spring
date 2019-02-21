package com.demospring.bean.jdbc;

public class OfUser {

	private String username;
	private String storedKey;
	private String serverKey;
	private String salt;
	private String iterations;
	private String plainPassword;
	private String encryptedPassword;
	private String name;
	private String email;
	private String creationDate;
	private String modificationDate;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStoredKey() {
		return storedKey;
	}
	public void setStoredKey(String storedKey) {
		this.storedKey = storedKey;
	}
	public String getServerKey() {
		return serverKey;
	}
	public void setServerKey(String serverKey) {
		this.serverKey = serverKey;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getIterations() {
		return iterations;
	}
	public void setIterations(String iterations) {
		this.iterations = iterations;
	}
	public String getPlainPassword() {
		return plainPassword;
	}
	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
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
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	@Override
	public String toString() {
		return "Ofuser [username=" + username + ", storedKey=" + storedKey
				+ ", serverKey=" + serverKey + ", salt=" + salt
				+ ", iterations=" + iterations + ", plainPassword="
				+ plainPassword + ", encryptedPassword=" + encryptedPassword
				+ ", name=" + name + ", email=" + email + ", creationDate="
				+ creationDate + ", modificationDate=" + modificationDate + "]";
	}
	
}
