class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null) 
            return 0;
        
        Arrays.sort(envelopes,(envelope1,envelope2)->{
           int diff = envelope1[0]-envelope2[0];
           return diff!=0? diff :envelope2[1]-envelope1[1];
        });
        
        int[] sortedArray = new int[envelopes.length];
        int len = 0;
        
        for(int[] envelope:envelopes)
        {
            int index = findIndex(sortedArray, 0, len-1, envelope[1]);
            sortedArray[index]=envelope[1];
            if(len == index)
                len++;
        }
        
        return len;
    }
    
    private int findIndex(int[] sortedArray, int start, int end, int envelopeHeight)
    {
        
        while(start<=end)
        {
            int mid = start + (end - start)/2;
            
            if(envelopeHeight<sortedArray[mid])
            {
                end = mid - 1;
            }else if(sortedArray[mid] == envelopeHeight){
                return mid;
            }else{
                start = mid +1;
            }
            
        }
        
        return start;
        
    }
}
