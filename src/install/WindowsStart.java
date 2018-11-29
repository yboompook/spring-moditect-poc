package install;

import install.ui.Windows;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The type Windows start.
 *
 * @author kevin
 */
public class WindowsStart extends Application {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


    /**
     * transform primaryStage in first menu windows
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        Windows.StartWindow(primaryStage);
    }
}