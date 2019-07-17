package calculator

sealed class CalculatorState(var currentNumber: Double, var currentIsResult : Boolean = false)

class InitialState(current: Double = 0.0) : CalculatorState(current)

class OperationState(val prevNumber: Double, val operation: Operation, current: Double, isResult: Boolean = true) : CalculatorState(current,isResult)
