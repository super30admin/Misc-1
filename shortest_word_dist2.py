class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.hash_map = defaultdict(list)
        
        for i,word in enumerate(wordsDict):
            self.hash_map[word].append(i)
        

    def shortest(self, word1: str, word2: str) -> int:
        l1 = self.hash_map[word1]
        l2 = self.hash_map[word2]
        
        min_dist = float('inf')
        
        # for i in l1:
        #     for j in l2:
        #         min_dist = min(min_dist, abs(i-j))
        
        pt1, pt2 = 0,0
        
        while pt1 < len(l1) and pt2 < len(l2):
            min_dist = min(min_dist, abs(l1[pt1]-l2[pt2]))
            if l1[pt1] < l2[pt2]:
                pt1 += 1
            else:
                pt2 += 1
                
        return min_dist


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)