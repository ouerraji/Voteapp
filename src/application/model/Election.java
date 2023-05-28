package application.model;

import java.sql.Date;

public class Election {
private int id_cand,id_elec,id_vote;
private Date date;
private static int nbrelecteur=0;
public Election(int id_cand, int id_elec, int id_vote, Date date) {
	super();
	this.id_cand = id_cand;
	this.id_elec = id_elec;
	this.id_vote = id_vote;
	this.date = date;
}
public int getId_cand() {
	return id_cand;
}
public void setId_cand(int id_cand) {
	this.id_cand = id_cand;
}
public int getId_elec() {
	return id_elec;
}
public void setId_elec(int id_elec) {
	this.id_elec = id_elec;
}
public int getId_vote() {
	return id_vote;
}
public void setId_vote(int id_vote) {
	this.id_vote = id_vote;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public static int getNbrelecteur() {
	return nbrelecteur;
}
public static void setNbrelecteur(int nbrelecteur) {
	Election.nbrelecteur = nbrelecteur;
}

}
	