package at.ftmahringer.lazyae2macalc;

public enum Scenes {
    // use SceneType scenes = SceneType.MAIN_MENU; to get the path of the mainMenu.fxml file

    CALC("calc-view.fxml", "Calc")
    ;

    final String fxmlPath;
    final String title;

    Scenes(String fxmlPath, String title) {
        this.fxmlPath = fxmlPath;
        this.title = title;
    }

    public String getPath() {
        return fxmlPath;
    }

    public String getTitle() {
        return title;
    }
}
