package be.koencorp.bookApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookApp {
    private static BookDAO dao;


    public static void main(String[] args) {
        EntityManagerFactory emf;
        EntityManager em;
        dao = new DAO();
        emf = Persistence.createEntityManagerFactory("course");
        em = emf.createEntityManager();
        dao.setEntityManager(em);

        BookApp app=new BookApp();

      // app.fillDatabase();



    }


    public void fillDatabase() {
        Book book_01 = new Book("Tiny gaat op reis", " Gilbert Delahaye", Status.UNASSIGNED);
        Book book_02 = new Book("Tiny krijgt een gasboete", " Gilbert Delahaye", Status.UNASSIGNED);
        Book book_03 = new Book("Tiny liet een windje in de tent", " Gilbert Delahaye", Status.UNASSIGNED);
        Book book_04 = new Book("Tiny doet kaka in de tuin", " Gilbert Delahaye", Status.UNASSIGNED);
        Book book_05 = new Book("Tiny is op vakantie", " Gilbert Delahaye", Status.UNASSIGNED);

        dao.save(book_01);
        dao.save(book_02);
        dao.save(book_03);
        dao.save(book_04);
        dao.save(book_05);


    }
}
