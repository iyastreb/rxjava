package rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Oper {

	public static void main(String[] args) throws Exception {
		var s1 = Observable.just(1, 2, 3, 4, 5);
		Single<Long> c = s1.count();
		System.out.println(c.blockingGet());
		Maybe<Integer> sum = s1.filter(e -> e % 2 == 1).reduce((x, y) -> x + y);
		System.out.println(sum.blockingGet());
		Single<Boolean> contains = s1.contains(5);
		System.out.println(contains.blockingGet());
		
		Single<Boolean> all = s1.all(e -> e < 5);
		System.out.println(all.blockingGet());
		
		var m = s1.toMap(e -> e, e -> 2 * e);
		System.out.println(m.blockingGet());
		
		var source = Observable.interval(1, TimeUnit.SECONDS);
		source.subscribe(System.out::println);

		Observable<String> source2 = source
				.scan((x, y) -> x + y)
				.take(5)
				.map(e -> "number " + e)
				.doOnNext(e -> System.out.println("Logging: " + e));
		source2.subscribe(System.out::println);
		
        source.scan(0, (total, next) -> total + 1)
        	.skip(1)
        	.subscribe(s -> System.out.println("Total number of items so far: " + s));

		Thread.sleep(15000);
	}

}
