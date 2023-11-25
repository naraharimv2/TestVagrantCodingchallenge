import java.util.*;
public class TestVagrantTest {
    String prod;
    int price, gst, qnty;

    TestVagrantTest(String prod, int price, int gst, int qnty){
        this.prod = prod;
        this.price = price;
        this.gst = gst;
        this.qnty = qnty;
    }

    static int calcGst(int price, int gst, int qnty){
        int newGst = price*qnty*gst/100;
        return newGst;
    }

    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        String maxGstProd = "";
        int totalAmt=0;
        List<TestVagrantTest> arr = new ArrayList<>();
        arr.add(new TestVagrantTest("Leather wallet", 1100, 18, 1));
        arr.add(new TestVagrantTest("Umbrella", 900, 12, 4));
        arr.add(new TestVagrantTest("Cigarette", 200, 28, 3));
        arr.add(new TestVagrantTest("Honey", 100, 0, 2));

        for(TestVagrantTest test : arr){
            int gstPrice = calcGst(test.price, test.gst, test.qnty);
            if(gstPrice > max){
                max = gstPrice;
                maxGstProd = test.prod;
            }

            if(test.price >= 500)
                test.price -= test.price*0.05;
            totalAmt += test.price*test.qnty+gstPrice;

        }
        System.out.println("Max GST Product: " + maxGstProd);
        System.out.println("Total amount to be paid to the shopkeeper: " + totalAmt);
    }
}