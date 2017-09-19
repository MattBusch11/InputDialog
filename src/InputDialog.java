/**
 *@author mbb23738@email.vccs.edu
 * Author: Matt Busch
 * Date: 9/18/17
 * Purpose: To demonstrate usage of JOptionPane and JavaFX dialog boxes
 */

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Optional;



public class InputDialog extends Application{
    public void start(Stage primaryStage) throws Exception {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");//limit decimal of output to two digits
        Toolkit toolkit = Toolkit.getDefaultToolkit();//allow changing the location of the dialog box
        Dimension screenDimension = toolkit.getScreenSize();
        double screenWidth = screenDimension.getWidth();
        double screenHeight = screenDimension.getHeight();

        TextInputDialog inputDialog = new TextInputDialog();//create input dialog box
        inputDialog.setTitle("Enter Value");
        inputDialog.setHeaderText("Centimeter to feet/inches converter");
        inputDialog.setContentText("Enter Centimeter value");
        inputDialog.setX(600);
        inputDialog.setY(0);
        Optional<String> result = inputDialog.showAndWait();

        double dblCm, in, ft;//establish and assign variables for JavaFX
        dblCm = Double.parseDouble(result.get());
        in = dblCm * 0.39;
        ft = in / 12;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);//create output dialog box
        alert.getDialogPane().setPrefSize(500, 100);
        alert.setTitle("Result");
        alert.setContentText(dblCm + "centimeters = " + decimalFormat.format(in) + " inches = " + decimalFormat.format(ft) + " feet.");
        alert.setX(500);
        alert.setY(640);
        alert.showAndWait();


        double dblInput, inJ, ftJ;//establish variables for JOption
        DecimalFormat decimalFormatJ = new DecimalFormat("#.##");

        Dimension dimension = toolkit.getScreenSize();
        JOptionPane pane = new JOptionPane("Enter Centimeter value");//create input dialog box
        JDialog dialog;
        pane.setWantsInput(true);
        dialog = pane.createDialog("Centimeter to inches to feet converter");

        dialog.setLocation(0, 350);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        dblInput = Double.parseDouble((String) pane.getInputValue());//assign variables for JOption
        inJ = dblInput * 0.39;
        ftJ = inJ / 12;
        //create output dialog box
        JOptionPane resultPane = new JOptionPane(dblInput + " centimeters = " + decimalFormatJ.format(inJ) + " inches = " + decimalFormatJ.format(ftJ) + " feet.");
        JDialog resultDialog;
        resultDialog = resultPane.createDialog("Result");
        resultDialog.setLocation(1200, 350);
        resultDialog.setAlwaysOnTop(true);
        resultDialog.setVisible(true);
    }
}
