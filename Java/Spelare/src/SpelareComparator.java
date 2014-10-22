import java.util.Comparator;


public class SpelareComparator implements Comparator<Spelare>
{
	public int compare(Spelare o1, Spelare o2)
    {
        return o1.getTyp().compareTo(o2.getTyp());
    }
}
