# 适配器模式

适配器模式(Adapter Pattern)：将一个接口转换成客户希望的另一个接口，
使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。
适配器模式既可以作为类结构型模式，也可以作为对象结构型模式。

在适配器模式中，我们通过增加一个新的适配器类来解决接口不兼容的问题
，使得原本没有任何关系的类可以协同工作。

根据适配器类与适配者类的关系不同，适配器模式可分为对象适配器和类适配器两种，
在对象适配器模式中，适配器与适配者之间是关联关系；
在类适配器模式中，适配器与适配者之间是继承（或实现）关系。


适配器模式总结
主要优点：

将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，无须修改原有结构。
增加了类的透明性和复用性，将具体的业务实现过程封装在适配者类中，对于客户端类而言是透明的，而且提高了适配者的复用性，同一个适配者类可以在多个不同的系统中复用。
灵活性和扩展性都非常好，通过使用配置文件，可以很方便地更换适配器，也可以在不修改原有代码的基础上增加新的适配器类，完全符合“开闭原则”。
具体来说，类适配器模式还有如下优点：

由于适配器类是适配者类的子类，因此可以在适配器类中置换一些适配者的方法，使得适配器的灵活性更强。
对象适配器模式还有如下优点：

一个对象适配器可以把多个不同的适配者适配到同一个目标；
可以适配一个适配者的子类，由于适配器和适配者之间是关联关系，根据“里氏代换原则”，适配者的子类也可通过该适配器进行适配。
类适配器模式的缺点如下：

对于Java、C#等不支持多重类继承的语言，一次最多只能适配一个适配者类，不能同时适配多个适配者；
适配者类不能为最终类，如在Java中不能为final类，C#中不能为sealed类；
在Java、C#等语言中，类适配器模式中的目标抽象类只能为接口，不能为类，其使用有一定的局限性。
对象适配器模式的缺点如下：

与类适配器模式相比，要在适配器中置换适配者类的某些方法比较麻烦。如果一定要置换掉适配者类的一个或多个方法，可以先做一个适配者类的子类，将适配者类的方法置换掉，然后再把适配者类的子类当做真正的适配者进行适配，实现过程较为复杂。
适用场景：

系统需要使用一些现有的类，而这些类的接口（如方法名）不符合系统的需要，甚至没有这些类的源代码。
想创建一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作。


## 源码分析适配器模式的典型应用
spring AOP中的适配器模式
在Spring的Aop中，使用的 Advice（通知） 来增强被代理类的功能。

Advice的类型有：MethodBeforeAdvice、AfterReturningAdvice、ThrowsAdvice

在每个类型 Advice 都有对应的拦截器，MethodBeforeAdviceInterceptor、AfterReturningAdviceInterceptor、ThrowsAdviceInterceptor

Spring需要将每个 Advice 都封装成对应的拦截器类型，返回给容器，所以需要使用适配器模式对 Advice 进行转换

三个适配者类 Adaptee 如下：

```java
public interface MethodBeforeAdvice extends BeforeAdvice {
    void before(Method var1, Object[] var2, @Nullable Object var3) throws Throwable;
}

public interface AfterReturningAdvice extends AfterAdvice {
    void afterReturning(@Nullable Object var1, Method var2, Object[] var3, @Nullable Object var4) throws Throwable;
}

public interface ThrowsAdvice extends AfterAdvice {
}

```

目标接口 Target，有两个方法，一个判断 Advice 类型是否匹配，一个是工厂方法，创建对应类型的 Advice 对应的拦截器

```java
public interface AdvisorAdapter {
    boolean supportsAdvice(Advice var1);

    MethodInterceptor getInterceptor(Advisor var1);
}
```

三个适配器类 Adapter 分别如下，注意其中的 Advice、Adapter、Interceptor之间的对应关系

