package rxjava;

public class CallbackString implements Runnable {
	protected final String message;
	
	CallbackString(String message) {
		this.message = message;
	}
	
	void finished() {
		System.out.println(String.format("Callback %s done", message));
	}
	
	@Override
	public void run() {
		System.out.println(String.format("Callback %s start", message));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finished();		
	}
	
    public static void main(String[] args) throws Exception {
    	System.out.println("Main thread start");
    	Thread t = new Thread(new CallbackString("hello") {
			@Override
			void finished() {
				System.out.println(String.format("Callback %s progress", message));
			}
    	});
    	t.start();
    	t.join();
    	System.out.println("Main thread end");
    }
}
