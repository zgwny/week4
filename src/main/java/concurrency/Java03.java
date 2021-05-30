package concurrency;

public class Java03 extends Thread {
	
	public static long start = 0;

	public static void main(String[] args) {

		 start = System.currentTimeMillis();

		// 在这里创建一个线程或线程池，
		// 异步执行 下面方法
		
		Java03 java03 = new Java03();
		java03.start();
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
	
	@Override
    public void run(){
        super.run();
        int result = sum(); // 这是得到的返回值

		// 确保 拿到result 并输出
		System.out.println("异步计算结果为：" + result);

		System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}
