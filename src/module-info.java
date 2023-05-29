module VotingApp {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.base;
	requires javafx.swing;
	//requires jfxrt;
	
	opens application to javafx.graphics, javafx.fxml;
	opens application.model to javafx.base;
   // opens application.view to javafx.fxml;
	exports application;
    //exports application.view;
    exports application.controller;
    opens application.controller to javafx.fxml;



}


