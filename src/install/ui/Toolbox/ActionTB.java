package install.ui.Toolbox;

import install.bll.Install;
import install.ui.Windows;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Action tb.
 *
 * @author kevin
 */
public class ActionTB {
    private static Logger log = LogManager.getLogger(ActionTB.class);

    /**
     * Gets action start.
     *
     * @param stage the stage
     * @return the action start
     */
    public static EventHandler<ActionEvent> getActionStart(Stage stage) {
        EventHandler<ActionEvent> actionStart = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Windows.SpinerWindow(stage, "wait while certytehc create installation process");
                Install i = Install.getInstance();
                i.setup();
//                final Service<Void> setup = new Service<Void>() {
//                    @Override
//                    protected Task<Void> createTask() {
//                        return new Task<Void>() {
//                            @Override
//                            protected Void call() {
//                                i.setup();
//                                return null;
//                            }
//                        };
//                    }
//                };
//                setup.stateProperty().addListener((ObservableValue<? extends Worker.State> observableValue, Worker.State oldValue, Worker.State newValue) -> {
//                    switch (newValue) {
//                        case FAILED:
//                            System.out.println("failed");
//                        case CANCELLED:
//                        case SUCCEEDED:
//                            Windows.PrinterInstallWindow(stage, i.getPrinter());
//                            break;
//                    }
//                });
//                setup.setOnFailed((WorkerStateEvent e) -> {
//                    // La tâche a échoué.
//                    final Throwable error = setup.getException();
//                    System.out.println("error : " + e + " // trow : " + error);
//                });
//                setup.start();
            }
        };
        log.debug("getActionStart");
        return actionStart;
    }

}
