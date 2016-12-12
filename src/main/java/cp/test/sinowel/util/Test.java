package cp.test.sinowel.util;

/**
 * Description:
 *
 * @author: jhc
 * @create: 2016/11/30
 * @version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(Test.class.getName());
        try {
            String s = "8p";
            Integer i = Integer.parseInt(s);
            System.out.println(i);

//            String s2 = null;
//            System.out.println(s2.trim());
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println(e);
//            StackTraceElement[] trace = e.getStackTrace();
//            for (StackTraceElement traceElement : trace)
//                System.out.println("\tat " + traceElement);
        }
    }
}
