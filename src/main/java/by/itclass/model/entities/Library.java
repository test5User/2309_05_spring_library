package by.itclass.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull private int id;
    @Column(length = 50)
    @NonNull private String name;
    @Column(length = 50)
    @NonNull private String address;
    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
    private List<Book> books;

    public Library(String name,String address) {
        this.name = name;
        this.address = address;
    }
}
