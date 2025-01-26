package stevenNavarretteII;

import java.util.Arrays; //library for arrays
import java.util.Objects; //library for objects

class Book implements Comparable<Book> {
    private String title;
    private String[] authors;
    private int issueYear;

    //constructor
    public Book(String title, String[] authors, int issueYear) {
        this.title = title;
        this.authors = authors;
        this.issueYear = issueYear;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public int getIssueYear() {
        return issueYear;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    //used equals method to compare Books based on authors
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Arrays.equals(this.authors, book.authors);
    }

    //learned how to use hash code because I used equals method and is recommended
    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(authors));
    }

    //method to compare by issue year
    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.issueYear, other.issueYear);
    }

    //display stevenNavarretteII.Book details
    @Override
    public String toString() {
        return "stevenNavarretteII.Book{" +
                "title='" + title + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", issueYear=" + issueYear +
                '}';
    }

    //main
    public static void main(String[] args) {
        Book[] books = {
                new Book("ABC ... and more", new String[]{"author1", "author2"}, 1980),
                new Book("A book", new String[]{"author3", "author4"}, 1980),
                new Book("A book-3", new String[]{"another author", "author2"}, 1982),
                new Book("A book-2", new String[]{"a1", "a2"}, 1982)
        };

        //books before sorting
        System.out.println("Books before sorting:");
        for (Book book : books) {
            System.out.println(book);
        }

        //sort by issue year
        Arrays.sort(books);

        //display after sorting
        System.out.println("\nBooks after sorting by issue year:");
        for (Book book : books) {
            System.out.println(book);
        }

        //equals method
        System.out.println("\nComparing books:");
        System.out.println("stevenNavarretteII.Book 1 equals stevenNavarretteII.Book 2: " + books[0].equals(books[1]));
        System.out.println("stevenNavarretteII.Book 1 equals stevenNavarretteII.Book 3: " + books[0].equals(books[2]));
    }
}
