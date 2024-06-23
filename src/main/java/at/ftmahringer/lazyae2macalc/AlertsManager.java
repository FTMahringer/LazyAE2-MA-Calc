package at.ftmahringer.lazyae2macalc;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertsManager extends Alert {

    public AlertsManager(AlertType alertType, String title, String message, String header) {
        super(alertType, message, ButtonType.OK);
        setTitle(title);
        setHeaderText(header);
        setContentText(message);

        showAndWait();
    }

    public static void infoAlert(String title, String header, String content) {
        Alert alert = new AlertsManager(AlertType.INFORMATION, title, content, header);
    }

    public static void errorAlert(String title, String header, String content) {
        Alert alert = new AlertsManager(AlertType.ERROR, title, content, header);
    }

    public static void warningAlert(String title, String header, String content) {
        Alert alert = new AlertsManager(AlertType.WARNING, title, content, header);
    }
}
