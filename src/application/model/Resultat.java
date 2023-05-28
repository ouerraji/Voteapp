package application.model;

import java.sql.Date;

public class Resultat {
	private int clas=0;
	private int id_cand;
	private String genre;
	private String name;
	private Date date_nais;
	private int nbrvotes;
	private double votes;
	private double votesF;
	private double votesM;
	public Resultat(int clas, int id_cand, String genre, String name, Date date_nais, int nbrvotes, double votes,
			double votesF, double votesM) {
		super();
		this.clas = clas;
		this.id_cand = id_cand;
		this.genre = genre;
		this.name = name;
		this.date_nais = date_nais;
		this.nbrvotes = nbrvotes;
		this.votes = votes;
		this.votesF = votesF;
		this.votesM = votesM;
	}
	public int getClas() {
		return clas;
	}
	public void setClas(int clas) {
		this.clas = clas;
	}
	public int getId_cand() {
		return id_cand;
	}
	public void setId_cand(int id_cand) {
		this.id_cand = id_cand;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate_nais() {
		return date_nais;
	}
	public void setDate_nais(Date date_nais) {
		this.date_nais = date_nais;
	}
	public int getNbrvotes() {
		return nbrvotes;
	}
	public void setNbrvotes(int nbrvotes) {
		this.nbrvotes = nbrvotes;
	}
	public double getVotes() {
		return votes;
	}
	public void setVotes(double votes) {
		this.votes = votes;
	}
	public double getVotesF() {
		return votesF;
	}
	public void setVotesF(double votesF) {
		this.votesF = votesF;
	}
	public double getVotesM() {
		return votesM;
	}
	public void setVotesM(double votesM) {
		this.votesM = votesM;
	}
	
}

	