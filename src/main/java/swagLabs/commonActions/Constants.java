package swagLabs.commonActions;

public class Constants {
	
	
	private String chromeDriverPath;
	private String geckoDriverPath;
	private String edgeDriverPath;
	private String hubUrl;
	private String browser;
	private String remote;
	
	
	
	public String getChromeDriverPath() {
		return chromeDriverPath;
	}
	public void setChromeDriverPath(String chromeDriverPath) {
		this.chromeDriverPath = chromeDriverPath;
	}
	public String getGeckoDriverPath() {
		return geckoDriverPath;
	}
	public void setGeckoDriverPath(String geckoDriverPath) {
		this.geckoDriverPath = geckoDriverPath;
	}
	public String getEdgeDriverPath() {
		return edgeDriverPath;
	}
	public void setEdgeDriverPath(String edgeDriverPath) {
		this.edgeDriverPath = edgeDriverPath;
	}
	public String getHubUrl() {
		return hubUrl;
	}
	public void setHubUrl(String hubUrl) {
		this.hubUrl = hubUrl;
	}
	
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getRemote() {
		return remote;
	}
	public void setRemote(String remote) {
		this.remote = remote;
	}
	
	public boolean isRemote() {
		
		if(remote.equalsIgnoreCase("true"))
			return true;
		
		return false;
		
		
	}

}
