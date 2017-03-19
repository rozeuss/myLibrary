package app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Library {
	private Map<Integer, Book> books = new HashMap<>();
	private Map<Integer, String> lentBooks = new HashMap<>();

	public Book addNewBook(String author, String title, int year) {
		Book newBook = new Book(title, year, author);
		books.put(newBook.getId(), newBook);
		return newBook;
	}

	public boolean removeBookById(int chosenId) {
		boolean found = false;
		if (books.containsKey(chosenId))
			if (!books.get(chosenId).isLent()) {
				books.remove(chosenId);
				found = true;
			}
		return found;
	}

	public void listAllBooks() {
		System.out.printf("%-10s %-40s %-40s %-10s\n", "[ID]", "Author", "\"Title\"", "Year");
		for (Book book : books.values()) {
			System.out.printf("%-10s %-40s %-40s %-10s\n", "[" + book.getId() + "]", book.getAuthor(),
					"\"" + book.getTitle() + "\"", book.getYear());
		}
		System.out.println("Books available: " + (books.size() - lentBooks.size()));
		System.out.println("Books lent: " + lentBooks.size());
	}

	public Collection<Book> searchInBooks(String title, Integer year, String author) {
		Stream<Book> bookStream = books.values().stream();
		if (title != null) {
			bookStream = filterBookStreamByTitle(bookStream, title);
		}

		if (year != null) {
			bookStream = filterBookStreamByYear(bookStream, year);
		}

		if (author != null) {
			bookStream = filterBookStreamByAuthor(bookStream, author);
		}

		return bookStream.collect(Collectors.toList());
	}

	private Stream<Book> filterBookStreamByAuthor(Stream<Book> bookStream, String author) {
		return bookStream.filter(b -> b.getAuthor().contains(author));
	}

	private Stream<Book> filterBookStreamByTitle(Stream<Book> bookStream, String title) {
		return bookStream.filter(b -> b.getTitle().contains(title));
	}

	private Stream<Book> filterBookStreamByYear(Stream<Book> bookStream, int year) {
		return bookStream.filter(b -> b.getYear() == year);
	}

	public boolean lendBookById(int chosenId, String lenderName) {
		boolean found = false;
		if (books.containsKey(chosenId)) {
			if (!books.get(chosenId).isLent()) {
				found = true;
				lentBooks.put(chosenId, lenderName);
				books.get(chosenId).setLent(true);
			}
		}
		return found;
	}

	public boolean showBookDetails(int chosenId) {
		boolean found = false;
		if (books.containsKey(chosenId)) {
			found = true;
			System.out.println(books.get(chosenId).toString());
			System.out.println("Is lent: " + books.get(chosenId).isLent());
			if (books.get(chosenId).isLent()) {
				System.out.println("By: " + lentBooks.get(chosenId));
			}
		}
		return found;
	}


	/**
	 * @return the books
	 */
	public Map<Integer, Book> getBooksInLibrary() {
		return books;
	}

	/**
	 * @param books
	 *            the books to set
	 */
	public void setBooksInLibrary(Map<Integer, Book> books) {
		this.books = books;
	}

	/**
	 * @return the lentBooks
	 */
	public Map<Integer, String> getLentBooks() {
		return lentBooks;
	}

	/**
	 * @param lentBooks
	 *            the lentBooks to set
	 */
	public void setLentBooks(Map<Integer, String> lentBooks) {
		this.lentBooks = lentBooks;
	}


}
