import java.lang.*;


class AddOperation implements BinaryOperation
{
	public boolean PreExecute( EXECUTION_CONTEXT e)
	{
		System.out.println("PreExecute of Add");
		return true;

	}
	public boolean Execute( EXECUTION_CONTEXT e) {
		System.out.println("Execute of Add");
		return true;

	}
	public boolean PostExecute( EXECUTION_CONTEXT e){
		System.out.println("PostExecute of Add");
		return true;
	}

}