package application.model;
/**
 *@author oussama erraji 
 */
public class Winner {
 private String fullname;
 private byte[] img;
 private byte[] logo;
 private int total;
 private String partiname;
 private int votes;
 
public int getVotes() {
	return votes;
}
public void setVotes(int votes) {
	this.votes = votes;
}
public String getPartiname() {
	return partiname;
}
public void setPartiname(String partiname) {
	this.partiname = partiname;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public byte[] getImg() {
	return img;
}
public void setImg(byte[] img) {
	this.img = img;
}
public byte[] getLogo() {
	return logo;
}
public void setLogo(byte[] logo) {
	this.logo = logo;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
 
}
