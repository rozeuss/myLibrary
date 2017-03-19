package app;

public class Book {
	private String title;
	private int year;
	private String author;
	private int id = 0;
	private static int idCounter = 0;
	private boolean isLent;

	@Override
	public String toString() {
		return "ID:" + id + " [title=" + title + ", year=" + year + ", author=" + author + "]";

	}

	public Book(String title, int year, String author) {
		super();
		idCounter++;
		id = idCounter;
		this.title = title;
		this.year = year;
		this.author = author;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the isLent
	 */
	public boolean isLent() {
		return isLent;
	}

	/**
	 * @param isLent
	 *            the isLent to set
	 */
	public void setLent(boolean isLent) {
		this.isLent = isLent;
	}

}
