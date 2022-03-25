public class LoggerTest {
    public static void main(String[] args) {
        MyLogger myLogger = MyLogger.getInstance(); // 싱글톤 패턴의 객체 생성
        myLogger.log("test log");

        // 결과
        // 3월 25, 2022 10:38:47 오후 MyLogger log
        // 정보: test log
        // 3월 25, 2022 10:38:47 오후 MyLogger log
        // 경고: test log
        // 3월 25, 2022 10:38:47 오후 MyLogger log
        // 심각: test log
    }
}
