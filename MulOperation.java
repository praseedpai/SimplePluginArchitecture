
import java.lang.*;


class MulOperation implements BinaryOperation
{
	public boolean PreExecute( EXECUTION_CONTEXT e)
	{
		System.out.println("PreExecute of Mul");
		return true;

	}
	public boolean Execute( EXECUTION_CONTEXT e) {
		System.out.println("Execute of Mul");
		return true;

	}
	public boolean PostExecute( EXECUTION_CONTEXT e){
		System.out.println("PostExecute of Mul");
		return true;
	}

}