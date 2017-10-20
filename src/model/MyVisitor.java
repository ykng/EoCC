package model;

import java.util.List;

import org.eclipse.jdt.core.dom.*;

public class MyVisitor extends ASTVisitor{

	int methodCounter = 0;
	Characteristics c = new Characteristics();
//	Characteristics cmap = new Characteristics();
//	Characteristics cred = new Characteristics();
//	Status status = Status.OTHER;

/*
	public void countUp(String param) {
		switch(status) {
			case MAP :
				cmap.countUp(param);
				break;
			case REDUCE :
				cred.countUp(param);
				break;
			case OTHER:
				break;
		}
	}
*/

	public String out(){
		// return cmap.out() + cred.out();
		return c.out();
	}

	@Override
	public boolean visit(MethodDeclaration node) {
/*
		if (node.getName().getIdentifier().equals("map")) {
			status = Status.MAP;
		} else if (node.getName().getIdentifier().equals("reduce")) {
			status = Status.REDUCE;
		} else {
			status = Status.OTHER;
		}
*/
		int nos = 0;
		if(node.getBody() != null) {
			List<Statement> statements = node.getBody().statements();
			nos = StatementExpander.expand(statements).size();
		}
		System.out.println("Method " + String.valueOf(methodCounter++) + " : " + String.valueOf(nos) + " sentences.");

		for(int i=0; i<nos; i++){ c.countUp("nos"); }

		return super.visit(node);
	}

	@Override
	public boolean visit(FieldDeclaration node) {
		c.countUp("field");
		return super.visit(node);
	}

	@Override
	public boolean visit(StringLiteral node) {
		c.countUp("str");
		return super.visit(node);
	}

	@Override
	// このままだと同時に宣言したものはまとめて1としてカウント
	public boolean visit(VariableDeclarationStatement node) {
		c.countUp("var");
		return super.visit(node);
	}

	@Override
	public boolean visit(FieldAccess node) {
		c.countUp("fidAcs");
		return super.visit(node);
	}

	@Override
	public boolean visit(SuperFieldAccess node) {
		c.countUp("fidAcs");
		return super.visit(node);
	}

	@Override
	public boolean visit(ArrayAccess node) {
		c.countUp("arrAcs");
		return super.visit(node);
	}

	@Override
	public boolean visit(CastExpression node) {
		c.countUp("cast");
		return super.visit(node);
	}

	@Override
	public boolean visit(IfStatement node) {
		c.countUp("ifs");
		return super.visit(node);
	}

	@Override
	public boolean visit(ForStatement node) {
		c.countUp("loop");
		return super.visit(node);
	}

	@Override
	public boolean visit(EnhancedForStatement node) {
		c.countUp("loop");
		return super.visit(node);
	}

	@Override
	public boolean visit(WhileStatement node) {
		c.countUp("loop");
		return super.visit(node);
	}

	@Override
	public boolean visit(MethodInvocation node) {
		c.countUp("mthInvoc");
		return super.visit(node);
	}

	@Override
	public boolean visit(SuperMethodInvocation node) {
		c.countUp("mthInvoc");
		return super.visit(node);
	}

	@Override
	public boolean visit(ArrayCreation node) {
		c.countUp("newInvoc");
		return super.visit(node);
	}

	@Override
	public boolean visit(ClassInstanceCreation node) {
		c.countUp("newInvoc");
		return super.visit(node);
	}

}
