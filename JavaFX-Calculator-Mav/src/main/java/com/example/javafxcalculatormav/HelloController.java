package com.example.javafxcalculatormav;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField display;

    private double num1 = 0;
    private String operator = "";
    private boolean startNewInput = true;

    public void handleButtonClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        if (startNewInput) {
            display.clear();
            startNewInput = false;
        }

        display.appendText(buttonText);
    }

    public void handleOperation(ActionEvent event) {
        Button button = (Button) event.getSource();
        String currentOperator = button.getText();

        if (!operator.isEmpty()) {
            return;
        }

        num1 = Double.parseDouble(display.getText());
        operator = currentOperator;
        startNewInput = true;
    }


    public void handleEquals() {
        if (operator.isEmpty()) {
            return;
        }

        double num2 = Double.parseDouble(display.getText());
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    display.setText("Error");
                }
                break;
        }

        display.setText(String.valueOf(result));
        operator = "";
        startNewInput = true;
    }

    public void handleClear() {
        display.clear();
        operator = "";
        startNewInput = true;
    }
}
