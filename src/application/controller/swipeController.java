package application.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Date;
import javafx.application.Platform;
import java.util.Timer;
import java.util.TimerTask;
import application.Main;
import application.dao.swipeDao;
import application.dao.timerDao;
import application.model.Swipeinfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



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
    private Label time;


	@FXML
	private Button right;
	@FXML
    private Hyperlink lireplus;
	@FXML
    private Label fullname;
	
    @FXML
    private ImageView partilogo;
    @FXML
    private Button votebutton;
    
  


	
	
	ArrayList<Swipeinfo> swipeinfos = new ArrayList<>();
	int index = 0;

	public void initialize() {
		
		swipeDao swipeDao = new swipeDao();
		swipeinfos = swipeDao.getSwipeinfos();
		if (swipeinfos.size() > 0) {
            showInfo(swipeinfos.get(index));
        }
		timerDao tdao=new timerDao();
		Date start=tdao.getStart();
		Date end=tdao.getEnd();
		Date now=new Date();
		if(now.after(end)) {
			time.setText("Delai :"+end);
		    time.setStyle("-fx-background-color: #ff1a1a; -fx-text-fill: white;");
		    Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Erreur de vote");
	        alert.setHeaderText(null);
	        alert.setContentText("Vous avez raté le vote !");
	        alert.showAndWait();
		    votebutton.setDisable(true);
			 }
		else if (now.before(end)) {
			time.setText("Delai :"+end);

			 time.setStyle("-fx-background-color: #00e600; -fx-text-fill: white;");	
			 }
		
        

	
    }
	



	private void showInfo(Swipeinfo swipeinfo) {
		// TODO Auto-generated method stub
		//Fullname.setText(swipeinfo.getFullName());
		
		fullname.setText(swipeinfo.getFullName());
		byte[] photoCandidat=swipeinfo.getCandidatPicture();
		if (photoCandidat != null) {
	        try (ByteArrayInputStream input = new ByteArrayInputStream(photoCandidat)) {
	            Image image = new Image(input);
	            candidatimg.setImage(image);
	            double clipRadius = Math.min(candidatimg.getFitWidth(), candidatimg.getFitHeight()) / 2.0;

	            candidatimg.setClip(new Circle(clipRadius, clipRadius, clipRadius));
	            

	          
	           
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
	        alert.setContentText("Vous avez déjà voté !");
	        alert.showAndWait();
	        return;
    } 
    else {Alert confirmation = new Alert(AlertType.CONFIRMATION);
    confirmation.setTitle("Confirmation");
    confirmation.setHeaderText("Confirmer le vote");
    confirmation.setContentText("Êtes-vous sûr de vouloir voter pour " + swipeinfos.get(index).getFullName() + " ?\nCette action est irréversible.");
    confirmation.getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);
    ButtonType answer = confirmation.showAndWait().orElse(ButtonType.CANCEL);
    if (answer == ButtonType.OK) {
    	swipeDao dao=new swipeDao();
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		
		dao.inserVote(id_elec,timestamp, swipeinfos.get(index).getId_candidat());
        
        Alert success = new Alert(AlertType.INFORMATION);
        success.setTitle("Succès");
        success.setHeaderText(null);
        success.setContentText("Vote enregistré avec succès !");
        success.showAndWait();
        votebutton.setDisable(true);
    }
}
		
		

    }
	@FXML
    void lireolusClicked(ActionEvent event) {
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/readMore.fxml"));
            Parent root = loader.load();
            readMoreController readMoreController = loader.getController();
            readMoreController.initializeWithIdcand(swipeinfos.get(index).getId_candidat());

            Scene scene = new Scene(root);
            Stage neew = new Stage();
            neew.setScene(scene);
            neew.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}