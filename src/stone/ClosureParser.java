package stone;
import static stone.Parser.rule;
import stone.ast.Fun;

public class ClosureParser extends FuncParser {

	public ClosureParser() {
		reserved.add("fun");
		primary.insertChoice(rule(Fun.class).sep("fun").ast(paramList).ast(block));
	}
}
