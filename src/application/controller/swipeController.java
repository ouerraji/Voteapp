package application.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import application.dao.swipeDao;
import application.model.Swipeinfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class swipeController {
	private int id_elec;
	

	public void setId_elec(int id_elec) {
		this.id_elec = id_elec;
	}
	@FXML
	private ImageView candidatimg;

	@FXML
	private Button left;

	@FXML
	private Button right;
	@FXML
    private Hyperlink lireplus;

    @FXML
    private ImageView partilogo;
    @FXML
    private Button votebutton;


	@FXML
	private TextField txtfield;
	ArrayList<Swipeinfo> swipeinfos = new ArrayList<>();
	int index = 0;

	public void initialize() {
		swipeDao swipeDao = new swipeDao();
		swipeinfos = swipeDao.getSwipeinfos();
		if (swipeinfos.size() > 0) {
            showInfo(swipeinfos.get(index));
        }
    }

	private void showInfo(Swipeinfo swipeinfo) {
		// TODO Auto-generated method stub
		txtfield.setText(swipeinfo.getFullName());
		byte[] photoCandidat=swipeinfo.getCandidatPicture();
		if (photoCandidat != null) {
	        try (ByteArrayInputStream input = new ByteArrayInputStream(photoCandidat)) {
	            Image image = new Image(input);
	            candidatimg.setImage(image);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        candidatimg.setImage(null);
	    }
		byte[] logoparti=swipeinfo.getPartiPicture();
		if (logoparti != null) {
	        try (ByteArrayInputStream input = new ByteArrayInputStream(logoparti)) {
	            Image image = new Image(input);
	            partilogo.setImage(image);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        partilogo.setImage(null);
	    }
	}

	

	@FXML
	void leftClicked(ActionEvent event) {
		if (index > 0) {
            index--;
            showInfo(swipeinfos.get(index));
        }
	}

	@FXML
	void rightClicked(ActionEvent event) {
		if (index < swipeinfos.size() - 1) {
            index++;
            showInfo(swipeinfos.get(index));
        }
	}
	@FXML
    void voteClicked(ActionEvent event) {
		swipeDao dao1=new swipeDao();
		if(dao1.ALreadyVoted(id_elec))
		{
			Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Erreur de vote");
	        alert.setHeaderText(null);
	        alert.setContentText("Vous avez d�j� vot� !");
	        alert.showAndWait();
	        return;
    } 
    else {Alert confirmation = new Alert(AlertType.CONFIRMATION);
    confirmation.setTitle("Confirmation");
    confirmation.setHeaderText("Confirmer le vote");
    confirmation.setContentText("�tes-vous s�r de vouloir voter pour " + swipeinfos.get(index).getFullName() + " ?\nCette action est irr�versible.");
    confirmation.getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);
    ButtonType answer = confirmation.showAndWait().orElse(ButtonType.CANCEL);
    if (answer == ButtonType.OK) {
    	swipeDao dao=new swipeDao();
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		
		dao.inserVote(id_elec,timestamp, swipeinfos.get(index).getId_candidat());
        
        Alert success = new Alert(AlertType.INFORMATION);
        success.setTitle("Succ�s");
        success.setHeaderText(null);
        success.setContentText("Vote enregistr� avec succ�s !");
        success.showAndWait();
        votebutton.setDisable(true);
    }
}
		
		

    }
	@FXML
    void lireolusClicked(ActionEvent event) {

    }
}