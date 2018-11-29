package install.ui.Toolbox;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Button tb.
 *
 * @author kevin
 */
public class ButtonTB {

    private static Logger log = LogManager.getLogger(ButtonTB.class);

    private static Button start;

    /**
     * Gets start.
     *
     * @param stage the stage
     * @return the start
     */
    public static Button getStart(Stage stage) {
        if (start == null)
        {
            start = new Button("start");
            start.setPrefSize(250,100);
            AnchorPane.setTopAnchor(start,350.0);
            AnchorPane.setLeftAnchor(start,375.0);
            start.setOnAction(ActionTB.getActionStart(stage));
        }
        log.debug("button start created");
        return start;
    }

}
