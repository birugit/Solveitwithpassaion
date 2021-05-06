package com.array;
public class JumpGame {
    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        int[] jumpOrder = {2, 3, 1, 1, 4};
        boolean isJumpReachedEnd = j.findJump(jumpOrder);
        System.out.println(isJumpReachedEnd);
    }

    private boolean findJump(int[] jumpOrder) {
        int size = jumpOrder.length;
        int last = jumpOrder[size - 1];
        for(int i=size -2; i>=0 ; i--){
            if(i + jumpOrder[i] >= last){
                last = i;
            }
        }
        return last <= 0;
    }
}
