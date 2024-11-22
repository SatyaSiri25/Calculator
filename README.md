# Readme for Calculator.
Calculator is a class supports basic of Operators like ADD, SUBTRACT, MULTIPY, DIVIDE. 
It also support chain computation. It is easily extensible.

# Run Calculator class:
Calculator class has `main` function, any chain calculation can be calculated there.

# Adding new Operator.
"Operator" Enum class as directed in the question, it contains all supported operators. 
To add a new operator, couple of things has to performed.
1) Define new operator in "Operator" enum.
2) Define new class which implements "Operation" interface.
3) Update Calculator's "symbolMap" with Operator -> Operation mapping.
There is no need change "calculate" method, as directed in the question.

Note: Without "Operator" enum dependency, "Calculator" class can be further simplified to add new operator.
