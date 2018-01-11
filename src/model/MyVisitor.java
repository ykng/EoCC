package model;

import java.util.List;

import org.eclipse.jdt.core.dom.*;

/*
	基本的に「記述」数をカウントしている。
	例えば、配列のアクセスにおいて、for(i=0; i<10; i++) { num[i] = i }
	とかあった場合は、配列にアクセスする本当の数は10だが、
	このプログラムは記述数として１回だけとカウントしている。
	=>　実際のアクセス数は別で用意するしかない
 */

public class MyVisitor extends ASTVisitor{

	int methodCounter = 0;
	Characteristics c = new Characteristics();

	public String out(){
		return c.out();
	}

	@Override
	public boolean visit(MethodDeclaration node) {
		int nos = 0;
		if (node.getBody() != null) {
			List<Statement> statements = node.getBody().statements();
			nos = StatementExpander.expand(statements).size();
		}
		System.out.println("Method " + String.valueOf(methodCounter++) + " : " + String.valueOf(nos) + " sentences.");

		for (int i = 0; i < nos; i++) {
			c.countUp("nos");
		}

		return super.visit(node);
	}

	// 以下の各種visitメソッドの中身を簡潔に記述するためのメソッド。
	// 冗長さがあまり変わらない気がするため、コメントアウト
	// nodeを返すのではなく、return super.visit(node)にできるなら価値あり。
//	private <T extends ASTNode> T countVisit(T node, String param) {
//		c.countUp(param);
//		return node;
//	}

	@Override
	// 内部クラスのものもカウント。内部クラス自体はノーカウント。
	public boolean visit(FieldDeclaration node) {
		c.countUp("field");
		return super.visit(node);
	}

	@Override
	// ""で囲まれたものがあれば、その度にカウント
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
	// 大体は this.~　とあるやつ。
	// これ特徴量として必要なのか怪しい。
	public boolean visit(FieldAccess node) {
		c.countUp("fidAcs");
		return super.visit(node);
	}

	@Override
	// 上にほぼ同じ。
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
	public boolean visit(QualifiedType node) {
		c.countUp("cast");
		System.out.println(node.toString());
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
