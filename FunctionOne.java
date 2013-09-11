   import java.util.ArrayList;
   import java.util.Random;

/**
 @author:	Matthew J Swann
 @version:	1.0, Last Modified 2012-09-03
 
 */
 
   public class FunctionOne{
   
      public int[][] theGrid = {
         		{-1, 1, 2, 3, 4, 1, 2, 3, 4, 5, 2, 3, 4, 5, 6},
         		{10, -1, 1, 2, 3, 2, 1, 2, 3, 4, 3, 2, 3, 4, 5},
         		{0, 1, -1, 1, 2, 3, 2, 1, 2, 3, 4, 3, 2, 3, 4},
         		{5, 3, 10, -1, 1, 4, 3, 2, 1, 2, 5, 4, 3, 2, 3},
         		{1, 2, 2, 1, -1, 5, 4, 3, 2, 1, 6, 5, 4, 3, 2},
         		{0, 2, 0, 1, 3, -1, 1, 2, 3, 4, 1, 2, 3, 4, 5},
         		{1, 2, 2, 5, 5, 2, -1, 1, 2, 3, 2, 1, 2, 3, 4},
         		{2, 3, 5, 0, 5, 2, 6, -1, 1, 2, 3, 2, 1, 2, 3},
         		{2, 2, 4, 0, 5, 1, 0, 5, -1, 1, 4, 3, 2, 1, 2},
         		{2, 0, 5, 2, 1, 5, 1, 2, 0, -1, 5, 4, 3, 2, 1},
         		{2, 2, 2, 1, 0, 0, 5, 10, 10, 0, -1, 1, 2, 3, 4},
         		{0, 0, 2, 0, 3, 0, 5, 0, 5, 4, 5, -1, 1, 2, 3},
         		{4, 10, 5, 2, 0, 2, 5, 5, 10, 0, 0, 3, -1, 1, 2},
         		{0, 5, 5, 5, 5, 5, 1, 0, 0, 0, 5, 3, 10, -1, 1},
         		{0, 0, 5, 0, 5, 10, 0, 0, 2, 5, 0, 0, 2, 4, -1}
         	};
         	
      public int[][] matrix = new int[5][3];
   	
      public int totalCost = 0;
         	
      public ArrayList<Integer> theList = new ArrayList<Integer>();
      public Random rand = new Random();
   
   
   
      public FunctionOne(){
      
         this.setList();
         this.setMatrix();
      
      }
   
   
   /**
    Solves current cost scenario. I'll make this prettier at some point.
    */   
      public int solve(){
         for(int i = 0; i < 5; i++){
         
            for(int j = 0; j < 3; j++){
               int current = matrix[i][j];
               
               for(int k = i+1; k < 5; k++){
                  for(int l = j; l < 3; l++){
                     int distance = k - i + l - j;
                     int target = matrix[k][l];
                     int multiplier;
                     if(current > target){
                        multiplier = theGrid[current-1][target-1];
                     }
                     else{
                        multiplier = theGrid[target-1][current-1];
                     }
                     totalCost += distance*multiplier;
                  }
               }
               
               for(int k = j+1; k < 3; k++){
                  int distance = k + j - 1;
                  int target = matrix[i][k];
                  int multiplier;
                  if (current > target){
                     multiplier = theGrid[current-1][target-1];
                  }
                  else{
                     multiplier = theGrid[target-1][current-1];
                  }
                  totalCost += distance*multiplier;
               }
            }
         
         }
      
         int current = matrix[0][1];
      
         for(int i = 1; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][0];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier;
         }
         
         current = matrix[0][2];
         for(int i = 1; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][0];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier;
         }
         
         for(int i = 1; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][1];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier; 
         }
         
         current = matrix[1][1];
         for(int i = 2; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][0];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier;
         }
         
         current = matrix[1][2];
         for(int i = 2; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][0];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier;
         }
         
         for(int i = 2; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][1];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier;   
         }
         
         current = matrix[2][1];
         for(int i = 3; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][0];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier;   
         }
         
         current = matrix[2][2];
         for(int i = 3; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][0];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier;   
         }
         
         for(int i = 3; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][1];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier;      
         }
         
         current = matrix[3][1];
         for(int i = 4; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][0];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier;  
         }
         
         current = matrix[3][2];
         for(int i = 4; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][0];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier;   
         }
         
         for(int i = 4; i < 5; i++){
            int distance = i + 1;
            int target = matrix[i][1];
            int multiplier;
            if (current > target){
               multiplier = theGrid[current-1][target-1];
            }
            else{
               multiplier = theGrid[target-1][current-1];
            }
            totalCost += distance*multiplier;
         }
      
         return totalCost;		
      }
   
   
   /**
    Assigns matrix values based off of random selection of index
    values from arraylist.
    */   
      public void setMatrix(){
         int number;
         
         for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
            
               number = rand.nextInt(theList.size());
               matrix[i][j] = theList.remove(number);
            }
         }
         
         this.setList();
      }
   
   
   /**
    Re-assigns matrix values depended on parameter passed.
    */
    
      public void mutateMatrix(int n){
         int[][] holdingMatrix = new int[5][3];
         ArrayList<Integer> stored = new ArrayList<Integer>();
         ArrayList<Integer> unstored = new ArrayList<Integer>();
         int x;
         int y;
         int target;  
      	
         int control = 15-n;
         while(control > 0){
            x = rand.nextInt(5);
            y = rand.nextInt(3);
            target = this.matrix[x][y];
            
            if(stored.contains(target) == false){
               holdingMatrix[x][y] = this.matrix[x][y];
               stored.add(target);
               control --;
            }	
         }
         
         for(int i = 1; i <= 15; i++){
            if(stored.contains(i) == false){
               unstored.add(i);
            }
         }
         
         for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
               if(holdingMatrix[i][j] == 0){
                  holdingMatrix[i][j] = unstored.remove(rand.nextInt(unstored.size()));
               }
            }
         }
      
         this.matrix = holdingMatrix;
      }
   
   /**
    Resets arraylist for matrix creation.
    */   
      public void setList(){
         for(int i = 1; i <= 15; i++){
            theList.add(i);
         }
      }	
   
   
   /**
    Nonsense getters/setters.
    */   
      public double getCost(){
         return this.totalCost;
      }
   	
      public void resetCost(){
         this.totalCost = 0;
      }
      
      public int[][] getMatrix(){
         return matrix;
      }
      
      public void setMatrix(int[][] theMatrix){
         this.matrix = theMatrix;
      }
   
   
   }