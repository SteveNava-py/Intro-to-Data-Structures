package everythingHash;

public class PhoneNumber {
    private int area;
    private int exch;
    private int ext;

    public PhoneNumber(int a, int ex, int ext) {
        this.area = a;
        this.exch = ex;
        this.ext = ext;

    }

    public String toString() {
        return this.area + "-" + this.exch + "-" + this.ext ;
    }

    public boolean equals(Object other) {
        if(other == null)
            return false;
        return (this.area == ((PhoneNumber)other).area &&
                this.exch == ((PhoneNumber)other).exch &&
                this.ext == ((PhoneNumber)other).ext) ;
    }

    public int hashCode() {
        return 31 * (area + 31 * exch) + ext;
    }
}
