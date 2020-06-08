package me.siduzy.ch02;

public class E010211_E0101212 {

    public static class SmartDate {
        private int month;
        private int day;
        private int year;
        private boolean isLeap;

        private static int[] daysOfMonthInNotLeapYear = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
        private static int[] daysOfMonthInLeapYear = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};

        public static final String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        public SmartDate(int month, int day, int year) {
            this.year = year;
            if (isLeapYear(year)) {
                isLeap = true;
            }
            checkMonth(month);
            this.month = month;
            checkDay(day);
            this.day = day;
        }

        private void checkDay(int day) {
            if (day < 1) {
                throw new IllegalArgumentException();
            }
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: {
                    if (day > 31) {
                        throw new IllegalArgumentException();
                    }
                    break;
                }
                case 2:
                    if (isLeap && day > 29 || !isLeap && day > 28) {
                        throw new IllegalArgumentException();
                    }
                    break;
                default:
                    if (day > 30) {
                        throw new IllegalArgumentException();
                    }

            }
        }

        private void checkMonth(int month) {
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException();
            }
        }

        private boolean isLeapYear(int year) {
            if (year % 400 == 0 || ((year & 0b11) == 0 && year % 100 != 0)) {
                return true;
            }
            return false;
        }

        public int year() {
            return year;
        }

        public int month() {
            return month;
        }

        public int day() {
            return day;
        }

        public String dayOfTheWeek() {
            int sum = 0;
            for (int i = 2000; i < year; i++) {
                sum = sum + (isLeapYear(i) ? 2 : 1);
            }
            int passDays = (isLeap ? daysOfMonthInLeapYear[month - 1] : daysOfMonthInNotLeapYear[month - 1]) + day;
            int index = (5 + sum + passDays) % 7; // 5(Fri) is the last day of 1999
            return DAYS_OF_WEEK[index];
        }

        public String toString() {
            return month() + "/" + day() + "/" + year();
        }
    }

    public static void main(String[] args) {
        SmartDate date = new SmartDate(6, 9, 2020);
        System.out.println(date.dayOfTheWeek());
    }
}
