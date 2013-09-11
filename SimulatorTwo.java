    import java.util.Random;

/**
 @author:	Matthew J Swann
 @version:	1.0, Last Modified: 2012-09-03
 
 */
 
   public class SimulatorTwo{
   
   
   	// Variables for layered iterations and move tracking.
      public int externalIterations, internalIterations,
      				totalMoves, movesAccepted;
   	// Controls alpha.
      public double moveControl,
      				initialTemp, currentTemp,
      				currentSolution, bestSolution,
      				bestX, bestY;
      // FunctionTwo object.				
      public FunctionTwo FxTwo;				
   	
   
   
      public SimulatorTwo(double initialTemp, int externalIterations,
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
         Random rand = new Random();
         
         double x = rand.nextDouble();
         if(rand.nextBoolean() == false){
            x = 0 - x;
         }
         
         double y = rand.nextDouble();
         if(rand.nextBoolean() == false){
            y = 0 - y;
         }
         
         FxTwo = new FunctionTwo(x, y);
         this.bestSolution = FxTwo.solve(); 
         this.bestX = FxTwo.getX();
         this.bestY = FxTwo.getY();  
      }
      
   	
   /**
    SA functionality.
    */
      public void SA(){
      
      // External Loop.
         for(int i = 0; i < externalIterations; i++){
         
         // Internal Loop.
            for(int j = 0; j < internalIterations; j++){
            
               double currentX = FxTwo.getX();
               double currentY = FxTwo.getY();
               
               this.randomStep();
               this.currentSolution = FxTwo.solve();
               
               if(currentSolution < bestSolution){
                  this.bestSolution = this.currentSolution;
                  this.bestX = FxTwo.getX();
                  this.bestY = FxTwo.getY();
                  this.totalMoves++;
                  this.movesAccepted++;
               }
               
               else{
                  Random rand = new Random();
                  double randCheck = rand.nextDouble();
                  if(randCheck > Math.exp((0-(currentSolution-bestSolution))/currentTemp)){
                     FxTwo.setVars(currentX, currentY);
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
         Random rand = new Random();
         double tempX = FxTwo.getX();
         double tempY = FxTwo.getY();
      
         double x = rand.nextDouble();
         if(rand.nextBoolean() == false){
            tempX -= x*currentTemp/initialTemp;
         }
         else{
            tempX += x*currentTemp/initialTemp;
         }
      
         double y = rand.nextDouble();
         if(rand.nextBoolean() == false){
            tempY -= x*currentTemp/initialTemp;
         }
         else{
            tempY += x*currentTemp/initialTemp;
         }
      
         tempX = this.checkX(tempX);
         tempY = this.checkY(tempY);
      
         FxTwo.setVars(tempX, tempY);
      } 
   
   
   /**
    Keeps integrity: -2 <= x <= +3.
    */
      private double checkX(double x){
         if(x >= 3){
            x -= 5;
            return x;
         }
         else if(x <= -2){
            x += 5;
            return x;
         }
         else{
            return x;
         }
      }
   
   
   /**
    Keeps integrity: -2 <= y <= +3.
    */
      private double checkY(double y){
         if(y >= 3){
            y -= 5;
            return y;
         }
         else if(y <= -2){
            y += 5;
            return y;
         }
         else{
            return y;
         }
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
      
      public double getBestX(){
         return bestX;
      } 
   	
      public double getBestY(){
         return bestY;
      }
      
      public int getTotalMoves(){
         return totalMoves;
      }
   	
      public int getMovesAccepted(){
         return movesAccepted;
      }
   	   						
   }