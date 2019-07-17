package calculator

sealed class CalculatorState(var currentNumber: Double)

class InitialState(current: Double = 0.0) : CalculatorState(current)

class OperationState(val prevNumber: Double, val operation: Operation, current: Double) : CalculatorState(current)
