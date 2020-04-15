package rxjava;

import java.util.ArrayList;
import java.util.List;

public class ObserverFirst {
	public static interface Observer {
		void update(Book book);
	}
	
	public static class User implements Observer {
		private String name;
		
		public User(String name) {
			this.name = name;
		}

		@Override
		public void update(Book book) {
			System.out.println(String.format(
					"User %s notified that book %s availability: %s", 
					name, book.getName(), Boolean.toString(book.isAvailable())));
		}
	}
	
	public static interface SubjectLibrary {
		void addObserver(Observer o);
		void removeObserver(Observer o);
		void notifyObservers();
	}
	
	public static class Book implements SubjectLibrary {
		private String name;
		private boolean available;
		private List<Observer> observers;
		
		public Book(String name) {
			this.name = name;
			available = false;
			observers = new ArrayList<>();
		}
		
		public void setState(boolean available) {
			this.available = available;
			notifyObservers();
		}
		
		public String getName() {
			return name;
		}
		
		public boolean isAvailable() {
			return available;
		}

		@Override
		public void addObserver(Observer o) {
			observers.add(o);
		}

		@Override
		public void removeObserver(Observer o) {
			observers.remove(o);
		}

		@Override
		public void notifyObservers() {
			System.out.println("notify");
			observers.forEach(it -> it.update(this));
		}
	}
	
	public static void main(String[] args) {
		Book book = new Book("Duck tales");
		User user = new User("Ilia");
		book.addObserver(user);
		book.setState(true);
		book.setState(false);
	}
}
