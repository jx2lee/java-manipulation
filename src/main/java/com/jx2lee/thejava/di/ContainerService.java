package com.jx2lee.thejava.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {
    /**
     * T type 의 generic type 선언
     * Class<T> 타입의 클래스가 들어오면 클래스 타입을 변경한다.
     */

    public static <T> T getObject(Class<T> classType) {
        /**
         * 인스턴스를 생성하고
         * 해당 인스턴스를 stream 으로 선언된 필드를 검색하여
         * Inject annotation 이 설정된 필드가 존재하면
         * 이전시간에 살펴본 reflection api 로 필드를 주입한다.
         */
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f -> {
            if (f.getAnnotation(Inject.class) != null) {
                Object fieldInstance = createInstance(f.getType());
                f.setAccessible(true);
                try {
                    f.set(instance, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        /**
         * 소스코드에서는 테스트코드 클래스를 참조할 수 없다.
         * 그 반대는 가능하지만..
         * reflection 을 사용한다.
         */

        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
