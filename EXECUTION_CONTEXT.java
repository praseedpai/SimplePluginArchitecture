import java.lang.*;
import java.util.*;


class EXECUTION_CONTEXT
{
	Map<String,Object> bag =
	new HashMap<String,Object>();

	public EXECUTION_CONTEXT() {}

	public Object Get(String str){
		return bag.get(str);
	}

	public void Put(String str,Object b)
	{
		bag.put(str,b);
	}

}