package com.example.geekbrainsapplicationship;

public class Calculator {

    private String num1 = new String("0");
    private String num2 = new String("0");
    private String num;
    private String operator;
    private boolean hasntDot = true;
    private boolean hasOperation = false;
    private MainActivity main;


    protected Calculator() {
        if (hasOperation)
            num = "num2";
        else
            num = num1;
    }

    public String getNum() {
        return num;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    protected void setField(String symbol) {
            num = addSymbol(num, symbol);
    }

    private String addSymbol(String num, String symbol) {
        if (num.equals("0"))
            num = symbol;
        else
            num = num + symbol;
        return num;
    }

    public void setDot() {
        if (hasntDot){
            num = num + '.';
            hasntDot = false;
        }
    }

    public void reverseOverZero() {
        if (num.charAt(0) == '-')
            num = num.substring(1);
        else
            num = '-' + num;
    }

    public void clear() {
        num = "0";
        num1 = "0";
        num2 = "0";
        hasntDot = true;
        hasOperation = false;
    }


    public void operation(String operator) {
        if (hasOperation){
            String newOperator = operator;
            result();
            hasOperation = false;
            operation(newOperator);
        }
        else
            {setOperator(operator);
            num1 = num;
            num2 = "0";
            num = "0";
            hasntDot = true;
            hasOperation = true;}
    }

    public void result(){
        if (hasOperation) {
            num2 = num;
            double operand1 = Double.parseDouble(String.valueOf(num1));
            double operand2 = Double.parseDouble(String.valueOf(num2));
            double sum = 0.0;


            switch (operator) {
                case "+":
                    sum = operand1 + operand2;
                    break;
                case "-":
                    sum = operand1 - operand2;
                    break;
                case "*":
                    sum = operand1 * operand2;
                    break;
                case "/":
                    sum = operand1 / operand2;
                    break;
                default:
                    break;
            }

            num1 = "" + sum;
            num = num1;
            num2 = "0";
            hasntDot = false;
            hasOperation = false;
        }
    }
}
