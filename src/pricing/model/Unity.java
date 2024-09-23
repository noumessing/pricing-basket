package pricing.model;

//This class describe a unity of a good (for example tin, bottle,loaf...°
public class Unity {
	
	private long idUnity;
	
	private String unityName;
	
	
	public Unity() {
		super();
	}
	

	public Unity(long idUnity, String unityName) {
	
		this.idUnity = idUnity;
		this.unityName = unityName;
	}

	

	public long getIdUnity() {
		return idUnity;
	}

	public void setIdUnity(long idUnity) {
		this.idUnity = idUnity;
	}

	public String getUnityName() {
		return unityName;
	}

	public void setUnityName(String unityName) {
		this.unityName = unityName;
	}
	
	
	

}
