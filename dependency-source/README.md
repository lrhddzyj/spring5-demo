#依赖查找的来源

1，Spring BeanDefinition

2,单例对象(用SingletonBeanRegistry注册的对象)

3,Spring内建BeanDefinition
```$xslt
     ConfigurationClassPostProcessor -> 处理Spring 配置类
     AutowiredAnnotationBeanProcessor -> 处理@Autowired 以及@Value注解
     CommonAnnotationBeanPostProcessor -> (条件激活)处理JSR-250 注解，如@PostConstruct等
     EventListenerMethodProcesssor  -> 处理标注@EventListener的Spring事件监听方法
```
4,Spring内建单例独享
   
   |Bean 名称|Bean 实例 |使用场景|
   |:----:|:----|----:|
   |environment|Environment 对象|外部化配置以及Profile|
   |systemProperties| java.util.Properties |Java 系统属性|
   |systemEnvironment|java.util.Map 对象|操作系统的环境变量|
   |messageSource| MessageSource 对象| 国际化文案|
   |lifecycleProcessor| LifecycleProcessor 对象| Lifecycle Bean 处理器|
   |applicationEventMulticaster| ApplicationEventMulticaster 对象 | Spring 事件广播器|
 


# 依赖注入的来源

１，Spring BeanDefinition 

2,单例对象(用SingletonBeanRegistry注册的对象)

3,Spring内建BeanDefinition
```$xslt
     ConfigurationClassPostProcessor -> 处理Spring 配置类
     AutowiredAnnotationBeanProcessor -> 处理@Autowired 以及@Value注解
     CommonAnnotationBeanPostProcessor -> (条件激活)处理JSR-250 注解，如@PostConstruct等
     EventListenerMethodProcesssor  -> 处理标注@EventListener的Spring事件监听方法
```

4,Spring内建单例独享
   
   |Bean 名称|Bean 实例 |使用场景|
   |:----:|:----|----:|
   |environment|Environment 对象|外部化配置以及Profile|
   |systemProperties| java.util.Properties |Java 系统属性|
   |systemEnvironment|java.util.Map 对象|操作系统的环境变量|
   |messageSource| MessageSource 对象| 国际化文案|
   |lifecycleProcessor| LifecycleProcessor 对象| Lifecycle Bean 处理器|
   |applicationEventMulticaster| ApplicationEventMulticaster 对象 | Spring 事件广播器|
 


5,非Spring容器管理的对象Bean Resolvable Dependency(

   ```
     典型：ApplicationContext BeanFactory ResourceLoader ApplicationEventPublisher)

     注册：ConfigurableListableBeanFactory#registerResolvableDependency
        
   ```
        

6,外部化配置对象(@Value @Resource)