package be.koencorp.bookApp;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "Books")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    @Id
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String writer;
    @NonNull
    private Status status;

    private Date date;

    public Book(String title, String writer, Status status) {
        this.title=title;
        this.writer=writer;
        this.status=status;
    }
}

@AllArgsConstructor
@Getter
enum Status {
    TOREAD("to read"), READ("read"), UNASSIGNED("unassigned");
    private final String status;
    }
