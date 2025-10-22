import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int elementLength = elements.length;
        int[] sums = new int[elementLength];
        Set<Integer> distinctSums = new HashSet<>();
        
        for(int elementCount = 0; elementCount < elementLength; elementCount++) {
            int startIdx = elementCount;
            for (int i = 0; i < elementLength; i++) {
                sums[i] += elements[startIdx++];
                distinctSums.add(sums[i]);
                if(startIdx == elementLength) startIdx = 0;
            }
        }
        return distinctSums.size();
    }
}