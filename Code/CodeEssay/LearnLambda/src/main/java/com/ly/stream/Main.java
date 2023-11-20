package com.ly.stream;


import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Author> authors = Initial.getAuthors();
        authors.stream()
                .distinct()
                .filter(author -> author.getAge() < 18)
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .limit(1)
                .flatMap(author -> {
                    return author.getBooks().stream();
                })
                .distinct()
                .forEach(book -> System.out.println(book));

        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((score1, score2) -> score1 - score2);

    }

}
