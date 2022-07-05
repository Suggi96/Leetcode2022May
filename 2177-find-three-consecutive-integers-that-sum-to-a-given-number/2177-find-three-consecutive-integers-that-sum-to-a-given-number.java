class Solution {
    public long[] sumOfThree(long num) {
	if (num % 3 != 0) {
		return new long[0];
	}
	long a = num / 3 - 1;
	return new long[] {a, a + 1, a + 2};
    }
}