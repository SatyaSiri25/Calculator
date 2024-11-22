package test;

import main.Calculator;
import main.Operator;


public class TestCalculator {
  public static void  main(String[] args) {
    TestCalculator test = new TestCalculator();
    test.testAddition();
    test.testSubtraction();
    test.testMultiplication();
    test.testDivide();
    test.testDivideWithIllegalArgument();
    test.testChainOperation();
    test.testUnsupportedOperator();
  }
  private void testAddition(){
    Calculator calculator = new Calculator();
    double result = calculator.initialize(10).calculate(Operator.ADD, 5).getResult();
    assertResult("Addition", 15.0, result);
  }

  private void testSubtraction(){
    Calculator calculator = new Calculator();
    double result = calculator.initialize(10).calculate(Operator.SUBTRACT, 5).getResult();
    assertResult("Subtract", 5.0, result);
  }

  private void testMultiplication(){
    Calculator calculator = new Calculator();
    double result = calculator.initialize(10).calculate(Operator.MULTIPY, 5).getResult();
    assertResult("Multipy", 50.0, result);
  }

  private void testDivide(){
    Calculator calculator = new Calculator();
    double result = calculator.initialize(10).calculate(Operator.DIVIDE, 5).getResult();
    assertResult("Divide", 2.0, result);
  }

  private void testDivideWithIllegalArgument(){
    Calculator calculator = new Calculator();
    try {
      double result = calculator.initialize(10).calculate(Operator.DIVIDE, 0).getResult();
      System.out.println("Divide with Zero FAILED, ExpectedValue: ArithmeticException ActualValue: " + result);
    } catch (ArithmeticException ex) {
      System.out.println("Divide with Zero Operation verified successfully");
    } catch (Exception ex) {
      System.out.println("Divide with Zero FAILED, ExpectedValue: ArithmeticException ActualValue: " + ex.getClass());
    }
  }
  private void testChainOperation(){
    Calculator calculator = new Calculator();
    double result = calculator.initialize(10)
        .calculate(Operator.ADD, 20)
        .calculate(Operator.SUBTRACT, 10)
        .calculate(Operator.MULTIPY, 20)
        .calculate(Operator.DIVIDE, 10)
        .getResult();
    assertResult("Chain Operation", 40.0, result);
  }

  private void testUnsupportedOperator(){
    Calculator calculator = new Calculator();
    try {
      double result = calculator.initialize(10)
          .calculate(Operator.ADD, 20)
          .calculate(Operator.SUBTRACT, 10)
          .calculate(Operator.MULTIPY, 20)
          .calculate(Operator.DIVIDE, 10)
          .calculate(null, 10)
          .getResult();
      System.out.println("Calculation with Invalid Operator FAILED, ExpectedValue: IllegalArgumentException ActualValue: " + result);
    } catch (IllegalArgumentException ex) {
      System.out.println("Calculation with Invalid Operator verified successfully");
    } catch (Exception ex) {
      System.out.println("Calculation with Invalid Operator FAILED, ExpectedValue: UnsupportedOperationException ActualValue: " + ex.getClass());
    }
  }
  private void assertResult(String testCaseName, double expectedValue, double actualValue) {
    if (expectedValue == actualValue) {
      System.out.println(testCaseName + " PASS");
    } else {
      System.out.println(testCaseName + " FAIL" + " ExpectedValue: " + expectedValue + " ActualValue: " + actualValue);
    }
  }
}
