package application.model;
/**
 *@author oussama erraji 
 */
public class Swipeinfo {
private String fullName;
private byte[] candidatPicture;
private byte[] partiPicture;
private int id_candidat;

public Swipeinfo() {
	super();
}

public Swipeinfo(String fullName, byte[] candidatPicture, byte[] partiPicture) {
	super();
	this.fullName = fullName;
	this.candidatPicture = candidatPicture;
	this.partiPicture = partiPicture;
}

public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public byte[] getCandidatPicture() {
	return candidatPicture;
}
public void setCandidatPicture(byte[] candidatPicture) {
	this.candidatPicture = candidatPicture;
}
public byte[] getPartiPicture() {
	return partiPicture;
}
public void setPartiPicture(byte[] partiPicture) {
	this.partiPicture = partiPicture;
}

public int getId_candidat() {
	return id_candidat;
}

public void setId_candidat(int id_candidat) {
	this.id_candidat = id_candidat;
}





}
