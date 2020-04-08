
import java.lang.*;


class DivOperation implements BinaryOperation
{
	public boolean PreExecute( EXECUTION_CONTEXT e)
	{
		System.out.println("PreExecute of Div");
		return true;

	}
	public boolean Execute( EXECUTION_CONTEXT e) {
		System.out.println("Execute of Div");
		return true;

	}
	public boolean PostExecute( EXECUTION_CONTEXT e){
		System.out.println("PostExecute of Div");
		return true;
	}

}