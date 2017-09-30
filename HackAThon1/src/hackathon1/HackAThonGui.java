/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackathon1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sun.applet.Main;

/**
 *
 * @author Abdul
 */
public class HackAThonGui extends Application implements EventHandler {

    String names[][] = new String[9][30];
    Label txtName;
    Button btnExit;
    Button btnStart;
    Button btnInsert;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9;

    @Override
    public void start(Stage stage) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 20; j++) {
                names[i][j] = i + " - " + j;
            }
        }
        txtName = new Label("Random Name");
        txtName.setMinSize(15, 10);
        //RadioButtons

        rb1 = new RadioButton("Male");
        rb2 = new RadioButton("Female");
        rb3 = new RadioButton("Both");
        final ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb3.setSelected(true);
        rb2.setToggleGroup(group);
        rb3.setToggleGroup(group);

        //Buttons
        btnInsert = new Button("Insert new Name");
        btnStart = new Button("Generate");
        btnExit = new Button("Exit");
        btnExit.setOnAction(this);
        btnStart.setOnAction(this);
        btnInsert.setOnAction(this);

        //pictures
//        String link ="us_flag" + ".png" ;
//        final Image image = new Image(getClass().getResourceAsStream( link ));
//        final ImageView imv = new ImageView();
//        final Image image2 = new Image(getClass().getResourceAsStream(link));
//        imv.setImage(image2);
        //CheckBoxes
        cb1 = new CheckBox("one");
        //cb1.setGraphic(image);
        cb2 = new CheckBox("two");
        cb3 = new CheckBox("three");
        cb4 = new CheckBox("four");
        cb5 = new CheckBox("five");
        cb6 = new CheckBox("six");
        cb7 = new CheckBox("seven");
        cb8 = new CheckBox("eight");
        cb9 = new CheckBox("nine");

        HBox hboxT = new HBox(rb3, rb1, rb2);
        HBox hboxB = new HBox(btnStart, txtName, btnExit);
        hboxT.setAlignment(Pos.CENTER);
        hboxB.setAlignment(Pos.CENTER);
        Insets inset = new Insets(10, 10, 10, 10);
        //hboxT Qualities
        hboxT.setPadding(inset);
        hboxT.setSpacing(50);
        hboxT.setMinSize(100, 120);
        //hboxB qualities
        hboxB.setPadding(inset);
        hboxB.setSpacing(5);
        hboxB.setMinSize(100, 120);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.add(cb1, 0, 0);
        grid.add(cb2, 0, 1);
        grid.add(cb3, 0, 2);
        grid.add(cb4, 1, 0);
        grid.add(cb5, 1, 1);
        grid.add(cb6, 1, 2);
        grid.add(cb7, 2, 0);
        grid.add(cb8, 2, 1);
        grid.add(cb9, 2, 2);

        BorderPane root = new BorderPane();
        root.setTop(hboxT);
        root.setBottom(hboxB);
        root.setCenter(grid);

        Scene scene = new Scene(root, 300, 300);

        stage.setTitle("Name Generator ");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void start(String[] args, String x[][]) {

        launch();
    }

    @Override
    public void handle(Event e) {
        Button b = (Button) e.getSource();

        if (b.getText().equals("Generate")) {

            String radio = randomString();
            txtName.setText(radio);

        } else if (b.getText().equals("Exit")) {

            System.exit(-1);
        }
    }

    int radioButtonCheck() {
        int radio = 0;
        if (rb1.isSelected() == true) {
            radio = 1;
        } else if (rb2.isSelected() == true) {
            radio = 2;
        } else if (rb3.isSelected() == true) {
            radio = 3;
        }
        return radio;
    }

    String CheckBoxCheck() {
        String filter = "";
        if (cb1.isSelected() == true) {
            filter = "1";
        }
        if (cb2.isSelected() == true) {
            filter = filter + "2";
        }
        if (cb3.isSelected() == true) {
            filter = filter + "3";
        }
        if (cb4.isSelected() == true) {
            filter = filter + "4";
        }
        if (cb5.isSelected() == true) {
            filter = filter + "5";
        }
        if (cb6.isSelected() == true) {
            filter = filter + "6";
        }
        if (cb7.isSelected() == true) {
            filter = filter + "7";
        }
        if (cb8.isSelected() == true) {
            filter = filter + "8";
        }
        if (cb9.isSelected() == true) {
            filter = filter + "9";
        }
        return filter;
    }

    String randomString() {
        String found = "fat";
        int max = 0, maxy = 0;
        int y = 0;

        //for the males and females
        int x = radioButtonCheck();

        if (x == 1) {
            x = 0;
            y = 10;
        } else if (x == 2) {
            x = 10;
            y = 20;
        } else if (x == 3) {
            x = 0;
            y = 20;
        }

//        //for the countries
        int arrayOfInt[] = new int[9];
        int m = 0;
        int Imax = 0;

//        while (m < 9) {
//            arrayOfInt[m] = 1;
//        }
        m = 0;

        if (cb1.isSelected() == true) {
            arrayOfInt[m] = 1;
            Imax = 1;
            m++;
            max = 0;
        }
        if (cb2.isSelected() == true) {
            arrayOfInt[m] = 2;
            Imax = 2;
            m++;
            max = 1;
        }
        if (cb3.isSelected() == true) {
            arrayOfInt[m] = 3;
            Imax = 3;
            m++;
            max = 2;
        }
        if (cb4.isSelected() == true) {
            arrayOfInt[m] = 4;
            Imax = 4;
            m++;
            max = 3;
        }
        if (cb5.isSelected() == true) {
            arrayOfInt[m] = 5;
            Imax = 5;
            m++;
            max = 4;
        }
        if (cb6.isSelected() == true) {
            arrayOfInt[m] = 6;
            Imax = 6;
            m++;
            max = 5;
        }
        if (cb7.isSelected() == true) {
            arrayOfInt[m] = 7;
            Imax = 7;
            m++;
            max = 6;
        }
        if (cb8.isSelected() == true) {
            arrayOfInt[m] = 8;
            Imax = 8;
            m++;
            max = 7;
        }
        if (cb9.isSelected() == true) {
            arrayOfInt[m] = 9;
            Imax = 9;
            m++;
            max = 8;

        }

        //if check boxes are selected
        if (m == 0) {
            max = 1;
        }

//        m = 0;
//        Imax = 1;
        String arrayOfNames[][] = new String[9][20];
        // JOptionPane.showMessageDialog(null, "start of loop");

        for (int i = 0; i < 9; i++) {
            for (int j = x; j < y; j++) {
                arrayOfNames[i][j] = names[i][j];
                System.out.println(arrayOfNames[i][j]);
                
            }

        }
        maxy = y;

//        JOptionPane.showMessageDialog(null, "max = " + max);
//        JOptionPane.showMessageDialog(null, "maxy = " + maxy);
        int rand1, rand2;
        rand1 = (int) (Math.random() * (max + 1) + 1);
        rand2 = (int) (Math.random() * (maxy + 1) + 1);
//        JOptionPane.showMessageDialog(null, "rand1 = " + rand1);
//        JOptionPane.showMessageDialog(null, "rand2 = " + rand2);
        if (max == 0) {
            found = arrayOfNames[rand1][rand2 - 1];
        } else {
            found = arrayOfNames[rand1 - 1][rand2 - 1];
        }
        found = arrayOfNames[max + 1][rand2 - 1];
        return found;
    }

}
