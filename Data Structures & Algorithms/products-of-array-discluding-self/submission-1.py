class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        total_product = 1
        zero_indexes = []
        for i, num in enumerate(nums):
            if num != 0:
                total_product *= num
            else:
                zero_indexes.append(i)
        
        if len(zero_indexes) > 1:
            ret = [0] * len(nums)
            return ret
        elif len(zero_indexes) == 1:
            ret = [0] * len(nums)
            ret[zero_indexes[0]] = total_product
            return ret
        else:
            ret = [1] * (len(nums))
            for i in range(0, len(nums)):
                ret[i] = int(total_product / nums[i])
            return ret
        
        