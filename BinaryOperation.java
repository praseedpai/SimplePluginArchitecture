import java.lang.*;
///////////////////////////////
// An Interface for Binary Operation
// follows "Desgin By Contract" Idiom
//
//
interface BinaryOperation
{
	boolean PreExecute( EXECUTION_CONTEXT e);
	boolean Execute( EXECUTION_CONTEXT e);
	boolean PostExecute( EXECUTION_CONTEXT e);
}