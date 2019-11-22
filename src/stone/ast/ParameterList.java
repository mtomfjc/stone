package stone.ast;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ParameterList extends ASTList {

	public ParameterList(List<ASTree> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	public String name(int i){
		return ((ASTLeaf)child(i)).token().getText();
	}
	
	public int size(){
		return numChildren();
	}

}
