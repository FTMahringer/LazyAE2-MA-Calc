module at.ftmahringer.lazyae2macalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.ftmahringer.lazyae2macalc to javafx.fxml;
    exports at.ftmahringer.lazyae2macalc;
}