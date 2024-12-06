public class Main {
    public static void main(String[] args) {
        System.out.println("=== Library Book Manager ===");
        Library library = new Library();
        library.addBook(new Book("Harry Potter", "J.K. Rowling", 1997));
        library.addBook(new Book("The Master and Margarita", "Mikhail Bulgakov", 1966));
        library.addBook(new Book("Game of Thrones", "George R.R. Martin", 1996));

        System.out.println("Books by J.K. Rowling: " + library.searchByAuthor("J.K. Rowling"));
        System.out.println("Total books in the library: " + library.countBooks());

        library.removeBook("Game of Thrones");
        System.out.println("Books count after removal: " + library.countBooks());

        System.out.println("\n=== Bank Account Management ===");
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("12345", 1000);
        BankAccount account2 = bank.createAccount("67890", 500);

        account1.deposit(200);
        System.out.println("Balance of account 12345 after deposit: " + account1.getBalance());

        account1.transferTo(account2, 300);
        System.out.println("Balance of account 12345 after transfer: " + account1.getBalance());
        System.out.println("Balance of account 67890 after receiving transfer: " + account2.getBalance());

        bank.blockAccount(account1);
        account1.withdraw(100);
        System.out.println("Attempt to withdraw from a blocked account. Balance: " + account1.getBalance());

        System.out.println("\n=== Employee Management System ===");
        Company company = new Company();
        company.addEmployee(new Employee("Alex", 8000, "IT"));
        company.addEmployee(new Employee("Maria", 6000, "Marketing"));
        company.addEmployee(new Employee("Anna", 4000, "Finance"));

        System.out.println("Total salary of the company: " + company.calculateTotalSalary());
        System.out.println("Average salary of employees: " + company.calculateAverageSalary());

        company.removeEmployee("Maria");
        System.out.println("Total salary after removing an employee: " + company.calculateTotalSalary());
    }
}
