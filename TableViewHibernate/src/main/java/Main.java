import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Scene scene;
    public static void main(String[] args) {
            launch();
        }

        @Override
        public void start(Stage stage) throws Exception {
            scene = new Scene(loadFXML("CadastroController"));
            stage.setScene(scene);
            stage.show();
        }

        private static Parent loadFXML(String fxml) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
            return fxmlLoader.load();
        }
    }