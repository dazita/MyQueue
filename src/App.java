public class App {
    
    public static void main(String[] args) {
        int[] nums = {2221, 3458, 3125, 6536 , 1234, 5436};
        NumbersOrderer no = new NumbersOrderer(nums);
        no.controlIterations();
        for (int i = 0; i < no.getNums().length; i++) { 
        System.out.println(no.getNums()[i]);
        }
    }
}
