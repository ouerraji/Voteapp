package application.controller;

import java.sql.Date;
import java.time.LocalDate;


import application.dao.timerDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * @author oussama erraji
 */
public class TimeController {
	@FXML
	private DatePicker end;

	@FXML
	private DatePicker start;

	@FXML
	private TextField test;

	@FXML
	private Button validbtn;

	@FXML
	void validerClicked(ActionEvent event) {
		LocalDate startDate = start.getValue();
        LocalDate endDate = end.getValue();

        // Convert LocalDate to java.sql.Date
        Date startSql = Date.valueOf(startDate);
        Date endSql = Date.valueOf(endDate);
		timerDao timerDao = new timerDao();
		timerDao.settime(startSql, endSql);
	}

}
