package chap7;
import javassist.gluonj.*;
import java.util.List;
import stone.ast.*;
import chap6.Environment;

@Require(FuncEvaluator.class)
@Reviser public class ClosureEvaluator {
	@Reviser public static class FunEx extends Fun{
		public FunEx(List<ASTree> list){
			super(list);
		}
			
		public Object eval(Environment env){
			return new Function(parameters(), body(), env);
		}
	}
}
