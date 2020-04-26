package rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Disp {
	
	public static void main(String[] args) throws Exception {
		var source = Observable.interval(1, TimeUnit.SECONDS);
		source.subscribe(System.out::println);
		Disposable sub = source.subscribe(System.out::println);
		Thread.sleep(3000);
		sub.dispose();
		Thread.sleep(3000);		
	}

}
