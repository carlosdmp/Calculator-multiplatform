package calculator

sealed class Operation {
    abstract fun execute(state: CalculatorState): CalculatorState
    abstract fun getNewCurrent(state: CalculatorState): Double
}

object Sum : Operation() {

    override fun getNewCurrent(state: CalculatorState) = when (state) {
        is InitialState -> 0.0
        is OperationState -> state.prevNumber + state.currentNumber
    }

    override fun execute(state: CalculatorState): CalculatorState = when (state) {
        is InitialState -> OperationState(
            prevNumber = state.currentNumber,
            operation = Sum,
            current = 0.0
        )
        is OperationState ->
            OperationState(
                prevNumber = state.prevNumber + state.currentNumber,
                operation = Sum,
                current = 0.0
            )
    }

}

object Substract : Operation() {
    override fun getNewCurrent(state: CalculatorState) = when (state) {
        is InitialState -> 0.0
        is OperationState -> state.prevNumber - state.currentNumber
    }

    override fun execute(state: CalculatorState): CalculatorState = when (state) {
        is InitialState -> OperationState(
            prevNumber = state.currentNumber,
            operation = Sum,
            current = 0.0
        )
        is OperationState ->
            OperationState(
                prevNumber = state.prevNumber - state.currentNumber,
                operation = Sum,
                current = 0.0
            )
    }
}