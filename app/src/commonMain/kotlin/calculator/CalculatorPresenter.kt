package calculator

class CalculatorPresenter(private val view: CalculatorView) {
    private var state = InitialState()
    fun onNumberPressed(number: Double) {
        state.currentNumber = state.currentNumber * 10 + number
        view.showState(state)
    }

    fun onOperation(op: Operation) {

    }
}