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
                prevNumber = state.operation.getNewCurrent(state),
                operation = Sum,
                current = state.operation.getNewCurrent(state)
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
            operation = Substract,
            current = 0.0
        )
        is OperationState ->
            OperationState(
                prevNumber = state.operation.getNewCurrent(state),
                operation = Sum,
                current = state.operation.getNewCurrent(state)
            )
    }
}

object Equal : Operation() {
    override fun getNewCurrent(state: CalculatorState) = state.currentNumber

    override fun execute(state: CalculatorState): CalculatorState = when (state) {
        is InitialState -> OperationState(
            prevNumber = state.currentNumber,
            operation = Equal,
            current = 0.0
        )
        is OperationState ->
            OperationState(
                prevNumber = 0.0,
                operation = Equal,
                current = state.operation.getNewCurrent(state)
            )
    }
}

object Clear : Operation() {
    override fun getNewCurrent(state: CalculatorState) = 0.0

    override fun execute(state: CalculatorState): CalculatorState = InitialState()
}