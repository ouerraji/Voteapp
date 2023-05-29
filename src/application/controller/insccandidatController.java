package application.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import java.io.ByteArrayOutputStream;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.paint.Color;

import javafx.scene.Node;
import javafx.stage.Stage;
import application.Main;
import application.dao.CandidatDAO;
import application.model.Candidat;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.scene.image.WritableImage;
import javafx.scene.image.PixelReader;


public class insccandidatController implements Initializable {

    @FXML
    private TextField Cni_txf;



    @FXML
    private Label adres_lab;

    @FXML
    private TextArea adresse_txA;

    @FXML
    private Button choosePhotoButton;

    @FXML
    private Label cni_lab;

    @FXML
    private DatePicker date_choser;

    @FXML
    private Label date_lab;

    @FXML
    private Label email_lab;

    @FXML
    private TextField email_tx;

    @FXML
    private ChoiceBox<String> genrechoice;

    @FXML
    private Label genre_lab;

    @FXML
    private ImageView image_view;

    @FXML
    private Label name_lab;

    @FXML
    private TextField name_tx;

    @FXML
    private PasswordField passowrd_value;

    @FXML
    private Label password_lab;

    @FXML
    private Label pic_lab;

    @FXML
    private Label prenom_lab;

    @FXML
    private TextField prenom_txf;



    private Candidat candidate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genrechoice.getItems().add("Homme");
        genrechoice.getItems().add("Femme");
    }

    @FXML
    private void choosePhoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Profile Photo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        File selectedFile = fileChooser.showOpenDialog(image_view.getScene().getWindow());

        if (selectedFile != null) {
            try {
                Image image = new Image(selectedFile.toURI().toString());
                image_view.setImage(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @FXML

    private void openPartiInterface(ActionEvent event) {
        if (name_tx.getText().isEmpty() || prenom_txf.getText().isEmpty() || Cni_txf.getText().isEmpty()
                || email_tx.getText().isEmpty() || date_choser.getValue() == null || genrechoice.getValue() == null
                || adresse_txA.getText().isEmpty() || passowrd_value.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Avertissement");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs.");
            alert.showAndWait();
        } else {
            Candidat candidate = getCandidateDataFromFirstInterface();
            if (candidate != null) {
                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/I2.fxml"));
                    Parent root = loader.load();

                    inscpartiController partyController = loader.getController();
                    partyController.setCandidate(candidate);

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Les informations du parti");
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Impossible de récupérer les informations du candidat.");
                alert.showAndWait();
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


    public Candidat getCandidateDataFromFirstInterface() {
        Candidat candidat = new Candidat();
        candidat.setNom(name_tx.getText().toString());
        candidat.setPrenom(prenom_txf.getText().toString());
        candidat.setGenre(genrechoice.getValue().charAt(0));
        candidat.setDate_Naiss(Date.valueOf(date_choser.getValue()));
        candidat.setAdresse(adresse_txA.getText().toString());
        candidat.setEmail(email_tx.getText().toString());
        candidat.setPassword(passowrd_value.getText().toString());
        candidat.setCin(Cni_txf.getText().toString());

        byte[] photoData = convertImageToByteArray(image_view.getImage());
        candidat.setPhoto(photoData);
System.out.println(candidat.getNom());
System.out.println(candidat.getDate_naissance());
System.out.println(candidat.getPhoto());





        return candidat;
    }

}