package rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Merge {

	public static void main(String[] args) throws Exception {
		var source1 = Observable.interval(300, TimeUnit.MILLISECONDS);
		var source2 = Observable.just("Ilia", "Sasha", "Maxim")
				.delay(1, TimeUnit.SECONDS)
				.doOnNext(e -> Thread.sleep(300));
		var source = Observable.merge(source1, source2);
		Disposable d = source
				.subscribe(e -> System.out.println("" + e + ", thread:" + Thread.currentThread().getName()));
		Thread.sleep(3000);
		d.dispose();

		source = Observable.concat(source1.take(5), source2);
		d = source.subscribe(e -> System.out.println("" + e + ", thread:" + Thread.currentThread().getName()));
		Thread.sleep(5000);
		d.dispose();
	}

}
