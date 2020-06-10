package designpatterns.interpreter;

import java.util.Stack;

public class Client {
    public static void main(String[] args) {
        String expression = "";
        char[] charArray = expression.toCharArray();
        Context ctx = new Context();
        Stack<Expression> stack = new Stack();

        for (int i = 0; i < stack.size(); i++) {
            Expression exp = stack.pop();
            exp.interpreter(ctx);
        }

    }
}
