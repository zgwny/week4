package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Java05 implements Callable {
	
	public static long start = 0;

	public static void main(String[] args) {
		start = System.currentTimeMillis();
		// 在这里创建一个线程或线程池，
		// 异步执行 下面方法
		Java05 callable = new Java05();
		FutureTask task = new FutureTask(callable);
		new Thread(task).start();

		// 然后退出main线程
	}

	private static int sum() {
		return fibo(36);
	}

	private static int fibo(int a) {
		if (a < 2)
			return 1;
		return fibo(a - 1) + fibo(a - 2);
	}
	
	public Object call() throws Exception {
		int result = sum(); // 这是得到的返回值

		// 确保 拿到result 并输出
		System.out.println("异步计算结果为：" + result);
		System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
		return 0;
    }
}

