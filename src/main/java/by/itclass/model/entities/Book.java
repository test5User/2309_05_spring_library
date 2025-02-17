package by.itclass.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String title;
    @NonNull private String author;
    @NonNull private int pages;
    @ManyToOne
    @NonNull private Library library;

    public Book(@NonNull Library library) {
        this.library = library;
    }
}
