import UIKit
import app

class ViewController: UIViewController, CalculatorView {
    
    func showState(state: CalculatorState) {
        let formatter = NumberFormatter()
        formatter.minimumFractionDigits = 0
        formatter.numberStyle = .decimal
        
        label.text = formatter.string(from: state.currentNumber as NSNumber)
    }

    var presenter: CalculatorPresenter!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter = CalculatorPresenter(view: self)
        label.text = ""
        bottomLabel.text = Common().getHelloMessage()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
        func setCalculatorText(text: String){
        label.text = text
    }
    
    @IBAction func button7(_ sender: Any) {
        presenter.onNumberPressed(number: 7)
    }
    
    @IBAction func button8(_ sender: Any) {
        presenter.onNumberPressed(number: 8)
    }
    
    @IBAction func button9(_ sender: Any) {
        presenter.onNumberPressed(number: 9)
    }
    
    @IBAction func button4(_ sender: Any) {
        presenter.onNumberPressed(number: 4)
    }
    
    @IBAction func button5(_ sender: Any) {
        presenter.onNumberPressed(number: 5)
    }
    
    @IBAction func button6(_ sender: Any) {
        presenter.onNumberPressed(number: 6)
    }
    
    @IBAction func button1(_ sender: Any) {
        presenter.onNumberPressed(number: 1)
    }
    
    @IBAction func button2(_ sender: Any) {
        presenter.onNumberPressed(number: 2)
    }
    
    @IBAction func button3(_ sender: Any) {
        presenter.onNumberPressed(number: 3)
    }
    
    
    @IBAction func button0(_ sender: Any) {
        presenter.onNumberPressed(number: 0)
    }
    
    
    @IBAction func buttoncomma(_ sender: Any) {
    }
    
    
    @IBAction func buttonC(_ sender: Any) {
        presenter.onOperation(op: Clear())
    }
    
    
    @IBAction func buttonPlus(_ sender: Any) {
        presenter.onOperation(op: Sum())
    }
    
    
    @IBAction func buttonMinus(_ sender: Any) {
        presenter.onOperation(op: Substract())
    }
    
    @IBAction func buttonEquals(_ sender: Any) {
        presenter.onOperation(op: Equal())
    }
    
    @IBOutlet weak var bottomLabel: UILabel!
}
