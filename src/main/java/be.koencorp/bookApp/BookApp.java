package be.koencorp.bookApp;


import be.koencorp.bookApp.dao.BookJpaDao;
import be.koencorp.bookApp.model.Book;
import be.koencorp.bookApp.model.Type;

import javax.persistence.Persistence;

public class BookApp {


    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("bookpu");
        var em = emf.createEntityManager();
        Book book01 = new Book("a", "b", "111111112", "22222", Type.ROMAN, true, null);
        BookJpaDao bookJpaDao = new BookJpaDao(em);
        bookJpaDao.create(book01);

    }


//    public void fillDatabase() {
//        Book book_01 = new Book("Tiny gaat op reis", " Gilbert Delahaye", Status.UNASSIGNED);
//        Book book_02 = new Book("Tiny krijgt een gasboete", " Gilbert Delahaye", Status.UNASSIGNED);
//        Book book_03 = new Book("Tiny liet een windje in de tent", " Gilbert Delahaye", Status.UNASSIGNED);
//        Book book_04 = new Book("Tiny doet kaka in de tuin", " Gilbert Delahaye", Status.UNASSIGNED);
//        Book book_05 = new Book("Tiny is op vakantie", " Gilbert Delahaye", Status.UNASSIGNED);
//
//        dao.save(book_01);
//        dao.save(book_02);
//        dao.save(book_03);
//        dao.save(book_04);
//        dao.save(book_05);
//
//
//    }
}
