package roger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import roger.storage.Storage;
import roger.ui.Parser;
import roger.ui.controllers.MainWindow;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * A launcher class to workaround classpath issues.
 */
public class Launcher extends Application {

    private Parser parser;
    private Storage storage;
    private Roger roger;

    /**
     * Start the Roger backend, and the JavaFX UI elements.
     * @param stage The JavaFX stage used.
     */
    @Override
    public void start(Stage stage) {
        parser = new Parser();
        storage = new Storage(Paths.get("./data/tasks.txt"));
        roger = new Roger(parser, storage);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            MainWindow mainWindow = fxmlLoader.<MainWindow>getController();
            mainWindow.setRogerClass(roger);
            stage.show();
            mainWindow.greet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
