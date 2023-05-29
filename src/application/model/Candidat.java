package application.model;

import java.sql.Date;

public class Candidat {
	private int id_cand,id_parti;
		private String nom,prenom,adresse,email,password,cin;
		private String parti;
		private int nbrVotes;
		private char genre;
		private Date Date_naissance;
		private String fullname;
		private Parti party;
		
		public Parti getParty() {
			return party;
		}

		public void setParty(Parti party) {
			this.party = party;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		private byte[] photo;
		
		public byte[] getPhoto() {
			return photo;
		}

		public void setPhoto(byte[] photo) {
			this.photo = photo;
		}

		public String getParti() {
			return parti;
		}

		public void setParti(String parti) {
			this.parti = parti;
		}

		public int getNbrVotes() {
			return nbrVotes;
		}

		public void setNbrVotes(int nbrVotes) {
			this.nbrVotes = nbrVotes;
		}

		public void setCin(String cin) {
			this.cin = cin;
		}

		public Candidat(String fullname, String cin, String parti, int nbrVotes) {
			super();
			this.fullname=fullname;
			this.cin = cin;
			this.parti = parti;
			this.nbrVotes = nbrVotes;
		}

		public Candidat(int id_cand, int id_parti, String nom, String prenom, String adresse, String email,
				String password, String cin, char genre, Date date_naissance) {
			super();
			this.id_cand = id_cand;
			this.id_parti = id_parti;
			this.nom = nom;
			this.prenom = prenom;
			this.adresse = adresse;
			this.email = email;
			this.password = password;
			this.cin = cin;
			this.genre = genre;
			Date_naissance = date_naissance;
		}
		
		public Candidat() {
			super();
		}

		public int getId_cand() {
			return id_cand;
		}
		public void setId_cand(int id_cand) {
			this.id_cand = id_cand;
		}
		public int getId_parti() {
			return id_parti;
		}
		public void setId_parti(int id_parti) {
			this.id_parti = id_parti;
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
		public String getCin() {
			return cin;
		}
		public void setCIN(String cin) {
			this.cin = cin;
		}
		public char getGenre() {
			return genre;
		}
		public void setGenre(char c) {
			this.genre = c;
		}
		public Date getDate_naissance() {
			return Date_naissance;
		}
		public void setDate_Naiss(Date date_naissance) {
			Date_naissance = date_naissance;
		}
		

	



}
