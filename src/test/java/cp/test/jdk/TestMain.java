package cp.test.jdk;

/**
 * Description:
 *
 * @author: jhc
 * @create: 2017/5/9
 * @version: 1.0
 */
public class TestMain {

    public static void main(String[] args) {
        TestMain tm = new TestMain();
        System.out.println(tm.a());
        System.out.println(tm.b());
        System.out.println(tm.c());
    }

    int[][] a() {
        return new int[0][];
    }

    int[] b()[] {
        return new int[0][];
    }

    int c()[][] {
        return new int[0][];
    }
}
