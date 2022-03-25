public class Student {
    // 멤버 변수
    private String studentName;
    MyLogger myLogger = MyLogger.getInstance(); // 싱글턴 패턴의 객체 생성

    // 생성자
    public Student(String studentName) throws StudentNameFormatException { // StudentNameFormatException 클래스는 프로그래머가 직접 만든 예외 처리. 즉, 사용자 정의 예외 처리 클래스.
        if(studentName == null) {
            throw new StudentNameFormatException("이름이 비었습니다.");
        }else if(studentName.split(" ").length > 3) {
            throw new StudentNameFormatException("이름이 너무 길어요.");
        }

        this.studentName = studentName;
    }

    public String getStudentName() {
        myLogger.fine("begin getStudentName()"); // 로그 기록

        return studentName;
    }
}
