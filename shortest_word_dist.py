class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        # edge
        if wordsDict == None or len(wordsDict) < 2:
            return -1
           
        min_dist = float('inf')
        w1 = -1
        w2 = -1
        
        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                w1 = i
            elif wordsDict[i] == word2:
                w2 = i
                
            if w1 > -1 and w2 > -1:
                min_dist = min(min_dist, abs(w1-w2))
                
        return min_dist