package calculator

class CalculatorPresenter<T>(private val view: T) where T : CalculatorView {
    private var state = InitialState()
    fun onNumberPressed(number: Double) {
        state.currentNumber = state.currentNumber * 10 + number
        view.showState(state)
    }

    fun onOperation(op: Operation) {

    }
}