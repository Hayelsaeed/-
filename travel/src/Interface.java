import java.io.FileNotFoundException;
import java.util.Scanner;
public class Interface {
    Control c;
    Scanner in;

    public Interface() throws FileNotFoundException {
        c = new Control();
        in = new Scanner(System.in);
    }

    public void start() throws FileNotFoundException {
        System.out.println("---------------------------------------");
        System.out.println("      Airline Reservation System      ");
        System.out.println("----------------------------------------");
        while (true) {
            System.out.println("1 Add Flight" + "\t" + "2 View Flight" + "\t" +"3 Search Flight"+"\t"+"4 Edit Flight"+"\t"+"5 Delete Flight"+"\t"+"6 Add travelers"+"7 Save Flight"+"\t"+"0 Exit");
            int choice = in.nextInt();
            switch (choice) {
                case 1:addtrip();break;
                case 2:viewtrip();break;
                case 3:searchtrip();break;
                case 4:edittrip();break;
                case 5:deletetrip();break;
                case 6: Traveler();break;
                case 7:c.writeFlightsFile();break;
                case 0: System.exit(0);
            }
        }

    }
    public void addtrip() {
        System.out.println("from   to   dep_date   arv_date   numOfTrip   travelersprice  ");
        String s = in.next();
        String f = in.next();
        String d_d = in.next();
        String a_d = in.next();
        int t = in.nextInt();
        int p = in.nextInt();

        boolean added = c.addflight(s, f, d_d, a_d, t, p);
        if (added) {
            System.out.println("New Flight added successfully");
            System.out.println("---------------------------------------------------");
        } else System.out.println("Too Much Flights");
        int i = 0;

    }

    public void viewtrip()
    {

        Flights[] t=c.viewtheflights();
        System.out.println("from   to   dep_date   arv_date   numOfTraveler   travelersprice");

        for (int i = 0; i < t.length; i++) {
            if (t[i]!=null)
                /*System.out.println(t[i].getFrom()+"\t"+t[i].getTo()+"\t"+t[i].getDep_date()+"\t"+t[i].getArv_date()+"\t"+t[i].getNumtravelers()+t[i].getTravelersprice());*/
                System.out.println(t[i].toString());
        }
    }
    public void searchtrip()
    {
        System.out.println("Enter the Country");
        int numTraveler=in.nextInt();
        Flights e=c.searchFlight(numTraveler);
        if (e!=null)
        {
            System.out.println("from   to   dep_date   arv_date   numOfTraveler  travelersprice  ");
            System.out.println(e.getFrom()+"\t"+e.getTo()
                    +"\t"+e.getDep_date()+"\t"+e.getArv_date()+"\t"+e.getNumOfTrip()+"\t"+e.getTravelersprice());
        }
        else System.out.println("No Traveler with this Country");
    }

    public void deletetrip()
    {
        System.out.println("Input The Destination");
        int numTraveler=in.nextInt();
        boolean deleted=c.deleteflight(numTraveler);
        if (deleted)
        {
            System.out.println("Deleted Successfully");   }
        else System.out.println("No Flight with this Destination");
    }
    public void edittrip()
    {
        System.out.println("Input The Destination");
        String from=in.next();
        System.out.println("Input the edited flight");
        String to=in.next();
        String d=in.next();
        String a=in.next();
        int n=in.nextInt();
        int p=in.nextInt();
        boolean edited=c.editflight(from,to ,d ,a,n,p);
        if (edited)
        {
            System.out.println("Edited Successfully");   }
        else System.out.println("No Flight With this Destination");
    }

    public void Traveler() throws FileNotFoundException {
        while (true) {
            System.out.println("1 Add Traveler" + "\t" + "2 View Traveler" + "\t" + "3 Search Traveler" + "\t" +"4 Delete Traveler" + "\t"+"\t"+ "5 Edit Traveler" +"6 Back to Flight menu"+"\t"+ "0 Exit");
            int choice = in.nextInt();
            switch (choice) {
                case 1: addtraveler();break;
                case 2: viewtraveler();break;
                case 3: findtraveler();break;
                case 4: deletetraveler();break;
                case 5: edittraveler();break;
                case 6:start();break;
                case 0:c.writeTravelers();
                    System.exit(0);
            }
        }
    }
    public void addtraveler()
    {
        //System.out.println("1 Add Traveler"+"\t"+"2 Search Traveler"+"\t"+"3 Delete Traveler"+"\t"+"4 View Travelers"+"\t"+"0 Exit");

        System.out.println("Numpassport   Fullname   Numphone   Country");
        int id = in.nextInt();
        String m = in.next();
        int l = in.nextInt();
        String y = in.next();
        boolean added1 = c.addtravelers(id, m, l, y);
        if (added1){
            System.out.println("New Traveler Added Successfully\n");}
        else System.out.println("Too Much Travelers");

    }

    public void viewtraveler()
    {
        Travelers[] all=c.viewthetravelers();
        System.out.println("Numpassport   Fullname   Numphone   Country");
        for (int i = 0; i <all.length ; i++) {
            if (all[i]!=null)
                        /*System.out.println(all[i].getNumpassport()+"\t"+all[i].getFullname()
                                +"\t"+all[i].getNumphone()+"\t"+all[i].getCountry());*/
                System.out.println(all[i].toString());
        }


    }
    public void findtraveler()
    {
        System.out.println("Enter Traveler passport");
        int id=in.nextInt();
        Travelers s=c.searchtravelers(id);
        if (s!=null)
        {
            System.out.println("Numpassport   Fullname   Numphone   Country");
            System.out.println(s.getNumpassport()+"\t"+s.getFullname()
                    +"\t"+s.getNumphone()+"\t"+s.getCountry());
        }
        else System.out.println("No Traveler With this passport");
    }
    public void deletetraveler()
    {
        System.out.println("Enter Traveler passport");
        int id=in.nextInt();
        boolean deleted=c.deletetraveler(id);
        if (deleted)
        {
            System.out.println("Deleted Successfully");   }
        else System.out.println("No Traveler With this passport");
    }
    public void edittraveler()
    {
        System.out.println("Enter Traveler passport");
        int id=in.nextInt();
        System.out.println("Enter new date for the travelers ");
        String n=in.next();
        int p=in.nextInt();
        String co=in.next();
        boolean edit=c.edittravelers(id,n,p,co);
        if (edit)
        {
            System.out.println("Edited Successfully");   }
        else System.out.println("No Traveler With this passport");
    }
   /* public void ViewRecepit()
    {
        Travelers[] f=c.viewthetravelers();
        System.out.println("Numpassport   Fullname   Numphone   Country");
        for (int i = 0; i <f.length ; i++) {
            if (f[i]!=null)
                        System.out.println(f[i].getNumpassport()+"\t"+f[i].getFullname()
                                +"\t"+f[i].getNumphone()+"\t"+f[i].getCountry());

    }
        Flights[] f1 =c.viewtheflights();
        System.out.println("from   to   dep_date   arv_date   numtravelers   travelersprice");

        for (int i = 0; i < f1.length; i++) {
            if (f1[i]!=null)
                System.out.println(f1[i].getFrom()+"\t"+ f1[i].getTo()+"\t"+ f1[i].getDep_date()+"\t"+ f1[i].getArv_date()+"\t"+ f1[i].getNumtravelers()+ f1[i].getTravelersprice());

}
    }*/
}

