import java.util.Scanner;

public class PrintCalender {


    public static class PrintCalendar {

        /** Main method */

        public static void main(String[] args) {

            Scanner scan = new Scanner (System.in);

            //Prompt the user to enter year

            System.out.print("Vul het jaartal in: ");
            int year = scan.nextInt();

            // Prompt the user to enter month

            System.out.print("Vul de maand in aantal (tussen 1 en 12): ");

            int month = scan.nextInt();

            // Print calendar for the month of the year

            if (month < 1 || month > 12 || year < 1980)

                System.out.println("Wrong + input!");

            else

                printMonth(year, month);
        }
        /** Print the calender voor een maand in een jaar */

        static void printMonth(int year, int month) {

            //Print de titels van de kalender

            printMonthTitle(year, month);

            //Print the body of the calendar

            printMonthBody(year, month);

        }

        /** Print maand titel + jaar */

        static void printMonthTitle(int year, int month) {

            System.out.println("  " + getMonthName(month) + " " + year);

            System.out.println(" ");

            System.out.println("   Zo  Ma  Di  Wo  Do  Vr  Za");

        }

        /** Nederlandse benaming voor de maand */

        static String getMonthName(int month) {

            String monthName = null;

            switch (month) {

                case 1: monthName = "Januari"; break;

                case 2: monthName = "Februari"; break;

                case 3: monthName = "Maart"; break;

                case 4: monthName = "April"; break;

                case 5: monthName = "Mei"; break;

                case 6: monthName = "Juni"; break;

                case 7: monthName = "Juli"; break;

                case 8: monthName = "Augustus"; break;

                case 9: monthName = "September"; break;

                case 10: monthName = "Oktober"; break;

                case 11: monthName = "November"; break;

                case 12: monthName = "December";

            }
            return monthName;
        }

        /** Print maand body */

        static void printMonthBody(int year, int month) {

            // Get de eerste dag van de week voor de betreffende maand

            int startDay = getStartDay(year, month);

            // Get aatal dagen in de maand

            int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

            // Ruimte voor de eerste dag van de maand
            int i = 0;

            for (i = 0; i < startDay; i++)
                System.out.print("    ");

            for (i = 1; i <= numberOfDaysInMonth; i++) {

                if (i < 10)

                    System.out.print("   " + i);
                else
                    System.out.print("  " + i);

                if ((i + startDay) % 7 == 0)

                    System.out.println();
            }
            System.out.println();
        }


        /** Get de begindatum van de eerste dag van een maand*/

        static int getStartDay(int year, int month) {

            //Get totaal aantal dagen sinds 01/01/1800

            int startDay1800 = 3;

            int totalNumberOfDays = getTotalNumberOfDays(year, month);

            //Return de startdag

            return (totalNumberOfDays + startDay1800) % 7;

        }

        /** Get het totale aantal dagen sinds 1 januari 1800 */

        static int getTotalNumberOfDays(int year, int month) {

            int total = 0;

            //Get de totale aantal dagen 1800 tot jaar -1

            for (int i = 1800; i < year; i++)

                if (isLeapYear(i))

                    total = total + 366;

                else

                    total = total + 365;

            //Voeg dagen van junuari toe aan de maand voorafgaand aan de kalandermaand

            for (int i = 1; i < month; i++)

                total = total + getNumberOfDaysInMonth(year, i);

            return total;
        }

        /** Get het aantal dagen in een maand */

        static int getNumberOfDaysInMonth(int year, int month) {

            if (month == 1 || month == 3 || month == 5 || month == 7 ||

                    month == 8 || month == 10 || month == 12)

                return 31;

            if (month == 4 || month == 6 || month == 9 || month == 11)

                return 30;

            if (month == 2) return isLeapYear(year) ? 29 : 28;

            return 0; // If month is incorrect
        }

        /** Bepaal of het een schrikkeljaar is */

        static boolean isLeapYear(int year) {

            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        }

    }
}
