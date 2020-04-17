package rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class HotObserver {

	public static void main(String[] args) throws Exception {
		var source = Observable.interval(100, TimeUnit.MILLISECONDS).publish();
		source.connect();
		
		Thread.sleep(1000);		
		source.subscribe(System.out::println);
		System.out.println("subscribed");
		Thread.sleep(1000);
		source.subscribe(System.out::println);
		System.out.println("subscribed");
		Thread.sleep(1000);
		System.out.println("finished");
	}

}
