import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// 싱글톤 패턴으로 객체 구현
public class MyLogger {
    // 클래스 내부에 유일한 private 인스턴스 생성
    private static MyLogger instance = new MyLogger();

    // 멤버 변수
    Logger logger = Logger.getLogger("mylogger");
    public static final String errorLog = "log.txt"; // 최상단 루트에 생성됨.
    public static final String warningLog = "warning.txt"; // 최상단 루트에 생성됨.
    public static final String fineLog = "fineLog.txt"; // 최상단 루트에 생성됨.
    private FileHandler logFile = null;
    private FileHandler warningFile = null;
    private FileHandler fineFile = null;

    // 생성자
    // 싱글톤 패턴에서 생성자는 private 으로 선언
    private MyLogger() {
        try {
            logFile = new FileHandler(errorLog, true);
            warningFile = new FileHandler(warningLog, true);
            fineFile = new FileHandler(fineLog, true);
        } catch (SecurityException e) { // 보안 관리자에 LoggingPermission이 없으면 SecurityException이 발생하고 패턴이 빈 문자열이면 IllegalArgumentException이 발생
            e.printStackTrace();
        } catch (IOException e) { // 컴파일러가 파일을 여는 데 문제가 발생하면 생성자가 IOException을 throw
            e.printStackTrace();
        }

        SimpleFormatter simpleFormatter = new SimpleFormatter(); // logging.SimpleFormatter.format 속성을 사용하여 로그를 자동 포맷하는 권한을 허용. 이 속성을 사용하면 로그 메시지가 정의된 형식으로 되어 균일성을 유지할 수 있다.
        logFile.setFormatter(simpleFormatter);
        warningFile.setFormatter(new SimpleFormatter());
        fineFile.setFormatter(new SimpleFormatter());

        logger.setLevel(Level.ALL);
        fineFile.setLevel(Level.FINE);
        warningFile.setLevel(Level.WARNING);

        logger.addHandler(logFile);
        logger.addHandler(warningFile);
        logger.addHandler(fineFile);
    }

    // 싱글톤 패턴에서는 외부에서 유일한 인스턴스를 참조할 수 있는 public 메서드 제공
    public static MyLogger getInstance() {
        if (instance == null) {
            instance = new MyLogger();
        }

        return instance;
    }

    public void log(String msg) {
        logger.finest(msg);
        logger.finer(msg);
        logger.fine(msg);
        logger.config(msg);
        logger.info(msg);
        logger.warning(msg);
        logger.severe(msg);
    }

    public void fine(String msg) {
        logger.fine(msg); // fine은 fine 레벨 이상
    }

    public void warning(String msg) {
        logger.warning(msg); // warning은 warning 레벨 이상
    }
}
