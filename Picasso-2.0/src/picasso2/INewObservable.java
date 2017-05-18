package picasso2;

public interface INewObservable {

	public void addObserver(INewObserver o);
	public void notifyObserver(Object args);
	
}
