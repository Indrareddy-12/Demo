public class IntegeerToRoman {

    public static void main(String[] args) {

        System.out.println(InterTORomanConvert(120));
    }

    private static String InterTORomanConvert(int num) {

        int[] values   = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuffer sb=new StringBuffer();

        for(int i=0;i<values.length;i++) {

            while (num >= values[i]) {

                num = num - values[i];

                sb.append(romans[i]);


            }
        }
            return sb.toString();

    }

}