```java
class MethodBeforeAdviceAdapter implements AdvisorAdapter, Serializable {
	@Override
	public boolean supportsAdvice(Advice advice) {
		return (advice instanceof MethodBeforeAdvice);
	}

	@Override
	public MethodInterceptor getInterceptor(Advisor advisor) {
		MethodBeforeAdvice advice = (MethodBeforeAdvice) advisor.getAdvice();
		return new MethodBeforeAdviceInterceptor(advice);
	}
}

@SuppressWarnings("serial")
class AfterReturningAdviceAdapter implements AdvisorAdapter, Serializable {
	@Override
	public boolean supportsAdvice(Advice advice) {
		return (advice instanceof AfterReturningAdvice);
	}
	@Override
	public MethodInterceptor getInterceptor(Advisor advisor) {
		AfterReturningAdvice advice = (AfterReturningAdvice) advisor.getAdvice();
		return new AfterReturningAdviceInterceptor(advice);
	}
}

class ThrowsAdviceAdapter implements AdvisorAdapter, Serializable {
	@Override
	public boolean supportsAdvice(Advice advice) {
		return (advice instanceof ThrowsAdvice);
	}
	@Override
	public MethodInterceptor getInterceptor(Advisor advisor) {
		return new ThrowsAdviceInterceptor(advisor.getAdvice());
	}
}

```


客户端 DefaultAdvisorAdapterRegistry
```java
public class DefaultAdvisorAdapterRegistry implements AdvisorAdapterRegistry, Serializable {
    private final List<AdvisorAdapter> adapters = new ArrayList(3);

    public DefaultAdvisorAdapterRegistry() {
        // 这里注册了适配器
        this.registerAdvisorAdapter(new MethodBeforeAdviceAdapter());
        this.registerAdvisorAdapter(new AfterReturningAdviceAdapter());
        this.registerAdvisorAdapter(new ThrowsAdviceAdapter());
    }
    
    public MethodInterceptor[] getInterceptors(Advisor advisor) throws UnknownAdviceTypeException {
        List<MethodInterceptor> interceptors = new ArrayList(3);
        Advice advice = advisor.getAdvice();
        if (advice instanceof MethodInterceptor) {
            interceptors.add((MethodInterceptor)advice);
        }

        Iterator var4 = this.adapters.iterator();

        while(var4.hasNext()) {
            AdvisorAdapter adapter = (AdvisorAdapter)var4.next();
            if (adapter.supportsAdvice(advice)) {   // 这里调用适配器方法
                interceptors.add(adapter.getInterceptor(advisor));  // 这里调用适配器方法
            }
        }

        if (interceptors.isEmpty()) {
            throw new UnknownAdviceTypeException(advisor.getAdvice());
        } else {
            return (MethodInterceptor[])interceptors.toArray(new MethodInterceptor[0]);
        }
    }
    // ...省略...
} 
```
这里看 while 循环里，逐个取出注册的适配器，调用 supportsAdvice() 方法来判断 Advice 对应的类型，然后调用 getInterceptor() 创建对应类型的拦截器
这里应该属于对象适配器模式，关键字 instanceof 可看成是 Advice 的方法，不过这里的 Advice 对象是从外部传进来，而不是成员属性


spring JPA中的适配器模式
在Spring的ORM包中，对于JPA的支持也是采用了适配器模式，首先定义了一个接口的 JpaVendorAdapter，然后不同的持久层框架都实现此接口。

jpaVendorAdapter：用于设置实现厂商JPA实现的特定属性，如设置Hibernate的是否自动生成DDL的属性generateDdl；这些属性是厂商特定的，因此最好在这里设置；目前Spring提供 HibernateJpaVendorAdapter、OpenJpaVendorAdapter、EclipseLinkJpaVendorAdapter、TopLinkJpaVendorAdapter 四个实现。其中最重要的属性是 database，用来指定使用的数据库类型，从而能根据数据库类型来决定比如如何将数据库特定异常转换为Spring的一致性异常，目前支持如下数据库（DB2、DERBY、H2、HSQL、INFORMIX、MYSQL、ORACLE、POSTGRESQL、SQL_SERVER、SYBASE）

```java
public interface JpaVendorAdapter
{
  // 返回一个具体的持久层提供者
  public abstract PersistenceProvider getPersistenceProvider();

  // 返回持久层提供者的包名
  public abstract String getPersistenceProviderRootPackage();

  // 返回持久层提供者的属性
  public abstract Map<String, ?> getJpaPropertyMap();

  // 返回JpaDialect
  public abstract JpaDialect getJpaDialect();

  // 返回持久层管理器工厂
  public abstract Class<? extends EntityManagerFactory> getEntityManagerFactoryInterface();

  // 返回持久层管理器
  public abstract Class<? extends EntityManager> getEntityManagerInterface();

  // 自定义回调方法
  public abstract void postProcessEntityManagerFactory(EntityManagerFactory paramEntityManagerFactory);
}

```
我们来看其中一个适配器实现类 HibernateJpaVendorAdapter

