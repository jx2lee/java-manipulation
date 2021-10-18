package com.jx2lee.thejava.dynamicproxy;

import com.jx2lee.thejava.dynamicproxy.proxypattern.Book;
import com.jx2lee.thejava.dynamicproxy.proxypattern.BookServiceClass;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static net.bytebuddy.matcher.ElementMatchers.named;

class BookServiceDynamicProxyUsingByteBuddyTest {

    @Test
    public void 클래스_간_동적_프록시_객체를_생성한다_bytebuddy() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends BookServiceClass> proxyClass = new ByteBuddy().subclass(BookServiceClass.class)
                .method(named("rent")) // rent 함수 이외 모든 함수에 적용하고 싶을 경우 any()
                .intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    BookServiceClass bookServiceClass = new BookServiceClass();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("===========");
                        Object invoke = method.invoke(bookServiceClass, args);
                        System.out.println("===========");
                        return invoke;
                    }
                }))
                .make()
                .load(BookServiceClass.class.getClassLoader()).getLoaded();
        BookServiceClass bookServiceClassUsingByteBuddy = proxyClass.getConstructor(null).newInstance();

        Book book = new Book();
        book.setName("클래스_간_동적_프록시_객체를_생성한다");
        bookServiceClassUsingByteBuddy.rent();
        bookServiceClassUsingByteBuddy.returnBook(book);
        System.out.println();
        System.out.println();

    }
}
