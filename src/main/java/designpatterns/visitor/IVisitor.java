package designpatterns.visitor;

public interface IVisitor {
    void visit(ConcreteElement1 el1);

    void visit(ConcreteElement2 el2);
}
