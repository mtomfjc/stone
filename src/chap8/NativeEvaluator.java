package chap8;
import java.util.List;
import stone.StoneException;
import stone.ast.ASTree;
import javassist.gluonj.*;
import chap6.Environment;
import chap6.BasicEvaluator.ASTreeEx;
import chap7.FuncEvaluator;

@Require(FuncEvaluator.class)
@Reviser public class NativeEvaluator {

	@Reviser public static class NativeArgEx extends FuncEvaluator.ArgumentsEx{
		public NativeArgEx(List<ASTree> list){
			super(list);
		}
		
		@Override
		public Object eval(Environment callerEnv, Object value){
			if(!(value instanceof NativeFunction)){
				return super.eval(callerEnv, value);
			}
			NativeFunction func = (NativeFunction) value;
			int nParams = func.numOfParameters();
			if(size() != nParams){
				throw new StoneException("bad number of argument", this);
			}
			Object[] args = new Object[nParams];
			int num = 0;
			for(ASTree a : this){
				ASTreeEx ae = (ASTreeEx)a;
				args[num++] = ae.eval(callerEnv);
			}
			return func.invoke(args, this);
		}
	}

}
