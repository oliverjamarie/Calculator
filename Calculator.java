

public class Calculator implements State{
	private State firstOperator = new RFO();
	private State secondOperator = new RSO();
	private State error = new ERR();
	private State currentState = firstOperator;
	private double result = 0.0;
	private double num = 0.0;
	private OperationType currentOp = OperationType.NONE;


	public double getNum () {
		return currentState.getNum();
	}

	public OperationType getOperator () {
		return currentState.getOperator();
	}

	public void setOperation (OperationType input) {
		currentState.setOperation(input);
	}

	public void setNum (double input) {
		currentState.setNum(input);
	}

	public void calculate () {
		currentState.calculate();
	}
	@Override
	public double getResult() {
		return currentState.getResult();
	}

	public void clear () {
		num = 0;
	}
	
	public void clearEverything() {
		num = 0;
		result = 0 ;
		currentOp = OperationType.NONE;
	}


	private class RFO implements State {

		@Override
		public double getNum() {
			return num;
		}

		@Override
		public void setOperation(OperationType input) {
			currentOp = input;
		}

		@Override
		public OperationType getOperator() {
			return currentOp;
		}

		@Override
		public void setNum(double input) {
			num = input*1.0;
			currentState = secondOperator;
		}

		@Override
		public void calculate() {
			if (currentOp != OperationType.NONE) {
				result = num;
			} 
		}

		@Override
		public double getResult() {
			return result;
		}

		@Override
		public void clear() {
			num = 0;
		}

		@Override
		public void clearEverything() {
			num = 0;
			result = 0 ;
			currentOp = OperationType.NONE;
		}
	
	}
	

	private class RSO implements State {

		@Override
		public double getNum() {
			return num;
		}

		@Override
		public void setNum(double input) {
			num = input * 1.0;
		}

		@Override
		public void setOperation(OperationType input) {
			currentOp = input;
		}

		@Override
		public OperationType getOperator() {
			return currentOp;
		}

		@Override
		public void calculate() {
			switch (currentOp) {
			case NONE:
				System.out.println("None");
			case ADDITION:
				result += num;
			case SUBTRACTION:
				result -= num;
			case MULTIPLICATION:
				result *= num;
			case DIVISION:
				if (num < 0.00001) {
					result /= num;
				} else {
					System.out.println("Error");
					currentState = error;
				}
			default :
				result = 0;
			}
		}

		@Override
		public double getResult() {
			return result;
		}

		@Override
		public void clear() {
			num = 0;
		}
		
		@Override
		public void clearEverything() {
			num = 0;
			result = 0 ;
			currentOp = OperationType.NONE;
		}

	}

	private class ERR implements State {

		@Override
		public double getNum() {
			return 0;
		}

		@Override
		public void setNum(double input) {
		}

		@Override
		public void setOperation(OperationType input) {
		}

		@Override
		public OperationType getOperator() {
			return OperationType.NONE;
		}

		@Override
		public void calculate() {
		}
		
		@Override
		public double getResult() {
			return 0.0;
		}

		@Override
		public void clear() {
			num = 0;
		}
		
		@Override
		public void clearEverything() {
			num = 0;
			result = 0 ;
			currentOp = OperationType.NONE;
		}
		
	}

	
}
