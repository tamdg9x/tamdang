import java.util.Map;

public class Global {
    public static ThreadLocal<Map<String,Object>> testContext = new ThreadLocal<>();
}