```java
public class HibernateJpaVendorAdapter extends AbstractJpaVendorAdapter {
    //设定持久层提供者
    private final PersistenceProvider persistenceProvider;
    //设定持久层方言
    private final JpaDialect jpaDialect;

    public HibernateJpaVendorAdapter() {
        this.persistenceProvider = new HibernatePersistence();
        this.jpaDialect = new HibernateJpaDialect();
    }

    //返回持久层方言
    public PersistenceProvider getPersistenceProvider() {
        return this.persistenceProvider;
    }

    //返回持久层提供者
    public String getPersistenceProviderRootPackage() {
        return "org.hibernate";
    }

    //返回JPA的属性
    public Map<String, Object> getJpaPropertyMap() {
        Map jpaProperties = new HashMap();

        if (getDatabasePlatform() != null) {
            jpaProperties.put("hibernate.dialect", getDatabasePlatform());
        } else if (getDatabase() != null) {
            Class databaseDialectClass = determineDatabaseDialectClass(getDatabase());
            if (databaseDialectClass != null) {
                jpaProperties.put("hibernate.dialect",
                        databaseDialectClass.getName());
            }
        }

        if (isGenerateDdl()) {
            jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        }
        if (isShowSql()) {
            jpaProperties.put("hibernate.show_sql", "true");
        }

        return jpaProperties;
    }

    //设定数据库
    protected Class determineDatabaseDialectClass(Database database)     
    {                                                                                       
        switch (1.$SwitchMap$org$springframework$orm$jpa$vendor$Database[database.ordinal()]) 
        {                                                                                     
        case 1:                                                                             
          return DB2Dialect.class;                                                            
        case 2:                                                                               
          return DerbyDialect.class;                                                          
        case 3:                                                                               
          return H2Dialect.class;                                                             
        case 4:                                                                               
          return HSQLDialect.class;                                                           
        case 5:                                                                               
          return InformixDialect.class;                                                       
        case 6:                                                                               
          return MySQLDialect.class;                                                          
        case 7:                                                                               
          return Oracle9iDialect.class;                                                       
        case 8:                                                                               
          return PostgreSQLDialect.class;                                                     
        case 9:                                                                               
          return SQLServerDialect.class;                                                      
        case 10:                                                                              
          return SybaseDialect.class; }                                                       
        return null;              
    }

    //返回JPA方言
    public JpaDialect getJpaDialect() {
        return this.jpaDialect;
    }

    //返回JPA实体管理器工厂
    public Class<? extends EntityManagerFactory> getEntityManagerFactoryInterface() {
        return HibernateEntityManagerFactory.class;
    }

    //返回JPA实体管理器
    public Class<? extends EntityManager> getEntityManagerInterface() {
        return HibernateEntityManager.class;
    }
}

```


spring MVC中的适配器模式
Spring MVC中的适配器模式主要用于执行目标 Controller 中的请求处理方法。

在Spring MVC中，DispatcherServlet 作为用户，HandlerAdapter 作为期望接口，具体的适配器实现类用于对目标类进行适配，Controller 作为需要适配的类。

为什么要在 Spring MVC 中使用适配器模式？Spring MVC 中的 Controller 种类众多，不同类型的 Controller 通过不同的方法来对请求进行处理。如果不利用适配器模式的话，DispatcherServlet 直接获取对应类型的 Controller，需要的自行来判断，像下面这段代码一样：

```java
if(mappedHandler.getHandler() instanceof MultiActionController){  
   ((MultiActionController)mappedHandler.getHandler()).xxx  
}else if(mappedHandler.getHandler() instanceof XXX){  
    ...  
}else if(...){  
   ...  
} 

```
这样假设如果我们增加一个 HardController,就要在代码中加入一行 if(mappedHandler.getHandler() instanceof HardController)，这种形式就使得程序难以维护，也违反了设计模式中的开闭原则 – 对扩展开放，对修改关闭。

我们来看看源码，首先是适配器接口 HandlerAdapter

```java
public interface HandlerAdapter {
    boolean supports(Object var1);

    ModelAndView handle(HttpServletRequest var1, HttpServletResponse var2, Object var3) throws Exception;

    long getLastModified(HttpServletRequest var1, Object var2);
}

```

现该接口的适配器每一个 Controller 都有一个适配器与之对应，这样的话，每自定义一个 Controller 需要定义一个实现 HandlerAdapter 的适配器。

springmvc 中提供的 Controller 实现类有如下