package com.jx2lee.thejava.dynamicproxy.proxypattern;

// Class 의 동적 proxy 객체 생성에 대한 테스트를 위해
// BookService interface 를 본따 Class 로 구현
public class BookServiceClass {
    public BookServiceClass() {
    }

    public void rent() {
        System.out.println("BookServiceClass.rent");
    }
    
    public void returnBook(Book book) {
        System.out.println("book.getName() = " + book.getName());
    }
}
