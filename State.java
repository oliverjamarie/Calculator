enum OperationType {
	ADDITION,
	SUBTRACTION,
	MULTIPLICATION,
	DIVISION,
	NONE
}

public interface State {
	public void setNum(double input);
	public double getNum ();
	public void setOperation (OperationType input);
	public OperationType getOperator();
	public void calculate ();
	public double getResult ();
	public void clear();
	public void clearEverything ();
}
