package install.ui;

import install.ui.Toolbox.SceneTB;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Windows.
 *
 * @author kevin
 */
public class Windows {

    private static Logger log = LogManager.getLogger(Windows.class);

    private static Stage stage;

    /**
     * Start window.
     *
     * @param stage the stage
     */
    public static void StartWindow(Stage stage) {

        setStage(stage);
        stage.setTitle("CertyPrint : First menu windows");
        Scene scene = SceneTB.getStartWindows(stage);
        stage.setScene(scene);
        log.debug("stage ready for startWindow");
        stage.show();
    }

    /**
     * Spiner window.
     *
     * @param stage   the stage
     * @param message the message
     */
    public static void SpinerWindow(Stage stage, String message) {

        setStage(stage);
        stage.setTitle("CertyPrint : First menu windows");
        Scene scene = SceneTB.getSpinerWindows(stage, message);
        stage.setScene(scene);
        log.debug("stage ready for spinerWindows");
        stage.show();
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
