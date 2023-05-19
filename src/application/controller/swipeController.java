package application.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import application.dao.CandidatDAO;
import application.dao.swipeDao;
import application.model.Candidat;
import application.model.Swipeinfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class swipeController {

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

    }
	@FXML
    void lireolusClicked(ActionEvent event) {

    }
}