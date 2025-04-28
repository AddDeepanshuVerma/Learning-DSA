package POTD_LEETCODE.Math;

class ColoredCells_2579 {
    public long coloredCells(int n) {
        long ans = n;
        return ans * ans + (ans - 1) * (ans - 1);
    }
}