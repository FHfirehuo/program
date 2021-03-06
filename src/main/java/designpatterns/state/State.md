# 状态模式

允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类，(State Pattern)是设计模式的一种，属于行为模式。

定义

(源于Design Pattern)：当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类。
状态模式主要解决的是当控制一个对象状态的条件表达式过于复杂时的情况。把状态的判断逻辑转移到表示不同状态的一系列类中，可以把复杂的判断逻辑简化。
模式中的角色

1 上下文环境（Context）：它定义了客户程序需要的接口并维护一个具体状态角色的实例，将与状态相关的操作委托给当前的Concrete State对象来处理。

2 抽象状态（State）：定义一个接口以封装使用上下文环境的的一个特定状态相关的行为。

3 具体状态（Concrete State）：实现抽象状态定义的接口。

这里来看看状态模式的标准代码；

首先我们先定义一个State抽象状态类，里面定义了一个接口以封装 与Context的一个特定状态相关的行为；


打印结果如下
本人王小二，因为十一家里有事情，所以要多请三天假，希望公司能够审核通过
本人王小二，因为十一家里有事情，所以要多请三天假，希望公司能够审核通过张经理审核通过;HR李审核通过
审核通过,流程结束；

上面这个例子只是很简单的模仿了一下工作流控制状态的跳转。状态模式最主要的好处就是把状态的判断与控制放到了其服务端的内部，使得客户端不需要去写很多代码判断，来控制自己的节点跳转，而且这样实现的话，我们可以把每个节点都分开来处理，当流程流转到某个节点的时候，可以去写自己的节点流转方法。当然状态模式的缺点也很多，比如类的耦合度比较高，基本上三个类要同时去写，而且会创建很多的节点类。


