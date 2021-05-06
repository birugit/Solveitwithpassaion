package com.fb.backtracking;

/**
 * Given an m x n board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * @author swamy on 1/31/21
 */
public class WordSearch {
    public static void main(String[] args) {
        WordSearch w = new WordSearch();
char[][] baord = {
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}};
String word = "ABCCED";
boolean found = w.exist(baord, word);
System.out.println(found);

    }
    public boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) &&
                        search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 ||
                board[i][j] != word.charAt(index) ||
                visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(     search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
