package at.ftmahringer.lazyae2macalc;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class NewCalcCont {

    public TextField width;
    public TextField height;
    public TextField vents;
    public TextField frames;
    public TextField patternProvider;
    public TextField coProzessor;
    public TextField patternProviderTwo;
    public TextField coProzessorTwo;

    public TextField customPercent;
    public TextField customPatterProvider;
    public TextField customCoProzessor;


    private static final int MIN_WIDTH_HEIGHT = 0;
    private static final int MAX_CUSTOM_PERCENT = 100;

    public void calculate(ActionEvent actionEvent) {
        int width = getValidatedWidth();
        int height = getValidatedHeight();

        int cubeBlocks = calculateCubeBlocks(width, height);
        int framesTotal = calculateFramesTotal(width, height);
        int ventsTotal = calculateVentsTotal(width, height);
        int centerCube = calculateCenterCube(cubeBlocks, framesTotal, ventsTotal);

        int patternProviderCount = calculatePatternProviderCount(centerCube, 2, 3);
        int coProcessorsCount = calculateCoProcessorsCount(centerCube, patternProviderCount);

        patternProvider.setText(String.valueOf(patternProviderCount));
        coProzessor.setText(String.valueOf(coProcessorsCount));

        vents.setText(String.valueOf(ventsTotal));
        frames.setText(String.valueOf(framesTotal));

        // Fill centerCube with patternProvider and coProcessors in a 7:2 ratio
        int patternProviderCountTwo = calculatePatternProviderCount(centerCube, 7, 9);
        int coProcessorsCountTwo = calculateCoProcessorsCount(centerCube, patternProviderCountTwo);

        patternProviderTwo.setText(String.valueOf(patternProviderCountTwo));
        coProzessorTwo.setText(String.valueOf(coProcessorsCountTwo));
    }

    public void calcCustom(ActionEvent actionEvent) {
        int customPercent = getValidatedCustomPercent();
        int width = getValidatedWidth();
        int height = getValidatedHeight();

        int cubeBlocks = calculateCubeBlocks(width, height);
        int framesTotal = calculateFramesTotal(width, height);
        int ventsTotal = calculateVentsTotal(width, height);
        int centerCube = calculateCenterCube(cubeBlocks, framesTotal, ventsTotal);

        int patternProviderCount = calculatePatternProviderCount(centerCube, customPercent, 100);
        int coProcessorsCount = calculateCoProcessorsCount(centerCube, patternProviderCount);

        customPatterProvider.setText(String.valueOf(patternProviderCount));
        customCoProzessor.setText(String.valueOf(coProcessorsCount));
    }

    private int getValidatedWidth() {
        int width = Integer.parseInt(this.width.getText());
        if (width < MIN_WIDTH_HEIGHT) {
            AlertsManager.errorAlert("Error", "Invalid input", "Width must be a positive integer");
        }
        return width;
    }

    private int getValidatedHeight() {
        int height = Integer.parseInt(this.height.getText());
        if (height < MIN_WIDTH_HEIGHT) {
            AlertsManager.errorAlert("Error", "Invalid input", "Height must be a positive integer");
        }
        return height;
    }

    private int getValidatedCustomPercent() {
        int customPercent = Integer.parseInt(this.customPercent.getText());
        if (customPercent < 0 || customPercent > MAX_CUSTOM_PERCENT) {
            AlertsManager.errorAlert("Error", "Invalid input", "Custom percentage must be between 0 and 100");
        }
        return customPercent;
    }

    private int calculateCubeBlocks(int width, int height) {
        return width * width * height;
    }

    private int calculateFramesTotal(int width, int height) {
        int framesTopBottom = 4 * (width - 1);
        int framesSide = 4 * (height - 2);
        return framesTopBottom * 2 + framesSide;
    }

    private int calculateVentsTotal(int width, int height) {
        int ventsTopBottom = (width - 2) * (width - 2);
        int ventsSide = ((height - 2) * (width - 2)) * 4;
        return (ventsTopBottom * 2) + ventsSide;
    }

    private int calculateCenterCube(int cubeBlocks, int framesTotal, int ventsTotal) {
        return cubeBlocks - (framesTotal + ventsTotal);
    }

    private int calculatePatternProviderCount(int centerCube, int numerator, int denominator) {
        return centerCube * numerator / denominator;
    }

    private int calculateCoProcessorsCount(int centerCube, int patternProviderCount) {
        return centerCube - patternProviderCount;
    }
}
