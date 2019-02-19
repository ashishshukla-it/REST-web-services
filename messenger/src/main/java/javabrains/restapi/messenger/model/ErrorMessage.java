package javabrains.restapi.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

// Beacause we want to return json response from it.
@XmlRootElement
public class ErrorMessage {
	private String errorMessage;
	private int errorCode;
	private String documentation;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(String errorMessage, int errorCode, String documentaion) {
		super();
		this.errorMessage=errorMessage;
		this.errorCode=errorCode;
		this.documentation=documentaion;
	} 
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
}
