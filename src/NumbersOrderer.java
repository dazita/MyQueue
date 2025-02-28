public class NumbersOrderer {

    private int[] nums;
    private SimpleList<MyQueue<Integer>> queues;
    private int place;


    public NumbersOrderer(int[] nums){
        queues = new SimpleList<>();
        createQueues();
        this.nums = nums;
        place = 1;
    }

    public int[] getNums() {
        return nums;
    }

    public int getNumDigit(int num){
        String numStr = String.valueOf(num);
    if (numStr.length() < place) {
        return 0;
    }
    return Character.getNumericValue(numStr.charAt(numStr.length() - place));
    }

    public int findMaxDigits(){
        int greater = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > greater) {
                greater = nums[i];
            }
        }
        return String.valueOf(greater).length();
    }
    
    public void createQueues(){
        queues = new SimpleList<>();
        for (int i = 0; i < 10; i++) {
            queues.add(new MyQueue<Integer>());
        }
    }

    public void controlIterations(){
        for (int i = 0; i < findMaxDigits(); i++) {
            System.out.println("iteración" + i);
            iterateNumbers();
            place ++;
            queuesToArray();
        }
    }

    public void iterateNumbers(){
        for (int i = 0; i < nums.length; i++) {
            sortNums(nums[i]);
        }
    }

    public void sortNums(int num){
        queues.get(getNumDigit(num)).offer(num);
    }

    public void queuesToArray(){
        int[] newNums = new int[nums.length];
        int i = 0;
        for (MyQueue<Integer> q : queues) {
            while (!q.isEmpty()) {
                newNums[i] = q.poll();
                i++;
            }
        }
        nums = newNums;
    }
}
