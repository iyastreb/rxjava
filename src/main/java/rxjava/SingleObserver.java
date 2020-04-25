package rxjava;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;

public class SingleObserver {

	public static void main(String[] args) throws Exception {
		Observable<String> source = Observable.empty();
		Maybe<String> m = source.firstElement();
		
		m.subscribe(System.out::println,
				    e -> e.printStackTrace(),
				    () -> System.out.println("Done"));
		
		Completable comp = Completable.fromRunnable(() -> {
			System.out.println("Starting" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
			}
			System.out.println("Finish" + Thread.currentThread().getName());
		});
		comp.subscribe(() -> System.out.println("Done!!"));
		
		System.out.println("1" + Thread.currentThread().getName());
		Thread.sleep(500);
		System.out.println("2" + Thread.currentThread().getName());
		Thread.sleep(500);
		System.out.println("3" + Thread.currentThread().getName());
		Thread.sleep(500);
	}

}
