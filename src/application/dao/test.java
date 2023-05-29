package application.dao;

import application.model.Candidat;

/**
 *@author oussama erraji 
 */
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CandidatHomeDao candidatHomeDao=new CandidatHomeDao();
		Candidat candidat=candidatHomeDao.LoadCandidat(5);
		System.out.println(candidat.getFullname());
		System.out.println(candidat.getCin());
		System.out.println(candidat.getPhoto());
		System.out.println(candidat.getParti());
	}

}
