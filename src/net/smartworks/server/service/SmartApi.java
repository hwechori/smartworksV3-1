package net.smartworks.server.service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmartApi {
}

class PassAuthenticator extends Authenticator {
	private String id;
	private String pass;
	public PassAuthenticator(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(this.id, this.pass);
	}
}