package com.github.dkurata38.liblio.domain.bibliography;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDate;

@EqualsAndHashCode(of = {"id"})
@ToString
public class Bibliography {
    @Getter
    private final BibliographyId id;
    @Getter
    private final Title title;
    @Getter
    private final Iterable<Author> authors;
    @Getter
    private final Publisher publisher;
    @Getter
    private final Language language;
    @Getter
    private final LocalDate publishedDate;
    @Getter
    private final ISBN isbn;

    public Bibliography(@NonNull BibliographyId id, @NonNull Title title, @NonNull Iterable<Author> authors,
                        @NonNull Publisher publisher, @NonNull Language language, @NonNull LocalDate publishedDate,
                        @NonNull ISBN isbn) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.language = language;
        this.publishedDate = publishedDate;
        this.isbn = isbn;
    }
}
