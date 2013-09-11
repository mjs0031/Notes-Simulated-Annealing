   import java.util.Random;

/**
 @author:	Matthew J Swann
 @version:	1.0, Last Modified: 2012-09-03
 
 */
 
   public class Simulator{
   
   
   	// Variables for layered iterations and move tracking.
      public int externalIterations, internalIterations,
      				totalMoves, movesAccepted;
   	// Controls alpha.
      public double moveControl,
      				initialTemp, currentTemp,
      				currentSolution, bestSolution;
      // Matrix repository.
      public int[][] currentMatrix, bestMatrix;
      // FunctionOne object.				
      public FunctionOne FxOne;				
   	
   
   
      public Simulator(double initialTemp, int externalIterations,
      						int internalIterations, double moveControl){
         this.initialTemp = initialTemp;
         this.currentTemp = initialTemp;
         this.externalIterations = externalIterations;
         this.internalIterations = internalIterations;
         this.moveControl = moveControl;
      
         this.setup();
      }  
   
   /**
    Sets up initial solution via random gernation.
    */   
      public void setup(){
         FxOne = new FunctionOne();
         FxOne.solve();
         this.bestSolution = FxOne.getCost();
         this.bestMatrix = FxOne.getMatrix();  
      }
      
   	
   /**
    SA functionality.
    */
      public void SA(){
      
      // External Loop.
         for(int i = 0; i < externalIterations; i++){
         
         // Internal Loop.
            for(int j = 0; j < internalIterations; j++){
            
               this.currentMatrix = FxOne.getMatrix();  
            	
               this.randomStep();
               this.currentSolution = FxOne.solve();
               FxOne.resetCost();
               
               if(this.currentSolution < this.bestSolution){
                  this.bestSolution = this.currentSolution;
                  this.bestMatrix = FxOne.getMatrix();
                  this.totalMoves++;
                  this.movesAccepted++;
               }
               
               else{
                  Random rand = new Random();
                  double randCheck = rand.nextDouble();
                  if(randCheck > Math.exp((0-(currentSolution-bestSolution))/currentTemp)){
                     FxOne.setMatrix(this.currentMatrix);
                     this.totalMoves++;
                  }
                  
                  else{
                     this.totalMoves++;
                     this.movesAccepted++;
                  }
               }
            }
            
            this.currentTemp *= moveControl;
         }
      }
      
      public void SATwo(){
      
      // External Loop.
         while(this.currentTemp > 5){
         
         // Internal Loop.
            for(int j = 0; j < internalIterations; j++){
            
               this.currentMatrix = FxOne.getMatrix();  
            	
               this.randomStep();
               this.currentSolution = FxOne.solve();
               FxOne.resetCost();
               
               if(this.currentSolution < this.bestSolution){
                  this.bestSolution = this.currentSolution;
                  this.bestMatrix = FxOne.getMatrix();
                  this.totalMoves++;
                  this.movesAccepted++;
               }
               
               else{
                  Random rand = new Random();
                  double randCheck = rand.nextDouble();
                  if(randCheck > Math.exp((0-(currentSolution-bestSolution))/currentTemp)){
                     FxOne.setMatrix(this.currentMatrix);
                     this.totalMoves++;
                  }
                  
                  else{
                     this.totalMoves++;
                     this.movesAccepted++;
                  }
               }
            }
            
            this.currentTemp *= moveControl;
         }
      }
    
     
   /**
    Random step influenced by proportion of currentTemp and initial.
    */  
      public void randomStep(){
      
         int mutationDegree = (int)(10*currentTemp/initialTemp) + 1;
         FxOne.mutateMatrix(mutationDegree);
      } 
   
   
   /**
    Nonsense return functions.
    */	
      public double getCurrentTemp(){
         return this.currentTemp;
      }
      
      public double getBestSolution(){
         return bestSolution;
      }
      
      public int[][] getBestMatrix(){
         return bestMatrix;
      } 
      
      public int getTotalMoves(){
         return totalMoves;
      }
   	
      public int getMovesAccepted(){
         return movesAccepted;
      }
   	   						
   }