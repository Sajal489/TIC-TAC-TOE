/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticktactoe;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

class Tuple {

    public int player;
    public int bot;

    public Tuple(int player, int bot) {
        this.player = player;
        this.bot = bot;
    }
}

public class FXMLDocumentController implements Initializable {

    @FXML
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, start;
    static Button arr[][] = new Button[3][3];
    static Rectangle fin[] = new Rectangle[8];
    @FXML
    Label congrats;
    @FXML
    Rectangle ud1, ud2, ud3, lr1, lr2, lr3, d1, d2;
    int count = 0;
    static final int size = 8;

    @FXML
    private void handleStartButtonAction(ActionEvent event) {
        start.setDisable(true);
        congrats.setText("");
        count = 0;
        init();
        for (int i = 0; i < fin.length; i++) {
            fin[i].setVisible(false);
            
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j].setDisable(false);
                arr[i][j].setText("");
            }
        }

    }

    public void init() {
        arr[0][0] = b1;
        arr[0][1] = b2;
        arr[0][2] = b3;
        arr[1][0] = b4;
        arr[1][1] = b5;
        arr[1][2] = b6;
        arr[2][0] = b7;
        arr[2][1] = b8;
        arr[2][2] = b9;
        fin[0] = ud1;
        fin[1] = ud2;
        fin[2] = ud3;
        fin[3] = lr1;
        fin[4] = lr2;
        fin[5] = lr3;
        fin[6] = d1;
        fin[7] = d2;
 


    }

    public void setdis() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j].setDisable(true);
            }
        }
    }

    public void endgame() {
        congrats.setText("Tie");
        start.setDisable(false);
    }

    @FXML
    private void handleb1Action(ActionEvent event) {
        if (!b1.getText().equals("")) {
            return;
        }
        b1.setText("X");
        count++;
        if (count >= size) {
            endgame();
            return;
        }
        yourturn();

    }

    @FXML
    private void handleb2Action(ActionEvent event) {
        if (!b2.getText().equals("")) {
            return;
        }
        b2.setText("X");
        count++;
        if (count >= size) {
            endgame();
            return;
        }

        yourturn();

    }

    @FXML
    private void handleb3Action(ActionEvent event) {
        if (!b3.getText().equals("")) {
            return;
        }
        b3.setText("X");
        count++;
        if (count >= size) {
            endgame();
            return;
        }

        yourturn();
    }

    @FXML
    private void handleb4Action(ActionEvent event) {
        if (!b4.getText().equals("")) {
            return;
        }
        b4.setText("X");
        count++;
        if (count >= size) {
            endgame();
            return;
        }

        yourturn();

    }

    @FXML
    private void handleb5Action(ActionEvent event) {
        if (!b5.getText().equals("")) {
            return;
        }
        b5.setText("X");

        count++;
        if (count >= size) {
            endgame();
            return;
        }

        yourturn();

    }

    @FXML
    private void handleb6Action(ActionEvent event) {
        if (!b6.getText().equals("")) {
            return;
        }
        b6.setText("X");
        count++;
        if (count >= size) {
            endgame();
            return;
        }

        yourturn();

    }

    @FXML
    private void handleb7Action(ActionEvent event) {
        if (!b7.getText().equals("")) {
            return;
        }
        b7.setText("X");
        count++;
        if (count >= size) {
            endgame();
            return;
        }

        yourturn();

    }

    @FXML
    private void handleb8Action(ActionEvent event) {
        if (!b8.getText().equals("")) {
            return;
        }
        b8.setText("X");
        count++;
        if (count >= size) {
            endgame();
            return;
        }

        yourturn();

    }

    @FXML
    private void handleb9Action(ActionEvent event) {
        if (!b9.getText().equals("")) {
            return;
        }
        b9.setText("X");
        count++;
        if (count >= size) {
            endgame();
            return;
        }

        yourturn();

    }

    public void yourturn() {
        if (check(0)) {
            congrats.setText("YOU WIN!!!");
            setdis();
            start.setDisable(false);
        } else {
            compturn();
            count++;
        }

    }

    public void compturn() {
        if (off()) {
            congrats.setText("Bot Wins!!");
            start.setDisable(false);
        } else if (def()) {
        } else {
            Random n = new Random();
            while (true) {
                int i = n.nextInt(3);
                int j = n.nextInt(3);
                if (arr[i][j].getText().equals("")) {
                    arr[i][j].setText("O");
                    break;
                }
            }
        }
        if (check(1)) {
            congrats.setText("Bot Wins!!");
            setdis();
            start.setDisable(false);
        }
    }

    public boolean off() {
        for (int i = 0; i < 8; i++) {
            Tuple t = checker(i);
            if (t.bot == 2 && t.player == 0) {
                fix(i);
                return true;
            }

        }
        return false;
    }

    public boolean def() {

        for (int i = 0; i < 8; i++) {
            Tuple t = checker(i);
            if (t.player == 2 && t.bot == 0) {
                fix(i);
                return true;
            }

        }
        return false;

    }

    public void fix(int n) {
        switch (n) {
            case 0:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][0].getText().equals("")) {
                        arr[i][0].setText("O");
                    }
                }
                break;
            case 1:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][1].getText().equals("")) {
                        arr[i][1].setText("O");
                    }
                }
                break;
            case 2:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][2].getText().equals("")) {
                        arr[i][2].setText("O");
                    }
                }
                break;
            case 3:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[0][i].getText().equals("")) {
                        arr[0][i].setText("O");
                    }
                }
                break;
            case 4:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[1][i].getText().equals("")) {
                        arr[1][i].setText("O");
                    }
                }
                break;
            case 5:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[2][i].getText().equals("")) {
                        arr[2][i].setText("O");
                    }
                }
                break;
            case 6:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][i].getText().equals("")) {
                        arr[i][i].setText("O");
                    }
                }
                break;
            case 7:
                int j = arr.length - 1;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][j].getText().equals("")) {
                        arr[i][j].setText("O");;
                    }
                    j--;
                }
                break;

        }
        return;

    }

    public boolean check(int n) {
        Tuple t;
        switch (n) {
            case 0:
                for (int i = 0; i < 8; i++) {
                    t = checker(i);
                    if (t.player == 3) {
                        fin[i].setVisible(true);
                        return true;
                    }
                }
                break;
            case 1:
                for (int i = 0; i < 8; i++) {
                    t = checker(i);
                    if (t.bot == 3) {
                        fin[i].setVisible(true);
                        return true;
                    }
                }

        }
        return false;

    }

    public Tuple checker(int n) {
        int bot, player;
        bot = player = 0;
        Tuple t;
        switch (n) {
            case 0:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][0].getText().equals("X")) {
                        player++;
                    } else if (arr[i][0].getText().equals("O")) {
                        bot++;
                    }
                }
                t = new Tuple(player, bot);
                return t;
            case 1:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][1].getText().equals("X")) {
                        player++;
                    } else if (arr[i][1].getText().equals("O")) {
                        bot++;
                    }
                }
                t = new Tuple(player, bot);
                return t;
            case 2:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][2].getText().equals("X")) {
                        player++;
                    } else if (arr[i][2].getText().equals("O")) {
                        bot++;
                    }
                }
                t = new Tuple(player, bot);
                return t;
            case 3:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[0][i].getText().equals("X")) {
                        player++;
                    } else if (arr[0][i].getText().equals("O")) {
                        bot++;
                    }
                }
                t = new Tuple(player, bot);
                return t;
            case 4:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[1][i].getText().equals("X")) {
                        player++;
                    } else if (arr[1][i].getText().equals("O")) {
                        bot++;
                    }
                }
                t = new Tuple(player, bot);
                return t;
            case 5:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[2][i].getText().equals("X")) {
                        player++;
                    } else if (arr[2][i].getText().equals("O")) {
                        bot++;
                    }
                }
                t = new Tuple(player, bot);
                return t;
            case 6:
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][i].getText().equals("X")) {
                        player++;
                    } else if (arr[i][i].getText().equals("O")) {
                        bot++;
                    }
                }
                t = new Tuple(player, bot);
                return t;
            case 7:
                int j = arr.length - 1;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i][j].getText().equals("X")) {
                        player++;
                    } else if (arr[i][j].getText().equals("O")) {
                        bot++;
                    }
                    j--;
                }
                t = new Tuple(player, bot);
                return t;

        }
        return null;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
