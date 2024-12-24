public class CalculatorLogic {
    private UI ui;
    private double currentResult = 0;
    private String currentOperator = "";
    private boolean isNewInput = true;

    public CalculatorLogic(UI ui) {
        this.ui = ui;
    }

    public void handleButtonPress(String buttonText) {
        if ("0123456789.".contains(buttonText)) {
            if (isNewInput) {
                ui.updateDisplay(buttonText);
                isNewInput = false;
            } else {
                ui.updateDisplay(ui.getDisplayText() + buttonText);
            }
        } else if ("/*-+".contains(buttonText)) {
            performOperation(buttonText);
        } else if (buttonText.equals("=")) {
            calculateResult();
        } else if (buttonText.equals("√")) {
            calculateSquareRoot();
        } else if (buttonText.equals("^2")) {
            calculateSquare();
        } else if (buttonText.equals("M")) {
            saveToMemory();
        }
    }

    private void performOperation(String operator) {
        double displayedNumber = Double.parseDouble(ui.getDisplayText());

        if (!currentOperator.isEmpty()) {
            switch (currentOperator) {
                case "+":
                    currentResult += displayedNumber;
                    break;
                case "-":
                    currentResult -= displayedNumber;
                    break;
                case "*":
                    currentResult *= displayedNumber;
                    break;
                case "/":
                    if (displayedNumber != 0) {
                        currentResult /= displayedNumber;
                    } else {
                        ui.updateDisplay("Error");
                        resetState();
                        return;
                    }
                    break;
            }
        } else {
            currentResult = displayedNumber;
        }

        currentOperator = operator;
        ui.updateDisplay(String.valueOf(currentResult));
        isNewInput = true;
    }

    private void calculateResult() {
        if (!currentOperator.isEmpty()) {
            double displayedNumber = Double.parseDouble(ui.getDisplayText());
            performOperation(currentOperator);
            currentOperator = "";
            ui.updateDisplay(String.valueOf(currentResult));
            isNewInput = true;
        }
    }

    private void calculateSquareRoot() {
        try {
            double displayedNumber = Double.parseDouble(ui.getDisplayText());
            if (displayedNumber >= 0) {
                double result = Math.sqrt(displayedNumber);
                ui.updateDisplay(String.valueOf(result));
            } else {
                ui.updateDisplay("Error");
            }
            isNewInput = true;
        } catch (NumberFormatException e) {
            ui.updateDisplay("Error");
        }
    }

    private void calculateSquare() {
        try {
            double displayedNumber = Double.parseDouble(ui.getDisplayText());
            double result = displayedNumber * displayedNumber;
            ui.updateDisplay(String.valueOf(result));
            isNewInput = true;
        } catch (NumberFormatException e) {
            ui.updateDisplay("Error");
        }
    }

    private void saveToMemory() {
        try {
            double displayedNumber = Double.parseDouble(ui.getDisplayText());
            currentResult = displayedNumber;
            ui.updateDisplay("Saved: " + displayedNumber);
            isNewInput = true;
        } catch (NumberFormatException e) {
            ui.updateDisplay("Error");
        }
    }

    private void resetState() {
        currentResult = 0;
        currentOperator = "";
        isNewInput = true;
    }
}
