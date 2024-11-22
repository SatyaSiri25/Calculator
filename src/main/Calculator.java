package main;

import java.util.HashMap;
import java.util.Map;

class Addition implements Operation {
  @Override
  public double operate(double inputNum1, double inputNum2) {
    return inputNum1 + inputNum2;
  }
}

class Subtract implements Operation {
  @Override
  public double operate(double inputNum1, double inputNum2) {
    return inputNum1 - inputNum2;
  }
}

class Multipy implements Operation {
  @Override
  public double operate(double inputNum1, double inputNum2) {
    return inputNum1 * inputNum2;
  }
}

class Divide implements Operation {
  @Override
  public double operate(double inputNum1, double inputNum2) {
    if(inputNum2 == 0)
    {
      throw new ArithmeticException("Cannot divide by Zero");
    }
    return inputNum1 / inputNum2;
  }
}


public class Calculator {
  double finalResult;
  Map<Operator, Operation> symbolMap = new HashMap<>();

  public Calculator() {
    symbolMap.put(Operator.ADD, new Addition());
    symbolMap.put(Operator.SUBTRACT, new Subtract());
    symbolMap.put(Operator.MULTIPY, new Multipy());
    symbolMap.put(Operator.DIVIDE, new Divide());
  }
  /**
   * This function will initialize the calculator with given number.
   * @param initValue The value to initialize the calculator.
   * @return Calculator instance
   */
  public Calculator initialize(double initValue) {
    finalResult = initValue;
    return this;
  }
  /**
   * This function perform the calculation based on the operator and given inputs It throws specific exceptions based on
   * validation.
   * @param op         Operator to peform on given numbers.
   * @param inputNumber second operand
   * @return Calculator instance.
   */
  public Calculator calculate(Operator op, double inputNumber) {
    if (op == null) {
      throw new IllegalArgumentException("Invalid Operator: " + op);
    }
    Operation operation = symbolMap.get(op);
    if(operation == null) {
      throw new UnsupportedOperationException("Unsupported Operator: " + op);
    }
    finalResult = operation.operate(finalResult, inputNumber);
    return this;
  }
  /**
   * Get the final Result after all calculations.
   * @return final value after all calculations.
   */
  public double getResult(){
    return finalResult;
  }

  /**
   * Add new Operator and corresponding Operation Function
   */
  public void addOperator(Operator op, Operation operation) {
    symbolMap.put(op, operation);
  }

  public  static void main(String[] args) {
    Calculator calculator = new Calculator();
    double result = calculator.initialize(10)
        .calculate(Operator.ADD, 20)
        .calculate(Operator.SUBTRACT, 10)
        .calculate(Operator.MULTIPY, 20)
        .calculate(Operator.DIVIDE, 10)
        .getResult();
    System.out.println("Result is: " + result);
  }
}
