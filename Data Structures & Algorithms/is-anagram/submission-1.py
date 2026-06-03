class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        hash_map = {}
        for letter in s:
            if letter not in hash_map:
                hash_map[letter] = 1
            else:
                hash_map[letter] += 1

        for letter in t:
            if letter in hash_map:
                hash_map[letter] -= 1
            else:
                return False
        
        for letter in hash_map:
            if hash_map[letter] != 0:
                return False
        
        return True