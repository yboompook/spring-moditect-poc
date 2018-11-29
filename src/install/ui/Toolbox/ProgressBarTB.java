package install.ui.Toolbox;

import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

/**
 * The type Progress bar tb.
 *
 * @author kevin
 */
public class ProgressBarTB {

    /**
     * Get progress bar.
     *
     * @return the progress bar
     */
    public static ProgressBar get() {
        ProgressBar progressBar = new ProgressBar();
        progressBar.setPrefSize(250,50);
        AnchorPane.setTopAnchor(progressBar,475.0);
        AnchorPane.setLeftAnchor(progressBar,375.0);

        return progressBar;
    }
}
