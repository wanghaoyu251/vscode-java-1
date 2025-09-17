/**
 * 学生类，用于表示学生的基本信息
 */
public class Student {
    private String id;       // 学生ID
    private String name;     // 学生姓名
    private int age;         // 学生年龄
    private String major;    // 专业

    /**
     * 无参构造方法
     */
    public Student() {
    }

    /**
     * 有参构造方法
     * @param id 学生ID
     * @param name 学生姓名
     * @param age 学生年龄
     * @param major 专业
     */
    public Student(String id, String name, int age, String major) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    // getter和setter方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 重写toString方法，用于输出学生信息
     * @return 学生信息字符串
     */
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }
}