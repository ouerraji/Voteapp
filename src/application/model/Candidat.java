package application.model;
/**
 *@author oussama erraji 
 */

import java.util.Date;

public class Candidat {
private int id_cand;
private String nom;
private String prenom;
private char genre;
private Date Date_Naiss;
private String Adresse;
private String Email;
private String Password;
private String CIN;
private byte[] photo;
private int id_parti;
public int getId_cand() {
	return id_cand;
}
public void setId_cand(int id_cand) {
	this.id_cand = id_cand;
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
public Date getDate_Naiss() {
	return Date_Naiss;
}
public void setDate_Naiss(Date date_Naiss) {
	Date_Naiss = date_Naiss;
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
public String getCIN() {
	return CIN;
}
public void setCIN(String cIN) {
	CIN = cIN;
}
public byte[] getPhoto() {
	return photo;
}
public void setPhoto(byte[] photo) {
	this.photo = photo;
}
public int getId_parti() {
	return id_parti;
}
public void setId_parti(int id_parti) {
	this.id_parti = id_parti;
}
public Candidat(String nom, String prenom, char genre, Date date_Naiss, String adresse, String email, String password,
		String cIN, byte[] photo, int id_parti) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.genre = genre;
	Date_Naiss = date_Naiss;
	Adresse = adresse;
	Email = email;
	Password = password;
	CIN = cIN;
	this.photo = photo;
	this.id_parti = id_parti;
}
public Candidat() {
	super();
}
@Override
public String toString() {
	return "Candidat [id_cand=" + id_cand + ", nom=" + nom + ", prenom=" + prenom + ", genre=" + genre + ", Date_Naiss="
			+ Date_Naiss + ", Adresse=" + Adresse + ", Email=" + Email + ", Password=" + Password + ", CIN=" + CIN
			+ ", photo=" + photo + ", id_parti=" + id_parti + "]";
}



}
