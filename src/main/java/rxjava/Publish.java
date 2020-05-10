package rxjava;

import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class Publish {
	public static void main(String[] args) throws InterruptedException {
		PublishSubject<String> subject = PublishSubject.create();
		var source = subject.observeOn(Schedulers.computation());
		source.subscribe(e -> { System.out.println("S1 " + e + " " + Thread.currentThread().getName()); });
		source.subscribe(e -> { System.out.println("S2 " + e + " " + Thread.currentThread().getName()); });
		source.subscribe(e -> { System.out.println("S3 " + e + " " + Thread.currentThread().getName()); });
		source.subscribe(e -> { System.out.println("S4 " + e + " " + Thread.currentThread().getName()); });
		source.subscribe(e -> { 
			Thread.sleep(500);
			System.out.println("S5 " + e + " " + Thread.currentThread().getName()); 
		});
		source.subscribe(e -> { System.out.println("S6 " + e + " " + Thread.currentThread().getName()); });
		source.subscribe(e -> { System.out.println("S7 " + e + " " + Thread.currentThread().getName()); });
		source.subscribe(e -> { System.out.println("S8 " + e + " " + Thread.currentThread().getName()); });
		source.subscribe(e -> { System.out.println("S9 " + e + " " + Thread.currentThread().getName()); });
		
		subject.onNext("Hello");
		subject.onNext("world");
		subject.onComplete();
		
		Thread.sleep(2000);
	}
}
