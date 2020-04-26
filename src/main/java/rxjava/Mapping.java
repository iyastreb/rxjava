package rxjava;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Mapping {

	public static void main(String[] args) throws Exception {
	    Observable.just("a", "b", "c", "d", "e", "f")
	            .flatMap( s -> {
	                final int delay = new Random().nextInt(300);
	                return Observable.just(s + " - " + Thread.currentThread().getName())
	                        .delay(delay, TimeUnit.MILLISECONDS);
	            })
	            .subscribe(System.out::println);
	    Thread.sleep(3000);
	    
	    System.out.println("Starting");
	    var s1 = Observable.just(1, 2, 3);
	    var s2 = Observable.interval(500, TimeUnit.MILLISECONDS);
	    Observable.zip(s1, s2, (numbers, timer) -> numbers)
	    	.subscribe(System.out::println);
	    Thread.sleep(3000);
	    
	    System.out.println("Starting");
	    Observable.combineLatest(s1, s2, (numbers, timer) -> numbers)
    		.subscribe(System.out::println);
	    Thread.sleep(3000);
	}

}
