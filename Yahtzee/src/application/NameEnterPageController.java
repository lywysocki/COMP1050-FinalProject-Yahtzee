package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NameEnterPageController implements Initializable {
    @FXML
    private Button BTNnewPlayerName;
  
    private int playerNumber=1;
    
    @FXML
    private Label playerNamePromptLabel;
    
    private ArrayList<Player> players;
    private ArrayList<String> names;

    @FXML
    private TextField playerNametf;
    
    public void initData(ArrayList<Player> players) {
    	this.players=players;
    	playerNamePromptLabel.setText(String.format("Player %d, please enter your name", playerNumber));
    	System.out.printf("size of arraylist: %d%n", players.size());
    }
    
    @FXML
    void newPlayerNameClicked(ActionEvent event) throws IOException {
    	if(playerNumber<players.size()) {
    		players.get(playerNumber-1).setName(playerNametf.getText());
    		playerNametf.deleteText(0, (playerNametf.getText().length()));
    		playerNumber+=1;
    		playerNamePromptLabel.setText(String.format("Player %d, please enter your name", playerNumber));
    		System.out.printf("Player %d name: %s%n", playerNumber-1, players.get(playerNumber-2).getName());
    	}
    	else {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("Game.fxml"));
    		Parent gameView= loader.load();
    		
    		Scene gamePlayScene = new Scene(gameView);
    		
    		GamePlayController gController = loader.getController();
    		gController.initData(players);
    		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    		window.setScene(gamePlayScene);
    		window.show();
    	}
    }

    
    
    
  
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
}

	