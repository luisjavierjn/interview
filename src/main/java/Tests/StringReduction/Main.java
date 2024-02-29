package Tests.StringReduction;

//have a function StringChallenge(str) take the str parameter being passed and return the smallest number you can get
//through the following reduction method. The method is : only the letter a, b and c will be given in str and you must
//take two different adjacent characters and replace it with the third. for example "ac" can be replaced with "b" but
//"aa" cannot be replaced with anything. this method is done repeatedly until the string cannot be further reduced,
//and the length of the resulting string is to be outputted
//
//for example if str is "cab" the ca can be reduced to b, and you get bb. the reduction is done so the output should
//be 2. the result of abcabc is 2, the result of cccc is 4
public class Main {

    public static String StringChallenge(String str) {
        if(str == null || str.isEmpty())
            return "";

        String result = str;
        boolean modified;

        do {
            modified = false;
            int i = 0;
            while (i < result.length() - 1) {
                String substring = result.substring(i, i + 2);
                if (substring.equals("ab") || substring.equals("ba")) {
                    result = result.substring(0, i) + "c" + result.substring(i + 2);
                    modified = true;
                } else if (substring.equals("ac") || substring.equals("ca")) {
                    result = result.substring(0, i) + "b" + result.substring(i + 2);
                    modified = true;
                } else if (substring.equals("bc") || substring.equals("cb")) {
                    result = result.substring(0, i) + "a" + result.substring(i + 2);
                    modified = true;
                } else {
                    i++;
                }
            }
        } while(modified);

        return result;
    }


    public static void main(String[] args) {
        String result = StringChallenge("abcabc");
        System.out.println(result + " " + result.length());

        result = StringChallenge("cccc");
        System.out.println(result + " " + result.length());
    }
}
