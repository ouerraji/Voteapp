package application.model;
/**
 *@author oussama erraji 
 */

import java.util.Date;

public class Electeur {
private int id_elec;
private String nom;
private String prenom;
private char genre;
private Date Date_Naissance;
private String Adresse;
private String Email;
private String Password;
private String tel;
private String CIN;
private Candidat candidat;

public Electeur() {
	super();
}
public Electeur(String nom, String prenom, char genre, Date date_Naissance, String adresse, String email,
		String password, String tel, String cIN) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.genre = genre;
	Date_Naissance = date_Naissance;
	Adresse = adresse;
	Email = email;
	Password = password;
	this.tel = tel;
	CIN = cIN;
}
public int getId_elec() {
	return id_elec;
}
public void setId_elec(int id_elec) {
	this.id_elec = id_elec;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public char getGenre() {
	return genre;
}
public void setGenre(char genre) {
	this.genre = genre;
}
public Date getDate_Naissance() {
	return Date_Naissance;
}
public void setDate_Naissance(Date date_Naissance) {
	Date_Naissance = date_Naissance;
}
public String getAdresse() {
	return Adresse;
}
public void setAdresse(String adresse) {
	Adresse = adresse;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getCIN() {
	return CIN;
}
public void setCIN(String cIN) {
	CIN = cIN;
}
public Candidat getCandidat() {
	return candidat;
}
public void setCandidat(Candidat candidat) {
	this.candidat = candidat;
}


}
