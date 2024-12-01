import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] nameBook = {"book1", "book2", "book3"};
        String[] authorBook = {"author1", "author2", "author3"};
        String[] nameStudent = {"Anna","Oleg","Misha"};
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        Book book1 = new Book(nameBook[0], authorBook[0], random.nextInt(100) + 1);
        Book book2 = new Book(nameBook[1], authorBook[1], random.nextInt(100) + 1);
        Book book3 = new Book(nameBook[2], authorBook[2], random.nextInt(100) + 1);
        Student student1 = new Student(nameStudent[0],1 ,random.nextInt(12)+1);
        Student student2 = new Student(nameStudent[1],2 ,random.nextInt(12)+1 );
        Student student3 = new Student(nameStudent[2],3 ,random.nextInt(12)+1 );


        Circle circle1 = new Circle(random.nextInt(100)+1);
        Circle circle2 = new Circle(random.nextInt(100)+1);
        Circle circle3 = new Circle(random.nextInt(100)+1);
        while (true) {
            System.out.println("Choose which action you want: Circle, Book, Student ,or Exit.");
            String choice = sc.nextLine().toLowerCase();

            switch (choice) {
                case "student":
                    System.out.println("Choose number of Student: 1, 2, 3");
                    int studentChoice = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Choose action with Student: Info, Add(book), or Upgrade");
                    String studentAction = sc.nextLine().toLowerCase();

                    Student selectedStudent = studentChoice == 1 ? student1 :
                            studentChoice == 2 ? student2 :
                                    student3;

                    switch (studentAction) {
                        case "info":
                            Info_student(selectedStudent);
                            break;

                        case "add":
                            System.out.println("Choose book to add (1, 2, or 3):");
                            int bookChoice = sc.nextInt();
                            Book selectedBook = bookChoice == 1 ? book1 :
                                    bookChoice == 2 ? book2 :
                                            book3;
                            selectedStudent.addBook(selectedBook);
                            sc.nextLine();
                            break;

                        case "upgrade":
                            System.out.println();
                            break;

                        default:
                            System.out.println("Invalid action. Try again.");
                            break;
                    }
                    break;
                case "circle":
                    System.out.println("Choose circle (1, 2, or 3):");
                    int circleChoice = sc.nextInt();
                    Circle selectedCircle = circleChoice == 1 ? circle1 : circleChoice == 2 ? circle2 : circle3;
                    System.out.println("Choose action: Area or Length:");
                    sc.nextLine();
                    String circleAction = sc.nextLine().toLowerCase();

                    if (circleAction.equals("area")) {
                        applyArea(selectedCircle);
                    } else if (circleAction.equals("length")) {
                        applyLength(selectedCircle);
                    } else {
                        System.out.println("Invalid action.");
                    }
                    break;

                case "book":
                    System.out.println("Choose book (1, 2, or 3):");
                    int bookChoice = sc.nextInt();
                    Book selectedBook = bookChoice == 1 ? book1 : bookChoice == 2 ? book2 : book3;
                    System.out.println("Choose action: Info or Discount:");
                    sc.nextLine();
                    String bookAction = sc.nextLine().toLowerCase();

                    if (bookAction.equals("info")) {
                        Info_book(selectedBook);
                    } else if (bookAction.equals("discount")) {
                        System.out.println("Enter discount percentage:");
                        int discount = sc.nextInt();
                        applyDiscount(selectedBook, discount);
                        sc.nextLine();
                    } else {
                        System.out.println("Invalid action.");
                    }
                    break;

                case "exit":
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }


        }

        public static void applyArea(Circle circle) {
            double area = circle.calculateArea();
            System.out.println("Area of circle with radius " + circle.radius + " is: " + area);
        }

        public static void applyLength(Circle circle) {
            double length = circle.calculateLength();
            System.out.println("Length of circle with radius " + circle.radius + " is: " + length);
        }

        public static void applyDiscount(Book book, int discountPercentage) {
            int discountedPrice = Book.discount(book.price, discountPercentage);
            System.out.println("Price of " + book.name + " with discount " + discountPercentage + "%: " + discountedPrice);
        }
        public static void Info_book(Book book){
            System.out.println(book);
        }
        public static void Info_student(Student student){
            System.out.println(student);
        }


    }


