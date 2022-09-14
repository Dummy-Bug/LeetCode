class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                
                curr_val = board[i][j];
                
                    
                live_cell_count = 0;
                    
                for x,y in [(i+1,j),(i-1,j),(i,j+1),(i,j-1),(i-1,j-1),(i+1,j-1),(i-1,j+1),(i+1,j+1)]:
                        
                    if self.isValid(x,y,board):
                        if board[x][y]%2 != 0:
                            live_cell_count += 1;
                
                if curr_val == 0 and live_cell_count == 3:
                    board[i][j] = 2;
                
                if curr_val == 1:
                    if live_cell_count < 2 or live_cell_count > 3:
                        board[i][j] = 3;
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                
                if board[i][j] == 2:
                    board[i][j] = 1;
                    
                elif board[i][j] == 3:
                    board[i][j] = 0;
    
    def isValid(self,x,y,board):
        
        if x<0 or y<0 or x>=len(board)or y>=len(board[0]):
            return False;
        else:
            return True;
        
                    
                            
                        
                    
        