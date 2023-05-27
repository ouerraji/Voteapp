package application.model;
/**
 *@author oussama erraji 
 */
public class readMore {
	private String nom;
	private byte[] logoparti;
	private String promise;
	public readMore() {
		super();
	}
	public readMore(String nom, byte[] logoparti, String promise) {
		super();
		this.nom = nom;
		this.logoparti = logoparti;
		this.promise = promise;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public byte[] getLogoparti() {
		return logoparti;
	}
	public void setLogoparti(byte[] logoparti) {
		this.logoparti = logoparti;
	}
	public String getPromise() {
		return promise;
	}
	public void setPromise(String promise) {
		this.promise = promise;
	}

}
