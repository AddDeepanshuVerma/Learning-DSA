package _13_Maths.Medium;

class AngleClock_1344 {
    public static void main(String[] args) {
        AngleClock_1344 obj = new AngleClock_1344();
        System.out.println(obj.angleClock(2, 20));

    }

    public double angleClock(int hour, int minutes) {
        // hour pin length from top (12 o clock) in minutes
        double hourDistance = (5 * hour % 12) + (minutes / 12.0);

        // hour pin diff from minute pin in minutes
        double diff = Math.abs(hourDistance - minutes);

        // converting minuted to degree ~ ( 1 min = 6 degree)
        diff = hourDistance * 6;

        // return whichever is lower
        return Math.min(diff, 360 - diff);
    }

    public double angleClock3(int hour, int minutes) {
        double hourHand = (hour % 12 + minutes / 60.0) * 30;
        double minuteHand = minutes * 6;
        double diff = Math.abs(hourHand - minuteHand);
        return Math.min(diff, 360 - diff);
    }

    public double angleClock2(int hour, int minutes) {
        double diff = (5 * (hour % 12)) + (minutes / 12.0);
        diff = Math.abs(diff - minutes) * 6;
        return Math.min(diff, 360 - diff);
    }
}