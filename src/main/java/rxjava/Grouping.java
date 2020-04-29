package rxjava;

import io.reactivex.rxjava3.core.Observable;

public class Grouping {
	public static class Person {
		private String name;
		private int salary;
		
		public Person(String name, int salary) {
			this.name = name;
			this.salary = salary;
		}
		
		public String getName() {
			return name;
		}
		public int getSalary() {
			return salary;
		}
		public String toString() {
			return String.format("{%s, %d}", name, salary);
		}
	}

	public static void main(String[] args) {
		var source = Observable.just(new Person("Ilia", 175),
									 new Person("Maxim", 175),
									 new Person("Sasha", 120),
									 new Person("Natalia", 120));
		source.groupBy(e -> e.getSalary())
			  .flatMapSingle(e -> e.toMultimap(person -> person.getSalary()))
			  .subscribe(System.out::println);
		
        Observable<String> mySource = Observable.just("a", "bb", "cc", "d", "eee");
        mySource.groupBy(s -> s.length())
                .flatMapSingle(group -> group.reduce("", (x,y) -> "".equals(x) ? y : x + ", " + y)
                                             .map(e -> group.getKey() + ": " + e))
                .subscribe(System.out::println);
	}

}
