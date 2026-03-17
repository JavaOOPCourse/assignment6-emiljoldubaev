import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        // TODO: Добавь минимум 5 студентов (ключ = ID)
        // Сделай минимум два студента с одинаковым GPA (для Task 3)
        students.put("12a", new Student("emil", 4.00, 17));
        students.put("12b", new Student("dude", 3.5, 19));
        students.put("12dc", new Student("yoo", 2.00, 20));
        students.put("12e", new Student("bakyt", 4.00, 23));
        students.put("12f", new Student("peri", 3.23, 18));

        // TODO: Напечатай всех студентов (ID + объект)
        for(Map.Entry<String, Student> entry : students.entrySet()){
            System.out.println("ID: " + entry.getKey() + "------>" + entry.getValue());
        }

        // TODO: Найди студента по ID и выведи его
        System.out.println("Found 12a: " + students.get("12a"));

        // TODO: Удали одного студента по ID
        students.remove("12dc");

        // TODO: Обнови GPA у одного студента
        if (students.containsKey("12b")) {
            students.get("12b").setGpa(3.9);
        }

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        List<Student> ss = new ArrayList<>(students.values());

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        ss.sort(null);
        System.out.println("\n--- Sorted by GPA (Natural) ---");
        for (Student s : ss) System.out.println(s);

        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        ss.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        System.out.println("\n--- Sorted by Name ---");
        for (Student s : ss) System.out.println(s);

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        List<Student> newList = new ArrayList<>(students.values());
        newList.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));

        for (int i = 0; i < Math.min(3, newList.size()); i++) {
            System.out.println((i + 1) + ". " + newList.get(i));
        }

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        Map<Double, List<Student>> gpaGroups = new HashMap<>();
        for (Student s : students.values()) {
            double gpa = s.getGpa();
            if (!gpaGroups.containsKey(gpa)) {
                gpaGroups.put(gpa, new ArrayList<>());
            }
            gpaGroups.get(gpa).add(s);
        }

        for (Map.Entry<Double, List<Student>> entry : gpaGroups.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("GPA " + entry.getKey() + ": " + entry.getValue());
            }
        }

        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        courseMap.put(new Course("Linear Algebra"), new ArrayList<>(students.values()));
        courseMap.put(new Course("Machine Learning"), newList);

        for (Map.Entry<Course, List<Student>> entry : courseMap.entrySet()) {
            System.out.println(entry.getKey() + "\n Students: " + entry.getValue());
        }

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        class GpaNameComparator implements Comparator<Student> {
            @Override
            public int compare(Student s1, Student s2) {
                int res = Double.compare(s2.getGpa(), s1.getGpa());
                if (res == 0) {
                    return s1.getName().compareTo(s2.getName());
                }
                return res;
            }
        }
        ss.sort(new GpaNameComparator());
        for (Student s : ss) System.out.println(s);
    }
}
