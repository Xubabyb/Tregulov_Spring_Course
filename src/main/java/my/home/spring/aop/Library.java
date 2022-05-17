package my.home.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Library {

    public void getBook() {
        System.out.println("Мы берем книгу: ");
        System.out.println("__________________________________");
    }

    public String returnBook() {
        //int a = 10 / 0; //TODO для выбрасывания исключения
        System.out.println("Мы возвращаем книгу в библиотеку");
        return "Война и Мир";
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал");
        System.out.println("__________________________________");
    }

    public void returnMagazine() {
        System.out.println("Мы возвращаем журнал в библиотеку");
        System.out.println("__________________________________");
    }

    public void addBook(String person_name, Book book) {
        System.out.println(person_name + " добавляет книгу \"" + book.getName() + "\" в библиотеку ");
        System.out.println("__________________________________");
    }

    public void addMagazine() {
        System.out.println("Мы добавляем журнал в библиотеку ");
        System.out.println("__________________________________");
    }
}
