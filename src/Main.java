public class Main {
    public static void main(String[] args) {
        try {
            divideByZero();
            accessInvalidArrayIndex();
            triggerNullPointer();
        } catch (ArithmeticException e) {
            System.out.println("Помилка арифметики: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Помилка доступу до масиву: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Помилка: виклик методу на null: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Інша помилка: " + e.getMessage());
        } finally {
            System.out.println("Програма завершила обробку помилок.");
        }
    }

    private static void divideByZero() {
        int result = 10 / 0;
    }

    private static void accessInvalidArrayIndex() {
        int[] numbers = {1, 2, 3};
        int invalidIndex = numbers[5];
    }

    private static void triggerNullPointer() {
        String nullString = null;
        nullString.length();
    }
}
