package ict4305.week2;

public class MyDate {

    /* If no arguments were provided then default the date January 1st, 1970 (epoch time). */
    public MyDate() {
        this.julianNumber = toJulianNumber(1, 1, 1970);
    }
    /* Creates a new MyDate from an existing MyDate */
    public MyDate( MyDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Received Null");
        }
        this.julianNumber = date.julianNumber;
    }
    /* Creates a new MyDate from a day, month, and year */
    public MyDate( int day, int month, int year){
        validateDate(day, month, year);
        this.julianNumber = toJulianNumber(day, month, year);
    }

    /* Returns the day of the month for this MyDate */
    public int getDay() {
        return fromJulianNumber()[0];
    }
    /* Returns the month of the year for this MyDate */
    public int getMonth() {
        return fromJulianNumber()[1];
    }
    /* Returns the year for this MyDate */
    public int getYear() {
        return fromJulianNumber()[2];
    }
    /* Returns true if this MyDate represents a date in a leap year */
    public static boolean isLeapYear( int year ) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getLastDayOfMonth( int month, int year ) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        throw new IllegalArgumentException("Invalid month: " + month);
    }

    /* This internal method returns the calculated Julian number for the provided day, month, year
     * This method is static, as it does not require a MyDate object to perform its computation
     */
    private static int toJulianNumber(int day, int month, int year) {
        return  ((1461 * (year + 4800 + (month - 14) / 12)) / 4)
                + ((367 * (month - 2 - 12 * ((month - 14) / 12))) / 12)
                - ((3 * ((year + 4900 + (month - 14) / 12) / 100)) / 4)
                + day - 32075;
    }
    /* This internal method returns a 3-integer array
     * containing the day, month, and year of this MyDate
     */
    private int[] fromJulianNumber() {
        int l, n, i, j;
        int day, month, year;

        l = julianNumber + 68569;
        n = (4 * l) / 146097;
        l = l - (146097 * n + 3) / 4;
        i = (4000 * (l + 1)) / 1461001;
        l = l - (1461 * i) / 4 + 31;
        j = (80 * l) / 2447;
        day = l - (2447 * j) / 80;
        l = j / 11;
        month = j + 2 - (12 * l);
        year = 100 * (n - 49) + i + l;

        return new int[] { day, month, year };
    }

    public static void validateDate(int day, int month, int year) {
        if (month <1 || month > 12) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Invalid year: " + year);
        }
        int lastDay = getLastDayOfMonth(month, year);

        if (day < 1 || day > lastDay) {
            throw new IllegalArgumentException("Invalid day: " + day + " for month " + " and year " + year);
        }
    }

    /* This private data member holds the calculated Julian number for this MyDate */
    private int julianNumber;
}
