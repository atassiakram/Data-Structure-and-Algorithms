public class Testing {
    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            long start = System.nanoTime();
            System.out.println("Hello World\n\n");
            long end = System.nanoTime();
            long totalTime = end - start;
            System.out.println(totalTime);
        }
    }
}
