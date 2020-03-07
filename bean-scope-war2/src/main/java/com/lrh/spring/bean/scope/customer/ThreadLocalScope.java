package com.lrh.spring.bean.scope.customer;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 *  自定义的线程scope
 */
public class ThreadLocalScope implements Scope {


    public static final String SCOPE_NAME = "THREAD_SCOPE";

    private final NamedThreadLocal<Map<String, Object>> threadLocal = new NamedThreadLocal("thread-local-scope") {

        @Override
        protected Map initialValue() {
            return new HashMap();
        }
    };


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> context = getContext();
        Object object = context.get(name);
        if(object == null){
            object = objectFactory.getObject();
            context.put(name, object);
        }
        return object;
    }

    @Override
    public Object remove(String name) {
        return getContext().remove(name);
    }

    //注册销毁回调
    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return getContext().get(key);
    }

    @Override
    public String getConversationId() {
        return String.valueOf(Thread.currentThread().getId());
    }


    private Map<String,Object> getContext(){
        return threadLocal.get();
    }


}
