import java.util.ArrayList;

public class Student {
    String name;
    int groupNumber;
    double averageGrade;
    ArrayList<Book> bookList = new ArrayList<>();

    public Student(String name, int groupNumber, double averageGrade) {
        this.name = name;
        this.groupNumber = groupNumber;
        this.averageGrade = averageGrade;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{")
                .append("name='").append(name).append('\'')
                .append(", groupNumber=").append(groupNumber)
                .append(", averageGrade=").append(averageGrade);

        if (!bookList.isEmpty()) {
            sb.append(", books=").append(bookList);
        }

        sb.append('}');
        return sb.toString();
    }
}
