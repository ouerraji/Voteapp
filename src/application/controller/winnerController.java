package application.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import application.dao.WinnerDoa;
import application.model.Winner;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

/**
 *@author oussama erraji 
 */
public class winnerController {
	@FXML
    private ImageView partilogo;

    @FXML
    private Label votenumber;

    @FXML
    private ImageView winnerimg;

    @FXML
    private Label winnername;
public void initialize() {
	WinnerDoa doa=new WinnerDoa();
	Winner winner=doa.getWinner();
	votenumber.setText("Total Votes : "+winner.getVotes());
	winnername.setText("Gagnant des élections :\n"+winner.getFullname());
	byte[] photoCandidat=winner.getImg();
	if (photoCandidat != null) {
        try (ByteArrayInputStream input = new ByteArrayInputStream(photoCandidat)) {
            Image image = new Image(input);
            winnerimg.setImage(image);
            double clipRadius = Math.min(winnerimg.getFitWidth(), winnerimg.getFitHeight()) / 2.0;

            winnerimg.setClip(new Circle(clipRadius, clipRadius, clipRadius));
            

          
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        winnerimg.setImage(null);
    }
	byte[] photologo=winner.getLogo();
	if (photologo != null) {
        try (ByteArrayInputStream input = new ByteArrayInputStream(photologo)) {
            Image image = new Image(input);
            partilogo.setImage(image);
            double clipRadius = Math.min(partilogo.getFitWidth(), partilogo.getFitHeight()) / 2.0;

            partilogo.setClip(new Circle(clipRadius, clipRadius, clipRadius));
            

          
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
    	partilogo.setImage(null);
    }
}

}
