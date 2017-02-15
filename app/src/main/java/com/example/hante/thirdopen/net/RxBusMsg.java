package com.example.hante.thirdopen.net;


import io.reactivex.Observable;
import io.reactivex.subjects.Subject;

/**
 * Created By HanTe
 * 事件总线
 */

public class RxBusMsg {

    private static volatile RxBusMsg mInstance;
    private Subject mSubject;

    public RxBusMsg () {

    }
    public static RxBusMsg getInstance(){
        RxBusMsg rxBus = mInstance;
        if (mInstance == null){
            synchronized(RxBusMsg.class){
                rxBus = mInstance;
                if (mInstance == null){
                    rxBus = new RxBusMsg();
                    mInstance = rxBus;
                }
            }
        }
        return rxBus;
    }

    /**
     * Unchecked call to 'onNext(T)' as a member of raw type 'io.reactivex.Observer'
     * 发送消息
     *
     * @param object 消息对象
     */
    public void postMsg (Object object){
        mSubject.onNext(object);
    }

    /**
     * 接收消息
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     * @param eventType 事件
     * @param <T> 对象
     * @return 得到的信息
     */
    public <T> Observable<T> toObservable(Class<T> eventType){
        return mSubject.ofType(eventType);
    }
}
