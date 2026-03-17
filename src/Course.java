public class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // TODO: Task 4 — Обязательно переопредели (иначе HashMap не будет работать!)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        // 2. Проверка на null и соответствие классов
        if (o == null || getClass() != o.getClass()) return false;

        // 3. Приведение типа и сравнение значимых полей
        Course course = (Course) o;
        return java.util.Objects.equals(name, course.name);// заглушка
    }

    @Override
    public int hashCode() {


        return java.util.Objects.hash(name);
        // заглушка
    }

    @Override
    public String toString() {
        return "Course: " + name;
    }
}
