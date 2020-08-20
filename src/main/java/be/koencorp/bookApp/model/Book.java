package be.koencorp.bookApp.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Books2")
public class Book {
    public Book() {
    }

    /*
     * @Colums: geeft veld weer in database. Heeft veel opties e.g Nullable (geeft weer of null mag zijn) enz.
     * Deze annotatie heeft nog heel wat andere mogelijkheden.
     *
     * UUID, primary key is altijd uniek. 32 bit gegenerereerde sleutel. Handig want moeilijk te hakken!
     * toestencombo's ctr o (control organize imports !).
     * Conventies: packages altijd met kleine letters ! variabelen nooit -. Naam velden tabel ook kleine letters en scheiding met underscore!
     * Validatie hier niet gedaan moet in app gezet worden !
     *
     *
     */
    @Id
    @Column(name = "id", updatable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "isbn", nullable = false, length = 13, unique = true)
    private String isbn;

    @Column(name = "revision", nullable = false)
    private String revision;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "is_fiction", nullable = false)
    private boolean fiction;

    @Column(name = "date_read")
    private LocalDate date;

    public Book(String title, String author, String isbn, String revision,
                Type type, boolean fiction, LocalDate date) {

        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.revision = revision;
        this.type = type;
        this.fiction = fiction;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isFiction() {
        return fiction;
    }

    public void setFiction(boolean fiction) {
        this.fiction = fiction;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {

        return String.format("%10s |%20s|%14s|%5s|%15s|%15s",
                title, author, isbn, revision, type, fiction );
    }


}

