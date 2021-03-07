package com.github.dkurata38.liblio.infrastructure.domain.bibliography;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.github.dkurata38.liblio.domain.bibliography.Author;
import com.github.dkurata38.liblio.domain.bibliography.Bibliography;
import com.github.dkurata38.liblio.domain.bibliography.BibliographyId;
import com.github.dkurata38.liblio.domain.bibliography.BibliographyRepository;
import com.github.dkurata38.liblio.domain.bibliography.ISBN;
import com.github.dkurata38.liblio.domain.bibliography.Language;
import com.github.dkurata38.liblio.domain.bibliography.Publisher;
import com.github.dkurata38.liblio.domain.bibliography.Title;

@Repository
public class BibliographyRepositoryImpl implements BibliographyRepository {
	@Override
	public Iterable<Bibliography> findAll() {
		return List.of(
				new Bibliography(
						new BibliographyId("aaa"),
						new Title("品川図書館の本"),
						List.of(new Author("猫"), new Author("犬")),
						new Publisher("竹書房跡"),
						Language.JAPANESE,
						LocalDate.now(),
						new ISBN("978-4-7981-3161-0")
				),
				new Bibliography(
						new BibliographyId("bbb"),
						new Title("他の図書館の本"),
						List.of(new Author("猫"), new Author("猿")),
						new Publisher("竹書房"),
						Language.JAPANESE,
						LocalDate.now(),
						new ISBN("978-4-7981-3162-0")
				)
		);
	}
}
