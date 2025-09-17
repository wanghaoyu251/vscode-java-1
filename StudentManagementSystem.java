/**
 * 学生管理系统类，用于管理学生信息
 */
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students; // 存储学生列表

    /**
     * 构造方法，初始化学生列表
     */
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    /**
     * 添加学生
     * @param student 要添加的学生对象
     * @return 添加是否成功
     */
    public boolean add_Student(Student student) {
        // 检查学生ID是否已存在
        for (Student s : students) {
            if (s.getId().equals(student.getId())) {
                System.out.println("添加失败：学生ID " + student.getId() + " 已存在");
                return false;
            }
        }
        students.add(student);
        System.out.println("添加学生成功：" + student.getName());
        return true;
    }

    /**
     * 根据ID删除学生
     * @param id 要删除学生的ID
     * @return 删除是否成功
     */
    public boolean deleteStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                System.out.println("删除学生成功：" + student.getName());
                return true;
            }
        }
        System.out.println("删除失败：未找到ID为 " + id + " 的学生");
        return false;
    }

    /**
     * 根据ID查找学生
     * @param id 要查找学生的ID
     * @return 找到的学生对象，未找到则返回null
     */
    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    /**
     * 根据姓名查找学生
     * @param name 要查找学生的姓名
     * @return 找到的学生列表
     */
    public List<Student> findStudentsByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equals(name)) {
                result.add(student);
            }
        }
        return result;
    }

    /**
     * 更新学生信息
     * @param updatedStudent 更新后的学生对象
     * @return 更新是否成功
     */
    public boolean updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId().equals(updatedStudent.getId())) {
                students.set(i, updatedStudent);
                System.out.println("更新学生成功：" + updatedStudent.getName());
                return true;
            }
        }
        System.out.println("更新失败：未找到ID为 " + updatedStudent.getId() + " 的学生");
        return false;
    }

    /**
     * 获取所有学生
     * @return 学生列表
     */
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    /**
     * 显示所有学生信息
     */
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("当前没有学生信息");
        } else {
            System.out.println("\n=== 所有学生信息 ===");
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println("==================\n");
        }
    }
}