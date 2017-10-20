package model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.EnhancedForStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.WhileStatement;

public class StatementExpander {

	public static List<Statement> expand(List<Statement> statements) {
		List<Statement> list = new ArrayList<>();

		for(Statement st: statements) {
			list.add(st);

			if(st.getClass() == IfStatement.class) {
				IfStatement s = (IfStatement) st;
				list.addAll(expand(s.getThenStatement()));
				if(s.getElseStatement() != null) {
					list.addAll(expand(s.getElseStatement()));
				}

			} else if (st.getClass() == WhileStatement.class) {
				WhileStatement s = (WhileStatement) st;
				list.addAll(expand(s.getBody()));

			} else if (st.getClass() == ForStatement.class) {
				ForStatement s = (ForStatement) st;
				list.addAll(expand(s.getBody()));

			} else if (st.getClass() == EnhancedForStatement.class) {
				EnhancedForStatement s = (EnhancedForStatement) st;
				list.addAll(expand(s.getBody()));
			}
		}

		return list;
	}

	public static List<Statement> expand(Statement st) {
		List<Statement> list = new ArrayList<>();

		if (st.getClass() == Block.class) {
			Block b = (Block) st;
			list.addAll(expand(b.statements()));
		}

		return list;
	}
}
