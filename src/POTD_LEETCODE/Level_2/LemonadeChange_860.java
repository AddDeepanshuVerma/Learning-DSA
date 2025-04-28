package POTD_LEETCODE.Level_2;

class LemonadeChange_860 {

    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 10, 20};
        LemonadeChange_860 obj = new LemonadeChange_860();
        System.out.println(obj.lemonadeChange(arr));
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5 -> five++;
                case 10 -> {
                    five--;
                    ten++;
                }
                case 20 -> {
                    if (ten > 0) {
                        ten--;
                        five--;
                    } else five -= 3;
                }
            }
            if (five < 0) return false;
        }
        return true;
    }

    public boolean lemonadeChange1(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    five--;
                    ten++;
                    break;
                case 20:
                    if (ten > 0) {
                        ten--;
                        five--;
                    } else five -= 3;
            }
            if (five < 0) return false;
        }
        return true;
    }

    public boolean lemonadeChange2(int[] bills) {
        int[] arr = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                arr[0] += 5;
            }
            if (bill == 10) {
                arr[0] = arr[0] - 5;
                arr[1] += 10;
            }
            if (bill == 20) {
                Charge20(arr);
            }
            if (arr[0] < 0) {
                return false;
            }
        }
        return true;
    }

    private void Charge20(int[] arr) {
        if (arr[1] >= 10) {
            arr[1] -= 10;
            arr[0] -= 5;
        } else {
            arr[0] -= 15;
        }
    }

}