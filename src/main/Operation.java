package main;

/**
 * This interface will be implemented by all operators.
 */
public interface Operation {
  /**
   * This function will perform the actual calculation with necessary validation checks.
   * @param inputNum1 first operand
   * @param inputNum2 second operand
   * @return result of the operation.
   */
  public double operate(double inputNum1, double inputNum2);
}
