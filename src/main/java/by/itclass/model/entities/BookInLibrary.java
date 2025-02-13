package by.itclass.model.entities;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class BookInLibrary {
    private String title;
    private String author;
    private int pages;
    @NonNull
    private int library_id;
}
