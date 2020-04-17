package rxjava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class RxCreate {

	public static void main(String[] args) throws Exception {
		Observable<String> source1 = Observable.just("1", "2", "3");
		source1.subscribe(System.out::println);

		List<String> list = new ArrayList<>();
		list.add("11");
		list.add("12");
		list.add("13");
		
		Observable<String> source2 = Observable.fromIterable(list);
		source2.subscribe(System.out::println);
		list.add("44");
		
		var source3 = Observable.interval(1, TimeUnit.SECONDS);
		source3.subscribe(System.out::println);
		Thread.sleep(10000);
	}

}
