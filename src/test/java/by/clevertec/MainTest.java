package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    private static List<Animal> animals;
    private static List<Student> students;

    @BeforeAll
    public static void setup() {
        animals = List.of(
                new Animal(2, "Antelope, roan", 29, "Spanish", "Male"),
                new Animal(3, "Tern, arctic", 28, "Oriya", "Male"),
                new Animal(4, "White-throated toucan", 18, "Tswana", "Female"),
                new Animal(5, "Legaan, Monitor (unidentified)", 15, "Guaraní", "Male"),
                new Animal(6, "Javan gold-spotted mongoose", 33, "Kurdish", "Male"),
                new Animal(7, "Southern boubou", 45, "Sotho", "Female"),
                new Animal(8, "Starling, red-shouldered glossy", 17, "Pashto", "Male"),
                new Animal(59, "Huron", 49, "Japanese", "Female"),
                new Animal(10, "Huron", 46, "Ndebele", "Female"),
                new Animal(11, "House sparrow", 34, "Azeri", "Male"),
                new Animal(12, "Oystercatcher, blackish", 45, "Hungarian", "Male"),
                new Animal(13, "Baboon, chacma", 43, "Fijian", "Male"),
                new Animal(14, "Stork, woolly-necked", 37, "Kurdish", "Male"),
                new Animal(15, "Little cormorant", 32, "Lao", "Female"),
                new Animal(16, "Ovenbird", 25, "Malay", "Female"),
                new Animal(17, "Cook's tree boa", 9, "Bengali", "Male"),
                new Animal(18, "Heron, little", 10, "Gujarati", "Male"),
                new Animal(19, "Mudskipper (unidentified)", 25, "Hungarian", "Female"),
                new Animal(81, "Lorikeet, scaly-breasted", 40, "Japanese", "Male"),
                new Animal(20, "Sandpiper, spotted wood", 45, "Kazakh", "Male"),
                new Animal(21, "Barasingha deer", 34, "Aymara", "Genderfluid"),
                new Animal(22, "African darter", 37, "Malagasy", "Male")
        );

        students = List.of(
                new Student(18, "Adams", 17, "ComputerScience", "C-1"),
                new Student(19, "Carter", 19, "Mathematics", "M-2"),
                new Student(20, "Williams", 20, "ComputerScience", "C-1"),
                new Student(21, "Jonson", 18, "Physics", "P-1"),
                new Student(22, "Smith", 17, "ComputerScience", "C-1"),
                new Student(23, "Adams", 20, "Mathematics", "M-3"));
    }

    @Test
    public void testTask1() {
        List<Animal> expected = List.of();
        System.out.println("---");

        List<Animal> result = Main.task1(animals);
        assertEquals(expected, result);
    }

    @Test
    public void testTask2() {
        List<String> expected = List.of("HURON", "Lorikeet, scaly-breasted");
        List<String> result = Main.task2(animals);
        assertEquals(expected, result);
    }

    @Test
    public void testTask3() {
        List<String> expected = List.of("Azeri", "Aymara");
        List<String> result = Main.task3(animals);
        assertEquals(expected, result);
    }

    @Test
    public void testTask4() {
        long expected = 7;
        long result = Main.task4(animals);
        assertEquals(expected, result);
    }

    @Test
    public void testTask10() {
        int expected = 696;
        int result = Main.task10(animals);
        assertEquals(expected, result);
    }

    @Test
    public void testTask14() {

    }

    @Test
    public void testTask15() {

    }

    @Test
    public void testTask16() {
        List<Student> result = Main.task16(students);

        assertEquals(2, result.size());
        assertEquals("Adams", result.get(0).getSurname());
        assertEquals("Smith", result.get(1).getSurname());
    }

    @Test
    public void testTask17() {
        List<String> result = Main.task17(students);

        assertEquals(4, result.size());
    }

    @Test
    public void testTask21() {
        Map<String, Long> result = Main.task21(students);

        assertEquals(3, result.get("C-1"));
        assertEquals(1, result.get("P-1"));
        assertEquals(1, result.get("M-2"));
        assertEquals(1, result.get("M-3"));
    }

    @Test
    public void testTask22() {
        Map<String, Integer> result = Main.task22(students);

        assertEquals(17, result.get("ComputerScience"));
        assertEquals(18, result.get("Physics"));
        assertEquals(19, result.get("Mathematics"));
    }
}