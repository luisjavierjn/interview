package Tests.DurationToReadableText;

// your task in this following challenge is to write a function that transform a duration (given as a number of seconds) to readable text
// The function must accept a non-negative Integer . if it is zero , it just returns "now" otherwise , the duration is expressed as a combination of years, days, hours , minutes and seconds
//
// example:
// for seconds = 62, your function should return "1 minute and 2 seconds"
// for seconds = 3662, your function should return "1 hour, 1 minute and 2 seconds"
// for the purpose of this challenge, a year is 365  days and a day 24 hours
//
// Detailed rules
// - The resulting expression is made of components like 4 seconds, 1 year, etc. In
//   general, a positive integer and one of the valid units of time, separated by a space.
//   The unit of time is used in plural if the integer is greater than 1.
// - The components are separated by a comma and a space (","). Except the last
//   component, which is separated by " and ", just like it would be written in English.
// - A more significant units of time will occur before than a least significant one.
//   Therefore, 1 second and 1 year is not correct, 1 year and 1 second is.
// - Different components have different unit of times. So there is no repeated units like
//   in 5 seconds and 1 second.
// - A component will not appear at all if its value happens to be zero. Hence, 1 minute
//   and 0 seconds is not valid, but it should be just 1 minute.
// - A unit of time must be used "as much as possible". It means that the function should
//   not return 61 seconds, but 1 minute and 1 second instead. Formally, the duration
//   specified by of a component must not be greater than any valid more significant unit
//   of time.
//
// Sample input :
// 62
//
// Sample output:
// 1 minute and 2 seconds
public class Main {
    public static void main(String[] args) {
        System.out.println(formatDuration(62)); // Output: 1 minute and 2 seconds
        System.out.println(formatDuration(3662)); // Output: 1 hour, 1 minute and 2 seconds
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        int[] durations = {365 * 24 * 60 * 60, 24 * 60 * 60, 60 * 60, 60, 1};
        String[] units = {"year", "day", "hour", "minute", "second"};

        StringBuilder result = new StringBuilder();
        boolean isFirst = true;

        for (int i = 0; i < durations.length; i++) {
            int duration = durations[i];
            if (seconds >= duration) {
                int count = seconds / duration;
                seconds %= duration;
                if (!isFirst) {
                    result.append(", ");
                }
                result.append(count).append(" ").append(units[i]);
                if (count > 1) {
                    result.append("s");
                }
                isFirst = false;
            }
        }

        if (seconds > 0) {
            if (!isFirst) {
                result.append(" and ");
            }
            result.append(seconds).append(" second");
            if (seconds > 1) {
                result.append("s");
            }
        }

        return result.toString();
    }
}
