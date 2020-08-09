package pageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class pageFunctions {
    private Pane view ;

    public Pane getPane(String fileName) throws FileNotFoundException {
        try {
            URL fileUrl;
            fileUrl = view.controller.LoginFormController.class.getResource("../fxml/" + fileName + ".fxml");

            view = new FXMLLoader().load(fileUrl);
        } catch(IOException e){
            e.printStackTrace();
        }
        return view;
    }
}
