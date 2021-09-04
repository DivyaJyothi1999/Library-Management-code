import java.util.*;

/*
 * This is driver class, is for inputs and calling methods
 */
public class Books1 {
	// create a static member for input
	static String bookId, bookIsbn, bookTitle, authorName, publisherName, checkOutDate, dueDate;

	
	static Scanner s = new Scanner(System.in);

	/* Book information from the user*/
	public static void input() {
		s.nextLine();
		System.out.println("Enter Book ID:");
		bookId = s.nextLine();
		System.out.println("Enter Book ISBN:");
		bookIsbn = s.nextLine();
		System.out.println("Enter Book Title:");
		bookTitle = s.nextLine();
		System.out.println("Enter Author Name:");
		authorName = s.nextLine();
		System.out.println("Enter Publisher Name");
		publisherName = s.nextLine();
	}

	/* Date information from user.*/
	public static void date() {
		System.out.println("Enter Check Out  Date:");
		checkOutDate = s.next();
		System.out.println("Enter Due Date:");
		dueDate = s.next();
	}

	/* In this Main method, object created for subclass and call methods using switch case.*/

	public static void main(String[] args) {

		BarrowableBook obj = new BarrowableBook();

		boolean temp = true;

		// It is for repeated process until user stop.
		while (temp) {
			System.out.println("===================");
			System.out.println("LIBRARY MANAGAEMENT");
			System.out.println("===================");
			System.out.println("1. ADD A BOOK");
			System.out.println("2. REMOVE A BOOK");
			System.out.println("3. DISPLAY THE BOOK AT TOP");
			System.out.println("4. SHOW ALL BOOKS");
			System.out.println("Enter The Choice:");
			int choice = s.nextInt();
			/* switch used to make a choice based on user input.*/
			switch (choice) {
			case 1:
				while (true) {
					System.out.println("================");
					System.out.println("CHOOSE BOOK TYPE");
					System.out.println("================");
					System.out.println("1. READ ONLY BOOK");
					System.out.println("2. BORROWABLE BOOK");
					System.out.println("Enter The Choice:");
					int choose = s.nextInt();
					if (choose == 1) {
						input();
						obj.setBook(bookId, bookIsbn, bookTitle, authorName, publisherName);
						obj.initial();
						obj.Add();
						obj.display(obj);
						break;
					} else if (choose == 2) {
						input();
						date();
						obj.setBook(bookId, bookIsbn, bookTitle, authorName, publisherName);
						obj.setDate(checkOutDate, dueDate);
						obj.Add();
						obj.display(obj);
						break;
					} else {
						System.out.println("\nEnter Valid Choice");
						continue;
					}
				}
				break;
			case 2:
				obj.remove();
				break;
			case 3:
				obj.display(obj);
				break;
			case 4:
				obj.showAll();
				break;
			default:
				System.out.println("\nEnter valid Choice");
			}

			while (true) {
				System.out.println("\n Do You want to continue?" + "" + "\nType - YES/NO");
				String str = s.next();
				if (str.equalsIgnoreCase("No")) {
					temp = false;
					s.close();
					break;
				} else if (str.equalsIgnoreCase("Yes"))
					break;
				else {
					System.out.println("\nInvalid Choice");
					continue;
				}

			}

		}
	}

}
