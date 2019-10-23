import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
        public static void main(String[] var0) {
            ExecutorService var1 = Executors.newCachedThreadPool();
            try {
            for (int i = 0; i < var0.length ; i++){
                var1.execute(new ManipuladorArquivo(var0[i]));
                }
            } catch (Exception var) {
                var.printStackTrace();
            }
            var1.shutdown();
        }

}

