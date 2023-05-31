package application.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import application.dao.CandidatDAO;
import application.dao.partiDAO;
import application.model.Candidat;
import application.model.Parti;
import application.util.DBconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.stage.FileChooser;

public class inscpartiController {

    @FXML
    private Label NomLab;

    @FXML
    private TextField NomValue;

    @FXML
    private Button choosePhotoButton;

    @FXML
    private TextArea descValue;

    @FXML
    private Label descriLab;

    @FXML
    private ImageView imageView;

    @FXML
    private Button inscrir;

    @FXML
    private Label logoL;

    @FXML
    private TextField phoneValue;

    @FXML
    private Label phoneLab;

    private Parti currentParty;

    private Candidat candidate;




    public inscpartiController() {

    }


    @FXML

    void inscrir(ActionEvent event) {
        try {
            String nom = NomValue.getText().toString();
            byte[] logoData = convertImageToByteArray(imageView.getImage());
            String description = descValue.getText().toString();
            String phoneNumber = phoneValue.getText().toString();
            Parti party = new Parti(nom, logoData, description, phoneNumber);

            candidate.setParty(party);

            savePartyAndCandidate(party, candidate);
            Scene currentScene = inscrir.getScene();
            Window currentWindow = currentScene.getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Home.fxml"));
            Parent root = loader.load();
            HomeController homeController = loader.getController();

            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.setTitle("Your Title");
currentWindow.hide();
   
 newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public void savePartyAndCandidate(Parti parti, Candidat candidat) throws SQLException {
        partiDAO partiDao = new partiDAO();
        CandidatDAO candidatDao = new CandidatDAO();

        Connection connection = DBconnection.getConnection();
        connection.setAutoCommit(false); 

        try {
            int partyId = partiDao.addparti(parti,connection); // Pass the connection to addparti
            if (partyId != -1) {
                candidat.getParty().setId_parti(partyId);
                boolean candidatAdded = candidatDao.addCandidat(candidat,connection);
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inscription reussite");
                alert.setHeaderText(null);

                alert.setContentText(" Inscription reussite !");
                Optional<ButtonType> result = alert.showAndWait();
               

                if (candidatAdded) {
                    connection.commit(); 
                } else {
                    connection.rollback(); 
                }
            } else {
                connection.rollback(); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

    }



    @FXML
    private void choosePhoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Profile Photo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(imageView.getScene().getWindow());

        if (selectedFile != null) {
            try {
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private byte[] convertImageToByteArray(Image image) {
        try {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", outputStream);
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void setCandidate(Candidat candidate) {
        this.candidate = candidate;
    }

}
