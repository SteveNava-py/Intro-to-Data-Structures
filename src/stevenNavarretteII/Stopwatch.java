package stevenNavarretteII;//////////////////////////////////////////////////////////////////////
/// Name: Steven Navarrette
/// Contents:  This class is a data type for measuring
/// the running time (nanoTime) of a program using the JVM interanl clocking feature.
/// COSC 2351 - Marian Zaki
//////////////////////////////////////////////////////////////////////

public class Stopwatch {

    public long start,now;

    /**
     * Create a stopwatch object. //I did this part in search test java class
     */
    public Stopwatch() {
        start = System.nanoTime();
    } //I did this part in search test java class

    /**
     * Return elapsed time (in nanoseconds) since this object was created.
     */
    public double elapsedTime() {
        now = System.nanoTime();
        return (now - start) / 1_000_000.0 ; //Divided by one million to convert my execution times from nanoseconds to milliseconds per the instructions
    }
}
