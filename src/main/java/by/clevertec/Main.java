package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        List<Animal> animals = Util.getAnimals();
        task1(animals);
        task2(animals);
        task3(animals);
        task4(animals);
        task5();
        task6();
        task7();
        task8();
        task9();
        task10(animals);
        task11();
        task12();
        task13();
        List<Car> cars = Util.getCars();
        task14(cars);
        List<Flower> flowers = Util.getFlowers();
        task15(flowers);
        List<Student> students = Util.getStudents();
        task16(students);
        task17(students);
        task18();
        task19();
        task20();
        task21(students);
        task22(students);
    }

    /**
     * Задача №1
     * Из представленных животных отобрать все молодые особи от 10 до 20 лет и отсортировать по возрасту (по возрастанию)
     * далее - распределить по 7 на каждый зоопарк.
     * Зоопарков неограниченное кол-во, а вы - директор 3-го по счёту зоопарка. Полученных животных вывести в консоль.
     */
    public static List<Animal> task1(List<Animal> animals) {
        System.out.println("----------");
        System.out.println("Задача №1");

        int minAge = 10;
        int maxAge = 20;

        List<Animal> thirdZoo = animals.stream()
                .filter(animal -> animal.getAge() >= minAge && animal.getAge() <= maxAge)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list ->
                        list.stream()
                                .skip(14)
                                .limit(7)
                                .toList()
                ));

        thirdZoo.forEach(System.out::println);

        return thirdZoo;
    }

    /**
     * Задача №2
     * <p>
     * Отобрать всех животных из Японии (Japanese) и записать породу в UPPER_CASE, если пол Female,
     * преобразовать к строкам породы животных и вывести в консоль
     */
    public static List<String> task2(List<Animal> animals) {
        System.out.println("----------");
        System.out.println("Задача №2");

        List<String> sortedJapaneseFemaleAnimals = animals.stream()
                .filter(animal -> "Japanese".equals(animal.getOrigin()))
                .map(animal -> "Female".equals(animal.getGender()) ? animal.getBread().toUpperCase() : animal.getBread())
                .toList();

        sortedJapaneseFemaleAnimals.forEach(System.out::println);

        return sortedJapaneseFemaleAnimals;
    }

    /**
     * Задача №3
     * <p>
     * Отобрать всех животных старше 30 лет и вывести все страны происхождения без дубликатов начинающиеся на "A"
     */
    public static List<String> task3(List<Animal> animals) {
        System.out.println("----------");
        System.out.println("Задача №3");

        int minAge = 30;

        List<String> distinctCountries = animals.stream()
                .filter(animal -> animal.getAge() > minAge)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .toList();

        distinctCountries.forEach(System.out::println);

        return distinctCountries;
    }

    /**
     * Задача №4
     * <p>
     * Подсчитать количество всех животных пола = Female. Вывести в консоль
     */
    public static long task4(List<Animal> animals) {
        System.out.println("----------");
        System.out.println("Задача №4");

        long countFemaleAnimals = animals.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
        System.out.printf("Количество самок: %d%n", countFemaleAnimals);

        return countFemaleAnimals;
    }

    /**
     * Задача №5
     * <p>
     * Взять всех животных возрастом 20 - 30 лет.
     * Есть ли среди них хоть одно из страны Венгрия (Hungarian)? Ответ вывести в консоль
     */
    public static void task5() {
        System.out.println("----------");
        System.out.println("Задача №5");

        List<Animal> animals = Util.getAnimals();

        int minAge = 20;
        int maxAge = 30;

        boolean hasHungarianAnimal = animals.stream()
                .filter(animal -> animal.getAge() >= minAge && animal.getAge() <= maxAge)
                .anyMatch(animal -> animal.getOrigin().equals("Hungarian"));
        System.out.println("Есть ли среди животных возрастом 20-30 лет, хоть одно из Венгрии (Hungarian)?");
        System.out.println("Ответ: " + (hasHungarianAnimal ? "Да" : "Нет"));
    }

    /**
     * Задача №6
     * <p>
     * Взять всех животных. Все ли они пола Male и Female? Ответ вывести в консоль
     */
    public static void task6() {
        System.out.println("----------");
        System.out.println("Задача №6");

        List<Animal> animals = Util.getAnimals();

        boolean allMaleOrFemale = animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male") || animal.getGender().equals("Female"));
        System.out.println("Все ли животные пола Male и Female?");
        System.out.println("Ответ: " + (allMaleOrFemale ? "Да" : "Нет"));
    }

    /**
     * Задача №7
     * <p>
     * Взять всех животных. Узнать что ни одно из них не имеет страну происхождения Oceania. Ответ вывести в консоль
     */
    public static void task7() {
        System.out.println("----------");
        System.out.println("Задача №7");

        List<Animal> animals = Util.getAnimals();

        boolean noOceaniaAnimal = animals.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
        System.out.println("Ни одно из них не имеет страну происхождения Oceania?");
        System.out.println("Ответ: " + (noOceaniaAnimal ? "Да" : "Нет, имеет"));
    }

    /**
     * Задача №8
     * <p>
     * Взять всех животных. Отсортировать их породу в стандартном порядке и взять первые 100.
     * Вывести в консоль возраст самого старого животного
     */
    public static void task8() {
        System.out.println("----------");
        System.out.println("Задача №8");

        List<Animal> animals = Util.getAnimals();

        Optional<Animal> optionalOldestAnimal = animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .max(Comparator.comparingInt(Animal::getAge));

        if (optionalOldestAnimal.isPresent()) {
            var oldestAnimal = optionalOldestAnimal.get();
            System.out.printf("Возраст самого старого животного: %d%n", oldestAnimal.getAge());
        } else {
            System.out.println("Животных не найдено");
        }
    }

    /**
     * Задача №9
     * <p>
     * Взять всех животных. Преобразовать их в породы, а породы в char[]
     * Вывести в консоль длину самого короткого массива
     */
    public static void task9() {
        System.out.println("----------");
        System.out.println("Задача №9");

        List<Animal> animals = Util.getAnimals();

        OptionalInt minLength = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt(array -> array.length)
                .min();

        if (minLength.isPresent()) {
            System.out.printf("Длина самого короткого массива: %d%n", minLength.getAsInt());
        } else {
            System.out.println("Массивы не найдены.");
        }
    }

    /**
     * Задача №10
     * <p>
     * Взять всех животных. Подсчитать суммарный возраст всех животных. Вывести результат в консоль
     * <p>
     * Сигнатура метода изменена для теста!
     */
    public static int task10(List<Animal> animals) {
        System.out.println("----------");
        System.out.println("Задача №10");

        int totalAge = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();

        System.out.printf("Суммарный возраст всех животных: %d%n", totalAge);

        return totalAge;
    }

    /**
     * Задача №11
     * <p>
     * Взять всех животных. Подсчитать средний возраст всех животных из Индонезии (Indonesian).
     * Вывести результат в консоль
     */
    public static void task11() {
        System.out.println("----------");
        System.out.println("Задача №11");

        List<Animal> animals = Util.getAnimals();

        OptionalDouble avgAgeIndonesianAnimals = animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToInt(Animal::getAge)
                .average();

        if (avgAgeIndonesianAnimals.isPresent()) {
            System.out.printf("Средний возраст всех животных из Индонезии: %.2f%n", avgAgeIndonesianAnimals.getAsDouble());
        } else {
            System.out.println("Животные из Индонезии не найдены.");
        }
    }

    /**
     * Задача №12
     * <p>
     * Во Французский легион принимают людей со всего света, но есть отбор по полу (только мужчины) возраст от 18 до 27 лет.
     * Преимущество отдаётся людям военной категории 1, на втором месте - военная категория 2, и на третьем месте военная категория 3.
     * Отсортировать всех подходящих кандидатов в порядке их приоритета по военной категории.
     * Однако взять на обучение академия может только 200 человек. Вывести их в консоль.
     */
    public static void task12() {
        System.out.println("----------");
        System.out.println("Задача №12");

        List<Person> persons = Util.getPersons();

        LocalDate now = LocalDate.now();
        int minAge = 18;
        int maxAge = 27;

        persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .filter(person -> {
                    int age = Period.between(person.getDateOfBirth(), now).getYears();
                    return age >= minAge && age <= maxAge;
                })
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);
    }

    /**
     * Задача №13
     * <p>
     * Надвигается цунами и в районе эвакуации требуется в первую очередь обойти дома и эвакуировать больных и раненых (из Hospital),
     * во вторую очередь детей и стариков (до 18 и пенсионного возраста) а после всех остальных.
     * В первый этап эвакуации мест в эвакуационном транспорте только 500.
     * Вывести всех людей попадающих в первый этап эвакуации в порядке приоритета в консоль
     */
    public static void task13() {
        System.out.println("----------");
        System.out.println("Задача №13");

        List<House> houses = Util.getHouses();

        LocalDate now = LocalDate.now();
        int underageAge = 18;
        int retirementAge = 65;

        houses.stream()
                .flatMap(house -> {
                    if (house.getBuildingType().equals("Hospital")) {
                        return house.getPersonList().stream();
                    } else {
                        return house.getPersonList().stream()
                                .filter(person -> {
                                    int age = Period.between(person.getDateOfBirth(), now).getYears();
                                    return age < underageAge || age >= retirementAge;
                                });
                    }
                })
                .limit(500)
                .forEach(System.out::println);
    }

    /**
     * Задача №14
     * <p>
     * Из перечня автомобилей приходящих на рынок Азии логистическому агентству предстоит отсортировать их в порядке следования
     * 1. Туркменистан - 2. Узбекистан - 3. Казахстан - 4. Кыргызстан - 5. Россия - 6. Монголия.
     * Все автомобили марки "Jaguar" а так же все авто цвета White идут в первую страну.
     * Из оставшихся все автомобили с массой до 1500 кг и марок BMW, Lexus, Chrysler и Toyota идут во второй эшелон.
     * Из оставшихся все автомобили Черного цвета с массой более 4000 кг и все GMC и Dodge идут в третий эшелон.
     * Из оставшихся все автомобили года выпуска до 1982 или все модели "Civic" и "Cherokee" идут в четвёртый эшелон.
     * Из оставшихся все автомобили цветов НЕ Yellow, Red, Green и Blue или же по стоимости дороже 40000 в пятый эшелон.
     * Из оставшиеся все автомобили в vin номере которых есть цифра "59" идут в последний шестой эшелон.
     * Оставшиеся автомобили отбрасываем, они никуда не идут.
     * Измерить суммарные массы автомобилей всех эшелонов для каждой из стран и подсчитать сколько для каждой страны будет
     * стоить транспортные расходы если учесть что на 1 тонну транспорта будет потрачено 7.14 $.
     * Вывести суммарные стоимости в консоль. Вывести общую выручку логистической кампании.
     * <p>
     * Сигнатура метода изменена для теста!
     */
    public static Double task14(List<Car> cars) {
        System.out.println("----------");
        System.out.println("Задача №14");

        double costPerTon = 7.14;

        Map<String, Double> countryCosts = cars.stream()
                .collect(Collectors.toMap(
                        car -> {
                            if (
                                    car.getCarMake().equals("Jaguar")
                                            || car.getColor().equals("White")
                            ) {
                                return "Туркменистан";
                            } else if (
                                    car.getMass() < 1500
                                            && List.of("BMW", "Lexus", "Chrysler", "Toyota").contains(car.getCarMake())
                            ) {
                                return "Узбекистан";
                            } else if (
                                    (car.getColor().equals("Black")
                                            && car.getMass() > 4000)
                                            || List.of("GMC", "Dodge").contains(car.getCarMake())
                            ) {
                                return "Казахстан";
                            } else if (
                                    car.getReleaseYear() < 1982
                                            || List.of("Civic", "Cherokee").contains(car.getCarModel())
                            ) {
                                return "Кыргызстан";
                            } else if (
                                    !List.of("Yellow", "Red", "Green", "Blue").contains(car.getColor())
                                            || car.getPrice() > 40000
                            ) {
                                return "Россия";
                            } else if (
                                    car.getVin().contains("59")
                            ) {
                                return "Монголия";
                            } else {
                                return "Не отправляется";
                            }
                        },
                        car -> car.getMass() / 1000.0 * costPerTon,
                        Double::sum
                ));

        countryCosts.remove("Не отправляется");
        countryCosts.forEach((country, cost) ->
                System.out.printf("%s: %.2f $%n", country, cost)
        );

        double totalRevenue = countryCosts.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        System.out.printf("Общая выручка логистической кампании: %.2f $%n", totalRevenue);

        return totalRevenue;
    }

    /**
     * Задача №15
     * <p>
     * Для оранжереи нужно подобрать растения соответствующие требованиям.
     * Во-первых, нужно произвести сложную сортировку каталога растений.
     * Отсортировать их по странам происхождения в обратном порядке.
     * После по стоимости и еще по водопотреблению в обратном порядке.
     * Из этого списка взять растения название которых от буквы "S" до буквы "C".
     * Если растения тенелюбивые и им подходит горшок из стекла, алюминия или стали - то выбираем их.
     * Далее на каждое растение надо рассчитать стоимость растения
     * + стоимость потребления воды за 5 лет с учётом того что кубометр воды стоит 1.39 $.
     * Суммировать общую стоимость обслуживания всех растений. Во сколько это обойдётся бюджету?
     * <p>
     * Сигнатура метода изменена для теста!
     */
    public static Double task15(List<Flower> flowers) {
        System.out.println("----------");
        System.out.println("Задача №15");

        List<Flower> sortedFlowers = flowers.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed()
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Comparator.comparing(Flower::getWaterConsumptionPerDay).reversed()))
                .filter(f -> f.getCommonName().compareToIgnoreCase("C") >= 0
                        && f.getCommonName().compareToIgnoreCase("S") <= 0)
                .filter(f -> f.isShadePreferred() && hasSuitableVaseMaterial(f))
                .toList();

        double totalBudget = sortedFlowers.stream()
                .mapToDouble(Main::calculateTotalCost)
                .sum();

        System.out.printf("Общая стоимость обслуживания всех растений: %.2f $%n", totalBudget);

        return totalBudget;
    }

    private static boolean hasSuitableVaseMaterial(Flower flower) {
        List<String> suitableMaterials = Arrays.asList("Glass", "Aluminum", "Steel");
        return flower.getFlowerVaseMaterial().stream()
                .anyMatch(suitableMaterials::contains);
    }

    private static double calculateTotalCost(Flower flower) {
        double waterCostPerYear = flower.getWaterConsumptionPerDay() * 365 * 1.39 / 1000; // цена за кубометр воды
        double waterCostFor5Years = waterCostPerYear * 5;
        return flower.getPrice() + waterCostFor5Years;
    }

    /**
     * Задача №16
     * <p>
     * Вывод списка студентов младше 18 лет в алфавитном порядке с указанием возраста
     * <p>
     * Сигнатура метода изменена для теста!
     */
    public static List<Student> task16(List<Student> students) {
        System.out.println("----------");
        System.out.println("Задача №16");

        List<Student> sortedStudents = students.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .toList();

        sortedStudents.forEach(student ->
                System.out.printf("Фамилия: %s, Возраст: %d%n", student.getSurname(), student.getAge()
                ));

        //в тестовом файле нет студентов подходящих под критерий <18, но проверил в тесте

        return sortedStudents;
    }

    /**
     * Задача №17
     * <p>
     * Вывод списка групп (без повторений).
     * <p>
     * Сигнатура метода изменена для теста!
     */
    public static List<String> task17(List<Student> students) {
        System.out.println("----------");
        System.out.println("Задача №17");

        List<String> groups = students.stream()
                .map(Student::getGroup)
                .distinct()
                .toList();

        groups.forEach(System.out::println);

        return groups;
    }

    /**
     * Задача №18
     * <p>
     * Определение среднего возраста студентов для каждого факультета.
     * Выводить название факультета и средний возраст в порядке убывания возраста.
     */
    public static void task18() {
        System.out.println("----------");
        System.out.println("Задача №18");

        List<Student> students = Util.getStudents();
        students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingInt(Student::getAge)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.printf("Факультет: %s, Средний возраст: %.2f%n", entry.getKey(), entry.getValue())
                );
    }

    /**
     * Задача №19
     * <p>
     * Вывод списка студентов заданной группы, у которых сдан 3 экзамен (>4).
     */
    public static void task19() {
        System.out.println("----------");
        System.out.println("Задача №19");

        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        students.stream()
                .collect(Collectors.groupingBy(Student::getGroup))
                .forEach((group, groupStudents) -> {
                    System.out.println("Группа: " + group);

                    groupStudents.stream()
                            .filter(student -> examinations.stream()
                                    .anyMatch(exam -> exam.getStudentId() == student.getId() && exam.getExam3() > 4))
                            .forEach(System.out::println);

                    System.out.println();
                });
    }

    /**
     * Задача №20
     * <p>
     * Определение факультета с максимальной средней оценкой по первому экзамену.
     */
    public static void task20() {
        System.out.println("----------");
        System.out.println("Задача №20");

        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        String topFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingDouble(student -> examinations.stream()
                                .filter(exam -> exam.getStudentId() == student.getId())
                                .mapToDouble(Examination::getExam1)
                                .average()
                                .orElse(0.0))
                )).entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Не найдено");

        System.out.println("Факультет с максимальной средней оценкой по первому экзамену: " + topFaculty);
    }

    /**
     * Задача №21
     * <p>
     * Определение количества студентов в каждой группе.
     * <p>
     * Сигнатура метода изменена для теста!
     */
    public static Map<String, Long> task21(List<Student> students) {
        System.out.println("----------");
        System.out.println("Задача №21");

        Map<String, Long> countStudentsAtFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroup,
                        Collectors.counting()
                ));

        countStudentsAtFaculty.forEach((group, count) ->
                System.out.println("Группа: " + group + ", Количество студентов: " + count));

        return countStudentsAtFaculty;
    }

    /**
     * Задача №22
     * <p>
     * Определение минимального возраста для каждого факультета.
     * <p>
     * Сигнатура метода изменена для теста!
     */
    public static Map<String, Integer> task22(List<Student> students) {
        System.out.println("----------");
        System.out.println("Задача №22");

        Map<String, Integer> minAgeByFaculty = students.stream()
                .collect(Collectors.toMap(
                        Student::getFaculty,
                        Student::getAge,
                        Integer::min
                ));

        minAgeByFaculty.forEach((faculty, minAge) ->
                System.out.println("Факультет: " + faculty + ", Минимальный возраст: " + minAge));

        return minAgeByFaculty;
    }
}
