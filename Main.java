import info.zpss.SimpleHttpServer.Arguable;
import info.zpss.SimpleHttpServer.SimpleHttpServer;

public class Main implements Arguable {
    public static final String VERSION = "1.0.0";
    public static void main(String[] args) {
        new Main().init(args);
        new Thread(() -> {
            SimpleHttpServer httpServer = SimpleHttpServer.getInstance();
            httpServer.init(args);
            httpServer.start();
        }).start();
    }

    @Override
    public void init(String[] args) {
        if (Arguable.paramInArgs(args, "-h", "--help")) {
            System.out.println("Usage: java -jar SimpleHttpServer.jar [options]");
            System.out.println("Options:");
            System.out.println("  -h, --help\t\t\tShow this help message and exit");
            System.out.println("  -v, --version\t\t\tShow version info and exit");
            System.out.println("  -H, --host <host>\t\tSpecify the server host like \"http://example.com\"");
            System.out.println("  -P, --port <port>\t\tSpecify the port to listen on");
            System.out.println("  -d, --dir <dir>\t\tSpecify the root directory");
            System.out.println("  -a, --absolute-dir <dir>\tSpecify the absolute root directory");
            System.exit(0);
        }
        if (Arguable.paramInArgs(args, "-v", "--version")) {
            System.out.printf("SimpleHttpServer v%s%n", VERSION);
            System.exit(0);
        }
        String dir = Arguable.stringInArgs(args, "-d", "--dir");
        if (dir != null) {
            System.out.println("Root directory: " + dir);
            SimpleHttpServer.getInstance().setRootDir(dir);
        }
        String absDir = Arguable.stringInArgs(args, "-a", "--absolute-dir");
        if (absDir != null) {
            System.out.println("Absolute root directory: " + absDir);
            SimpleHttpServer.getInstance().setAbsoluteRootDir(absDir);
        }
    }
}