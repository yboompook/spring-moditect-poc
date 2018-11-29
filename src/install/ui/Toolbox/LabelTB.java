package install.ui.Toolbox;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Label tb.
 *
 * @author kevin
 */
public class LabelTB {

    private static Logger log = LogManager.getLogger(LabelTB.class);

    private static Label labelMessage;

    /**
     * Gets message.
     *
     * @param message the message
     * @return the message
     */
    public static Label getMessage(String message) {
        if (labelMessage == null) {
            labelMessage = new Label();
            labelMessage.setPrefSize(250,50);
            AnchorPane.setTopAnchor(labelMessage,275.0);
            AnchorPane.setLeftAnchor(labelMessage,375.0);
        }
        labelMessage.setText(message);
        log.debug("getLabelNotification");
        return labelMessage;
    }
}
