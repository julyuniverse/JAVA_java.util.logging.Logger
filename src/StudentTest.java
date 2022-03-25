public class StudentTest {
    public static void main(String[] args) {
        MyLogger myLogger = MyLogger.getInstance(); // 싱글톤 패턴의 객체 생성

        String name = null;

        try {
            Student student = new Student(name);
        }catch (StudentNameFormatException e) {
            myLogger.warning(e.getMessage());
        }

        try {
            Student student = new Student("이 태 성 입 니 다");
        }catch (StudentNameFormatException e) {
            myLogger.warning(e.getMessage());
        }

        Student student = null;
        try {
            student = new Student("이정민");
        } catch (StudentNameFormatException e) {
            e.printStackTrace();
        }

        System.out.println(student.getStudentName());

        // 결과
        // 3월 25, 2022 10:39:07 오후 MyLogger warning
        // 경고: 이름이 비었습니다.
        // 3월 25, 2022 10:39:07 오후 MyLogger warning
        // 경고: 이름이 너무 길어요.
        // 이정민
    }
}
