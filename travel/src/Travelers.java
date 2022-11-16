import java.util.Objects;

public class Travelers {
    private int numpassport;
    private String fullname;
    private int numphone;
    private String country;
    private int max;
    public static int counter = 0;

    public Travelers(int numpassport, String fullname, int numphone, String country) {
        this.numpassport = numpassport;
        this.fullname = fullname;
        this.numphone = numphone;
        this.country = country;
    }

    public Travelers(Travelers travelers) {

    }

    public int getNumpassport() {
        return numpassport;
    }

    public void setNumpassport(int numpassport) {
        this.numpassport = numpassport;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getNumphone() {
        return numphone;
    }

    public void setNumphone(int numphone) {
        this.numphone = numphone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Travelers{" +
                "numpassport=" + numpassport +
                ", fullname='" + fullname + '\'' +
                ", numphone=" + numphone +
                ", country='" + country + '\'' +'}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travelers travelers = (Travelers) o;
        return numpassport == travelers.numpassport && numphone == travelers.numphone && Objects.equals(fullname, travelers.fullname) && Objects.equals(country, travelers.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numpassport, fullname, numphone, country);
    }

}
