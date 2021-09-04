import java.util.*;

/*
 * creating a class for storing the info of read-only books which implements library interface
 */

public class ReadBookAtLibrary implements Library {

	// creating field members for book info
	protected String BookId, BookIsbn, BookTitle, BookAuthorName, BookPublisherName;

	// creating a stack for books
	Stack<Stack<String>> book = new Stack<>();

	/* This method overrides the library interface. */

	@Override
	public void Add() {

	}

	/* Remove the top book information. */

	@Override
	public void remove() {
		try {
			Stack<String> temp = book.pop();
			this.popElement(temp);
		} catch (EmptyStackException e) {
			System.out.println("The stack is empty");
			System.out.println("No elements in stack");
		}
	}

	/*
	 * This method display the info of the top most book.
	 */

	@Override
	public void display(BarrowableBook obj) {

		try {
			Stack<String> temp = book.pop();
			this.popElement(temp);

			if (!temp.isEmpty()) {
				System.out.println("Checkout Date: " + temp.pop());
				System.out.println("Due Date: " + temp.pop());
				System.out.println("===========");
				obj.Add();
			} else {
				this.Add();
			}
		} catch (EmptyStackException e) {
			System.out.println("The stack is empty");
			System.out.println("No elements in stack");
		}

	}

	/*It will show the all books information*/

	@Override
	public void showAll() {
		Stack<Stack<String>> Book = book;

		if (Book.isEmpty())
			System.out.println("The stack is empty");
		System.out.println("No elements in stack");

		while (!Book.isEmpty()) {

			Stack<String> temp = Book.pop();

			while (!temp.isEmpty()) {
				this.popElement(temp);
				if (!temp.isEmpty()) {
					System.out.println("Checkout Date: " + temp.pop());
					System.out.println("Due Date: " + temp.pop());
					System.out.println("=============");
				}
			}
		}

	}

	/* This method pops the information from book.*/

	private void popElement(Stack<String> temp) {

		System.out.println("\n==============");
		System.out.println("Book ID: " + temp.pop());
		System.out.println("Book ISBN: " + temp.pop());
		System.out.println("Book title: " + temp.pop());
		System.out.println("Author: " + temp.pop());
		System.out.println("Publisher: " + temp.pop());
		if (temp.isEmpty()) {
			System.out.println("==============");
		}

	}

	/* This is a setter method. It helps to set the input values to the variables.*/
	public void setBook(String BookId, String BookIsbn, String BookTitle, String BookAuthorName, String BookPublisherName) {
		this.BookId = BookId;
		this.BookIsbn = BookIsbn;
		this.BookTitle = BookTitle;
		this.BookAuthorName = BookAuthorName;
		this.BookPublisherName = BookPublisherName;

	}

	/* These are getter methods. It helps to get value of the variables*/
	public String getBookId() {
		return BookId;
	}

	public String getBookIsbn() {
		return BookIsbn;
	}

	public String getBookTitle() {
		return BookTitle;
	}

	public String getAuthor() {
		return BookAuthorName;
	}

	public String getPublisher() {
		return BookPublisherName;
	}

}
