package application.controller;

import application.dao.CandidatHomeDao;
import application.model.Candidat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class CandidatHomeController implements Initializable {


	@FXML
    private ImageView imgCandidat;
    @FXML
    private Label fullName;
    @FXML
    private Label partiName;
    @FXML
    private Label nbrVotes;
    @FXML
    private Label cand_CIN;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
       
       
       
    }
    
    
    


    public void displayCandidat(Candidat cand) {
        
        byte[] cand_photo=cand.getPhoto();
        if (cand_photo != null) {
	        try (ByteArrayInputStream input = new ByteArrayInputStream(cand_photo)) {
	            Image image = new Image(input);
	            imgCandidat.setImage(image);
	            double clipRadius = Math.min(imgCandidat.getFitWidth(), imgCandidat.getFitHeight()) / 2.0;

	            imgCandidat.setClip(new Circle(clipRadius, clipRadius, clipRadius));
	            

	          
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
         fullName.setText(cand.getFullname());
         cand_CIN.setText(cand.getCin());
         partiName.setText(cand.getParti());
         nbrVotes.setText("Total Votes : "+cand.getNbrVotes());
        
    }

}
