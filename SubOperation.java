import java.lang.*;


class SubOperation implements BinaryOperation
{
	public boolean PreExecute( EXECUTION_CONTEXT e)
	{
		System.out.println("PreExecute of Sub");
		return true;

	}
	public boolean Execute( EXECUTION_CONTEXT e) {
		System.out.println("Execute of Sub");
		return true;

	}
	public boolean PostExecute( EXECUTION_CONTEXT e){
		System.out.println("PostExecute of Sub");
		return true;
	}

}