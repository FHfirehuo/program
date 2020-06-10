package designpatterns.state;

public class ConcreteStateA extends State {
    @Override
    public void Handle(Context context) {
        context.setState(new ConcreteStateB()); //设置A的下一个状态是B

    }
}
