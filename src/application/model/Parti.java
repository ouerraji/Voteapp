package application.model;

public class Parti {
private int	id_parti;
private byte[] logo;

private String	nom,description,tel;
public Parti( String nom, byte[] logo, String description, String tel) {
    super();
    this.nom = nom;
    this.logo = logo;
    this.description = description;
    this.tel = tel;
}
public Parti(int id_parti, String nom, String description, String tel) {
	super();
	this.id_parti = id_parti;
	this.nom = nom;
	this.description = description;
	this.tel = tel;
}
public int getId_parti() {
	return id_parti;
}

public byte[] getLogo() {
	return logo;
}
public void setLogo(byte[] logo) {
	this.logo = logo;
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
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}


}
