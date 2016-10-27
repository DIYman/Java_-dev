import java.util.Scanner;

public class AirlineReservationSystem{
    boolean[] arrSeats = new boolean[10];
    Scanner sc = new Scanner(System.in);

    public boolean assignSeat(String section){
        if(section == "first"){
            if(getFreeSeats(section) > 0){
                for(int i=0; i<5; i++){
                    if(arrSeats[i] == false){
                        arrSeats[i] = true;
                        printBoardingPass(i);
                        return true;
                    }
                }
            }
        }else if(section == "economy"){
            if(getFreeSeats(section) > 0){
                for(int i=5; i<arrSeats.length; i++){
                    if(arrSeats[i] == false){
                        arrSeats[i] = true;
                        printBoardingPass(i);
                        return true;
                    }
                }

            }
        }

        System.out.printf("All seats in section \"%s\" are booked.\n", section);
        System.out.printf("Would you like to be moved to section \"%s\" (y/n)? ",
                (section == "first") ? "economy" : "first");

        if(sc.next().charAt(0) == 'y')
            assignSeat((section == "first") ? "economy" : "first");
        else
            System.out.println("\nNext flight leaves in 3 hours.\n");

        return false;
    }

    private int getFreeSeats(String section){
        int total = 0;
        if(section == "first"){
            // first class 1-5 (array 0-4)
            for(int i=0; i<5; i++){
                if(arrSeats[i] == false)
                    total += 1;
            }
        }else if(section == "economy"){
            for(int i=5; i<arrSeats.length; i++){
                if(arrSeats[i] == false)
                    total += 1;
            }
        }
        return total;
    }

    public boolean seatsAvailable(){
        for(boolean seat : arrSeats)
            if(seat == false)
                return true;

        return false;
    }

    public void printGreeting(){
        System.out.println("\nWelcome to Crap Airlines booking system.\n");
    }
    public void printMenu(){
        System.out.printf("1. Economy class %s\n",
                (getFreeSeats("economy") > 0) ?
                "(" + Integer.toString(getFreeSeats("economy")) + ")" : "(full)");
        System.out.printf("2. First class %s\n",
                (getFreeSeats("first") > 0 ?
                 "(" + Integer.toString(getFreeSeats("first")) + ")" : "(full)"));
        System.out.print("> ");
    }

    private void printBoardingPass(int seat){
        System.out.println("\nBoarding pass for Crap Airlines.");
        System.out.printf("\nSECTION: %s\nSEAT NUMBER: %d\n\n\n",
                (seat < 5) ? "first" : "economy", seat + 1);
    }
}
