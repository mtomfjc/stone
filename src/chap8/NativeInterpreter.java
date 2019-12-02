package chap8;
import stone.ClosureParser;
import stone.ParseException;
import chap7.NestedEnv;
import chap6.BasicInterpreter;

public class NativeInterpreter extends BasicInterpreter {

	public static void main(String[] args) throws ParseException{
		run(new ClosureParser(), new Natives().environment(new NestedEnv()));
	}
}
