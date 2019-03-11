import static org.junit.Assert.*;

public class CircularCollectionTest {

    private CircularCollection<String> circularCollection;

    @org.junit.Test
    public void addThreeElements() {
        circularCollection = new CircularCollection<>(4);
        circularCollection.add("A");
        circularCollection.add("B");
        circularCollection.add("C");
        assertEquals(3, circularCollection.size());
        assertEquals("C", circularCollection.findByIndex(2));
    }

    @org.junit.Test
    public void checkDefaultConstr() {
        circularCollection = new CircularCollection<>();
        assertEquals(16, circularCollection.getCapacity());
    }

    @org.junit.Test
    public void checkUserConstr() {
        circularCollection = new CircularCollection<>(5);
        assertEquals(5, circularCollection.getCapacity());
    }

    @org.junit.Test
    public void checkCircular() {
        circularCollection = new CircularCollection<>(3);
        circularCollection.add("A");
        circularCollection.add("B");
        circularCollection.add("C");
        circularCollection.add("D");

        assertEquals("B", circularCollection.findByIndex(0));
    }
}