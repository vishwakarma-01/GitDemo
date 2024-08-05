package POJOClass;

import java.util.List;

public class Courses {
	
	private List<WebAutomation> webAutomation; // WebAutomation (is array) is list of array
	private List<Api> api; // Api also expect array
	private List<Mobile> mobile; // Mobile also expect array
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(List<Api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
}
