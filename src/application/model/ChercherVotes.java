package application.model;

public class ChercherVotes {
private int id ;
private String name ;
private int nombre_votes ;
public ChercherVotes(int id, String name, int nombre_votes) {
	super();
	this.id = id;
	this.name = name;
	this.nombre_votes = nombre_votes;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getNombre_votes() {
	return nombre_votes;
}
public void setNombre_votes(int nombre_votes) {
	this.nombre_votes = nombre_votes;
}

}