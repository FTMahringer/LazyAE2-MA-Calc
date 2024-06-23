package at.ftmahringer.lazyae2macalc;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class CalcController {
    public TextField width;
    public TextField height;
    public TextField vents;
    public TextField frames;
    public TextField patternProvider;
    public TextField coProzessor;
    public TextField patternProviderTwo;
    public TextField coProzessorTwo;

    public void calculate(ActionEvent actionEvent) {
        // please get the widht and height as Integer and check if they are valid

        int width = Integer.parseInt(this.width.getText());
        int height = Integer.parseInt(this.height.getText());
        // please check if valid
        if (width < 0 || height < 0) {
            AlertsManager.errorAlert("Error", "Invalid input", "Width and height must be positive integers");
        }

        int cubeBlocks = width * width * height;
        // the surrounding of the bottom
        int framesTopBottom = 4 * (width-1);
        int framesSide = 4 * (height-2);
        int framesTotal = framesTopBottom * 2 + framesSide;
        frames.setText(String.valueOf(framesTotal));

        int ventsTopBottom = (width-2) * (width-2);
        int ventsSide = ((height-2) * (width-2)) * 4;
        int ventsTotal = (ventsTopBottom * 2) + ventsSide;
        vents.setText(String.valueOf(ventsTotal));

        int centerCube = cubeBlocks - (framesTotal + ventsTotal);

        // Fill centerCube with patternProvider and coProcessors in a 2:1 ratio
        int patternProviderCount = centerCube * 2 / 3;
        int coProcessorsCount = centerCube - patternProviderCount;

        patternProvider.setText(String.valueOf(patternProviderCount));
        coProzessor.setText(String.valueOf(coProcessorsCount));

        // Fill centerCube with patternProvider and coProcessors in a 7:2 ratio
        int patternProviderCountTwo = centerCube * 7 / 9;
        int coProcessorsCountTwo = centerCube - patternProviderCountTwo;

        patternProviderTwo.setText(String.valueOf(patternProviderCountTwo));
        coProzessorTwo.setText(String.valueOf(coProcessorsCountTwo));
    }
}
