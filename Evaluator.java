import java.lang.*;

/////////////////////////
//
// java Evaluator <Number> <Number> <Oper>
//           where
//
// <Oper> := "ADD" | "SUB" | "DIV" | "MUL"
//
//
//

public class Evaluator
{

	public static void main( String [] args) {
		if ( args.length == 0 )
                    System.out.println("Hello World...");

                int num = args.length;

		if ( num == 3 ) {
			int a = Integer.parseInt(args[0]);
                        int b = Integer.parseInt(args[1]);
                        String oper = args[2];
			MATH_OPER opera = new MATH_OPER();
			opera.a = a;
                        opera.b = b;
                        opera.oper = oper;
                        EXECUTION_CONTEXT s = new EXECUTION_CONTEXT();
			s.Put("input",opera);
			PluginManager pm = new PluginManager("plugins.xml");
			pm.Execute(s);


			System.out.println("# of command line arguments " + a + " " + b + " " + oper);

		}

               
        }

}