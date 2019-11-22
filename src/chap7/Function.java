package chap7;
import stone.ast.BlockStmnt;
import stone.ast.ParameterList;
import chap6.Environment;

public class Function {
	protected ParameterList parameterList;
	protected BlockStmnt body;
	protected Environment env;
	
	public Function(ParameterList parameterList, BlockStmnt body, Environment env) {
		this.parameterList = parameterList;
		this.body = body;
		this.env = env; 
	}
	
	public ParameterList parameters(){
		return this.parameterList;
	}
	
	public BlockStmnt body(){
		return this.body;
	}

	public Environment makeEnv(){
		return new NestedEnv(this.env);
	}
	
	@Override
	public String toString(){
		return "<fun:" + hashCode() + ">";
	}
}
