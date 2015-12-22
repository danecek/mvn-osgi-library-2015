package dialogs;

import java.util.Optional;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HelloWorldDialog extends Dialog<ButtonType> { 
    
    TextField tf = new TextField();

    public HelloWorldDialog(Stage s) {
        super();
        
        setTitle("Text Input");
        getDialogPane().setContent(new BorderPane (tf));
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

    }

}
