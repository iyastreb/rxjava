package rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Zipping {

	public static void main(String[] args) {
		var s1 = Observable.just("Subject").delay(20, TimeUnit.MILLISECONDS);
		var s2 = Observable.just("Adj").delay(40, TimeUnit.MILLISECONDS);
		var s3 = Observable.just("Noun").delay(50, TimeUnit.MILLISECONDS);

		long start = System.currentTimeMillis();
		var sentence = Observable.zip(s1, s2, s3, (e1, e2, e3) -> 
				String.format("%s %s %s", e1, e2, e3))
			.blockingFirst();
		System.out.println(sentence);
		System.out.println(System.currentTimeMillis() - start);
	}

}
