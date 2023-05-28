package application.controller;

import java.awt.Image;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import application.util.DBconnection;
import application.model.Parti;
import application.util.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class PartiController implements Initializable{
	public Connection cnx;
	public PreparedStatement pst;
	public ResultSet rs;

 
    @FXML
    private Button ButtonRechercher;


    @FXML
    private TextField EnterParti;

    @FXML
    private TableView<Parti> TableParti;

    @FXML
    private TableColumn<Parti, String> Tdesc;

    @FXML
    private TableColumn<Parti, Integer> Tidparti;

    @FXML
    private TableColumn<Parti, String> Tnom;

    @FXML
    private TableColumn<Parti, String> Ttele;
    public ObservableList<Parti> data = FXCollections.observableArrayList();
    	private Boolean CheckEmpty() {
        	return (EnterParti.getText().equals(""));}
  
    @FXML
    void ClickButtonRechercher(ActionEvent event) {
    	if(CheckEmpty()==true) {
    		Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Avertissement");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir l'id du parti recherché");
            Optional<ButtonType> result = alert.showAndWait();
    	}else {
        	String partiid=EnterParti.getText();
        	EnterParti.clear();
        	TableParti.getItems().clear();
        	String queryy ="Select * from election.Parti where id_parti=?";
        	   
    		try {
				pst=cnx.prepareStatement(queryy);
	    		pst.setString(1,partiid);
	    		rs=pst.executeQuery();
				 if(rs.next()) {
		    			data.add(new Parti(rs.getInt("id_parti"),rs.getString("nom"),rs.getString("Description"),rs.getString("tel")));

				 }else {
					 Alert alert=new Alert(AlertType.ERROR);
			        	alert.setTitle("Avertissement");
			            alert.setHeaderText(null);
			            alert.setContentText("Aucun parti trouvé");
			            Optional<ButtonType> result = alert.showAndWait();
				 }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    		Tidparti.setCellValueFactory(new PropertyValueFactory<Parti,Integer>("id_parti"));
        	Tnom.setCellValueFactory(new PropertyValueFactory<Parti,String>("nom"));
        	Tdesc.setCellValueFactory(new PropertyValueFactory<Parti,String>("Description"));
        	Ttele.setCellValueFactory(new PropertyValueFactory<Parti,String>("tel"));
        	TableParti.setItems(data);
        }};

  
    public void ShowParti(){
    	String query ="Select * from election.parti";
    	try {
    		pst=cnx.prepareStatement(query);
    		rs=pst.executeQuery();
    		while(rs.next()) {
    			data.add(new Parti(rs.getInt("id_parti"),rs.getString("nom"),rs.getString("Description"),rs.getString("tel")));
    		}
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	Tidparti.setCellValueFactory(new PropertyValueFactory<Parti,Integer>("id_parti"));
    	Tnom.setCellValueFactory(new PropertyValueFactory<Parti,String>("nom"));
    	Tdesc.setCellValueFactory(new PropertyValueFactory<Parti,String>("Description"));
    	Ttele.setCellValueFactory(new PropertyValueFactory<Parti,String>("tel"));
    	TableParti.setItems(data);
    };	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cnx =DBconnection.getConnection();	
		ShowParti();
	}

}
