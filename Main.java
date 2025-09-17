/**
 * 主程序类，包含主入口和用户交互界面
 */
import java.util.Scanner;

public class Main {
    private static StudentManagementSystem sms = new StudentManagementSystem();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 主方法，程序入口
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("=== 学生管理系统 ===");
        // 预先添加一些示例数据
        addSampleData();
        
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    findStudentById();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    sms.displayAllStudents();
                    break;
                case 6:
                    exit = true;
                    System.out.println("感谢使用学生管理系统，再见！");
                    break;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
        scanner.close();
    }

    /**
     * 显示菜单
     */
    private static void showMenu() {
        System.out.println("\n请选择操作：");
        System.out.println("1. 添加学生");
        System.out.println("2. 删除学生");
        System.out.println("3. 根据ID查找学生");
        System.out.println("4. 更新学生信息");
        System.out.println("5. 显示所有学生");
        System.out.println("6. 退出系统");
        System.out.print("请输入选项 (1-6): ");
    }

    /**
     * 获取用户选择
     * @return 用户选择的选项
     */
    private static int getUserChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // 消费换行符
        } catch (Exception e) {
            scanner.nextLine(); // 清除无效输入
        }
        return choice;
    }

    /**
     * 添加学生
     */
    private static void addStudent() {
        System.out.println("\n=== 添加学生 ===");
        System.out.print("请输入学生ID: ");
        String id = scanner.nextLine();
        System.out.print("请输入学生姓名: ");
        String name = scanner.nextLine();
        System.out.print("请输入学生年龄: ");
        int age = 0;
        try {
            age = scanner.nextInt();
            scanner.nextLine(); // 消费换行符
        } catch (Exception e) {
            System.out.println("年龄输入错误，默认设置为0");
            scanner.nextLine(); // 清除无效输入
        }
        System.out.print("请输入学生专业: ");
        String major = scanner.nextLine();
        
        Student student = new Student(id, name, age, major);
        sms.addStudent(student);
    }

    /**
     * 删除学生
     */
    private static void deleteStudent() {
        System.out.println("\n=== 删除学生 ===");
        System.out.print("请输入要删除的学生ID: ");
        String id = scanner.nextLine();
        sms.deleteStudentById(id);
    }

    /**
     * 根据ID查找学生
     */
    private static void findStudentById() {
        System.out.println("\n=== 根据ID查找学生 ===");
        System.out.print("请输入学生ID: ");
        String id = scanner.nextLine();
        Student student = sms.findStudentById(id);
        if (student != null) {
            System.out.println("找到学生：" + student);
        } else {
            System.out.println("未找到ID为 " + id + " 的学生");
        }
    }

    /**
     * 更新学生信息
     */
    private static void updateStudent() {
        System.out.println("\n=== 更新学生信息 ===");
        System.out.print("请输入要更新的学生ID: ");
        String id = scanner.nextLine();
        
        Student existingStudent = sms.findStudentById(id);
        if (existingStudent == null) {
            System.out.println("未找到ID为 " + id + " 的学生");
            return;
        }
        
        System.out.println("当前学生信息：" + existingStudent);
        System.out.print("请输入新的学生姓名 (留空保持不变): ");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            name = existingStudent.getName();
        }
        
        System.out.print("请输入新的学生年龄 (输入0保持不变): ");
        int age = 0;
        try {
            age = scanner.nextInt();
            scanner.nextLine(); // 消费换行符
        } catch (Exception e) {
            System.out.println("年龄输入错误，保持原值");
            age = existingStudent.getAge();
            scanner.nextLine(); // 清除无效输入
        }
        if (age == 0) {
            age = existingStudent.getAge();
        }
        
        System.out.print("请输入新的学生专业 (留空保持不变): ");
        String major = scanner.nextLine();
        if (major.isEmpty()) {
            major = existingStudent.getMajor();
        }
        
        Student updatedStudent = new Student(id, name, age, major);
        sms.updateStudent(updatedStudent);
    }

    /**
     * 添加示例数据
     */
    private static void addSampleData() {
        sms.addStudent(new Student("001", "张三", 20, "计算机科学"));
        sms.addStudent(new Student("002", "李四", 21, "软件工程"));
        sms.addStudent(new Student("003", "王五", 19, "数据科学"));
    }
}