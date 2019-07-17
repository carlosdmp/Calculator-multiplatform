package calculator

class CalculatorPresenter(private val view: CalculatorView) {

    private var state: CalculatorState = InitialState()

    fun onNumberPressed(number: Double) {
        if(state.currentIsResult){
            state.currentNumber = 0.0
        }
        state.currentNumber = state.currentNumber * 10 + number
        state.currentIsResult = false
        view.showState(state)
    }

    fun onOperation(op: Operation) {
        state = op.execute(state)
        view.showState(state)
    }
}