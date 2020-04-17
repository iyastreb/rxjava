package rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class RxHello {

	public static void main(String[] args) {
		Observable<String> source = Observable.create(
				e -> {
					e.onNext("Hello");
					e.onNext("RxJava");
					e.onComplete();
				}
		);
		Observer<String> observer = new Observer<String>() {
			@Override
			public void onSubscribe(@NonNull Disposable d) {
				System.out.println("Subscribed");
			}

			@Override
			public void onNext(@NonNull String t) {
				System.out.println("Got data: " + t);
			}

			@Override
			public void onError(@NonNull Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Completed");
			}
		};
		
		source.subscribe(observer);
	}
}
