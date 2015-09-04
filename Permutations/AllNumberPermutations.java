public class AllNumberPermutations {
    
    public static int currSeqCount;
    
    public static void main (String args[]){
        int n = 5;
        int k = 50;
        
        // Step-1: Define inputs: input arr, boolean arr, k, output, level
        int[] inputArr = new int[n];
        int count = 1;
        while (count <= n) {
            inputArr[count-1] = count++;
        }
        boolean[] boolArr = new boolean[n];

        // Step-2: Core logic
        int outputSeq = permuteNumbers (inputArr, boolArr, k, 0, 0);
    }
    
    public static int permuteNumbers (int[] inputArr, boolean[] boolArr, int kval, int outputSeq, int level) {
        int output = Integer.MIN_VALUE;
        if (inputArr.length == level) {
            // perform core logic of checking the seuence and seq count
            currSeqCount++;
            System.out.println (currSeqCount + "--" +outputSeq);
            if (currSeqCount == kval) {
                System.out.println ("------");
                return outputSeq;
            }
            return output;
        }
        for (int i=0; i < inputArr.length; i++) {
            if (boolArr[i])
                continue;
            boolArr[i] = true;
            outputSeq = (outputSeq * 10) + inputArr[i];
            output = permuteNumbers (inputArr, boolArr, kval, outputSeq, level+1);
            if (output != Integer.MIN_VALUE)
                return output;
            boolArr[i] = false;
            outputSeq = outputSeq /10;
        }
        return output;
    }
}
