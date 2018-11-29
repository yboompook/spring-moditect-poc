package install.ui.Toolbox;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Scene tb.
 *
 * @author kevin
 */
public class SceneTB {

    private static Logger log = LogManager.getLogger(SceneTB.class);

    private static Stage stage;

    /**
     * Gets start windows.
     *
     * @param primaryStage the primary stage
     * @return the start windows
     */
    public static Scene getStartWindows(Stage primaryStage) {
        setStage(primaryStage);

        AnchorPane aPane = new AnchorPane();

        aPane.getChildren().addAll(ButtonTB.getStart(stage));
        Scene scene = new Scene(aPane, 1000, 800);
        log.info("Scene for the startWindow");
        return scene;
    }

    /**
     * Gets spiner windows.
     *
     * @param primaryStage the primary stage
     * @param message      the message
     * @return the spiner windows
     */
    public static Scene getSpinerWindows(Stage primaryStage, String message) {
        setStage(primaryStage);

        AnchorPane aPane = new AnchorPane();

        aPane.getChildren().addAll(ProgressBarTB.get(), LabelTB.getMessage(message));

        Scene scene = new Scene(aPane, 1000, 800);

        log.info("Scene for the spinerWindow");
        return scene;
    }

    /**
     * method that set the stage to pass between Scene
     *
     * @param primaryStage
     */
    private static void setStage(Stage primaryStage) {
        if (stage == null) {
            stage = primaryStage;
        }
    }

}
