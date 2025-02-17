package by.itclass.model.entities;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookInLibrary {
    private int id;
    private String title;
    private String author;
    private int pages;
    @NonNull
    private int library_id;
}
