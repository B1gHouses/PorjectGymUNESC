package PackageClassLibrary;

public interface Observable {

	public void AddObserver(Observer obj);
	public void RemoveObserver(Observer obj);
	public void NotifyAllObserver();
}
