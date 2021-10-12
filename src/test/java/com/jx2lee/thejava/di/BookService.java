package com.jx2lee.thejava.di;

public class BookService {

    /**
     * 다양한 주입 방법이 있지만 (생성자 or Setter)
     * filed 주입 방법으로 진행
     * 주입 방법에 대한 소개
        * https://velog.io/@gillog/Spring-DIDependency-Injection-%EC%84%B8-%EA%B0%80%EC%A7%80-%EB%B0%A9%EB%B2%95
    **/
    @Inject
    BookRepository bookRepository;
}
