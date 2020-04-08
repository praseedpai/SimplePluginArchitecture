import java.lang.*;
import java.util.*;

class PluginManager
{
	Map<String,String> plugins =
	new HashMap<String,String>(); 

	Map<String,Object> cached = new
		HashMap<String,Object>();

	private BinaryOperation GetInterface(String handler) 
	{
		System.out.println("GetInterface " + handler);
		BinaryOperation result = (BinaryOperation)cached.get(handler);
		if ( result != null ) return result;
		Object b = null;

		try {
		System.out.println("GetInterface " + handler);

		Class c = Class.forName(handler);

		if ( c == null )
			return null;

		b = c.newInstance();
		if ( b == null )
			return null;

		}
		catch( Exception e) { return null; }

		BinaryOperation ret = (BinaryOperation)b;
		cached.put(handler,ret);

		return ret;

	}

	private boolean ExecuteViaHandler( String handler,EXECUTION_CONTEXT e)
	{
		BinaryOperation b = (BinaryOperation)GetInterface(handler);

		if ( b == null) return false;


		if ( b.PreExecute(e))
		{
			b.Execute(e);
			b.PostExecute(e);
			return true;
		}
		
		return false;


	}


	public PluginManager(String conffile) { LoadPlugins(conffile);}

	public boolean LoadPlugins(String conffile) {

		plugins = 
		ConfigParser.CollectPluggins(conffile);

		if ( plugins == null )
			return false;
		return true;
		
	}

	String GetHandler(String oper) {
		String Handler = (String)plugins.get(oper);

		if ( Handler != null )
			System.out.println(Handler);
		return Handler;
		
 	}

	public boolean Execute( EXECUTION_CONTEXT e) {
                MATH_OPER computation = (MATH_OPER)e.Get("input");

		if ( computation == null ){
			System.out.println("Cannot Found Input Object");
 			return false;
		}
		String handler = GetHandler(computation.oper);
		if ( handler == null )
		{
			System.out.println("Cannot Find Operation");
			return false;
		}
		return ExecuteViaHandler(handler,e);

	}


}