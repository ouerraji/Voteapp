package application.model;

import java.sql.Date;

public class Electeur {
	private int id_elec;
	private String nom,prenom,adresse,email,password,CIN,tel;
	char genre;
	private Date Date_naissance;
	
	public Electeur() {
		super();
	}
	public Electeur(int id_elec, String nom, String prenom, String adresse, String email, String password, String CIN,
			char genre, String tel, Date date_naissance) {
		super();
		this.id_elec = id_elec;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.password = password;
		this.CIN = CIN;
		this.genre = genre;
		this.tel = tel;
		Date_naissance = date_naissance;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String CIN) {
		this.CIN = CIN;
	}
	public char getGenre() {
		return genre;
	}
	public void setGenre(char c) {
		this.genre = c;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDate_Naissance() {
		return Date_naissance;
	}
	public void setDate_Naissance(Date date_naissance) {
		Date_naissance = date_naissance;
	}
	
}
	