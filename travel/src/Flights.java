public class Flights {
    private String from;
    private String to;
    private String dep_date;
    private String arv_date;
    private int numOfTrip;
    private int travelersprice;
    //private Travelers[] alltravelers;

    public Flights(String from, String to, String dep_date, String arv_date, int numOfTrip, int travelersprice) {
        this.from = from;
        this.to = to;
        this.dep_date = dep_date;
        this.arv_date = arv_date;
        this.numOfTrip = numOfTrip;
        // this.maxtravelers=maxtravelers;
        this.travelersprice = travelersprice;
        //this.alltravelers = alltravelers;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDep_date() {
        return dep_date;
    }

    public void setDep_date(String dep_date) {
        this.dep_date = dep_date;
    }

    public String getArv_date() {
        return arv_date;
    }

    public void setArv_date(String arv_date) {
        this.arv_date = arv_date;
    }

    public int getNumOfTrip() {
        return numOfTrip;
    }

    public void setNumOfTrip(int numOfTrip) {
        this.numOfTrip = numOfTrip;
    }

    public int getTravelersprice() {
        return travelersprice;
    }

    public void setTravelersprice(int travelersprice) {
        this.travelersprice = travelersprice* numOfTrip;
    }

   /* public Travelers[] getAlltravelers() {
        return alltravelers;
    }

    public void setAllflights(Flights[] alltravelers) {
        this.alltravelers = alltravelers;
    }*/

    @Override
    public String toString() {
        return "Flights{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", dep_date='" + dep_date + '\'' +
                ", arv_date='" + arv_date + '\'' +
                ", numtravelers=" + numOfTrip +
                ", travelersprice=" + travelersprice +
                '}';
    }
}
