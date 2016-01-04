package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    private List<String> books;
    private PrintStream printStream;
    private DateTimeFormatter dateTimeFormatter;
    private Library library;
    @Before
    public void setUp()  {
        books = new ArrayList();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        library = new Library(books, printStream, dateTimeFormatter);
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        books.add(title);

        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        library.listBooks();
        verify(printStream, never()).println();
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {

        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("1", "2");
        // implement me

        books.add(reader.readLine());
        books.add(reader.readLine());

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.listBooks();

        verify(printStream).println("1");
        verify(printStream).println("2");

    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        DateTime time = new DateTime();

        when(dateTimeFormatter.print(time)).thenReturn("");

        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        DateTime time = new DateTime();

        when(dateTimeFormatter.print(time)).thenReturn("7:19 PM");


        library.welcome(time);

        verify(printStream).println("Welcome to the library! The current time is 7:19 PM");
    }
}