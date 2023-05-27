package application.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import application.dao.readMoreDao;
import application.model.readMore;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 * @author oussama erraji
 */
public class readMoreController {
	private int idcand;

	public void initializeWithIdcand(int idcand) {
        this.idcand = idcand;
        loadData();
    }

	@FXML
	private ImageView partilogo;

	@FXML
	private TextArea promises;

	private void loadData() {
		promises.setEditable(false);
        readMoreDao dao = new readMoreDao();
        readMore rm = dao.getmore(idcand);
        promises.setText(rm.getPromise());
        byte[] photoCandidat=rm.getLogoparti();
		if (photoCandidat != null) {
	        try (ByteArrayInputStream input = new ByteArrayInputStream(photoCandidat)) {
	            Image image = new Image(input);
	            partilogo.setImage(image);
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	    	partilogo.setImage(null);
	    }

    }

}
