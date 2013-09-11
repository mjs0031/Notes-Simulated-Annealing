   import java.io.*;

/**
 @author:	Matthew J Swann
 @version:	1.0, Last Modified 2012-09-03
 
 */
   
   public class Harness{
   
      public static void main(String[] args) throws IOException{
      
         double[][] outputTwoEx = new double[5][4];
         double[][] outputTwoIn = new double[5][4];
         double[][] outputTwoAlpha = new double[5][4];
         
         double[][] outputOneEx = new double[5][2];
         double[][] outputOneIn = new double[5][2];
         double[][] outputOneAlpha = new double[5][2];
      
      /**
       ------------------------------
       FUNCTION TWO BLOCK  
       ------------------------------
       */
      /**
        // FunctionTwo - EXTERNAL Variance.
         for(int i = 200; i <= 1000; i+=200){
            
            double average = 0;
            double bestFx = 0;
            double bestX = 0;
            double bestY = 0;
            
            for(int j = 0; j < 10; j++){
            
               SimulatorTwo test = new SimulatorTwo(100, i, 500, .95);
               test.SA();
               average += test.getBestSolution();
               
               if(test.getBestSolution() < bestFx){
                  bestFx = test.getBestSolution();
                  bestX = test.getBestX();
                  bestY = test.getBestY();
               }
            }
            
            int index = 0;
            int tracker = i;
            while(tracker > 0){
               index++;
               tracker -= 200;
            }
            
            outputTwoEx[index-1][0] = average/10;
            outputTwoEx[index-1][1] = bestFx;
            outputTwoEx[index-1][2] = bestX;
            outputTwoEx[index-1][3] = bestY;
         
         }
         
        // FunctionTwo - INTERNAL Variance.
         for(int i = 200; i <= 1000; i+=200){
            
            double average = 0;
            double bestFx = 0;
            double bestX = 0;
            double bestY = 0;
            
            for(int j = 0; j < 10; j++){
            
               SimulatorTwo test = new SimulatorTwo(100, 500, i, .95);
               test.SA();
               average += test.getBestSolution();
               
               if(test.getBestSolution() < bestFx){
                  bestFx = test.getBestSolution();
                  bestX = test.getBestX();
                  bestY = test.getBestY();
               }
            }
            
            int index = 0;
            int tracker = i;
            while(tracker > 0){
               index++;
               tracker -= 200;
            }
            
            outputTwoIn[index-1][0] = average/10;
            outputTwoIn[index-1][1] = bestFx;
            outputTwoIn[index-1][2] = bestX;
            outputTwoIn[index-1][3] = bestY;
         
         }
         
      	
        // FunctionTwo - ALPHA Variance.
         for(int i = 49; i <= 89; i+=10){
            
            double average = 0;
            double bestFx = 0;
            double bestX = 0;
            double bestY = 0;
            
            for(int j = 0; j < 10; j++){
            
               SimulatorTwo test = new SimulatorTwo(100, 500, 500, (i/100));
               test.SA();
               average += test.getBestSolution();
               
               if(test.getBestSolution() < bestFx){
                  bestFx = test.getBestSolution();
                  bestX = test.getBestX();
                  bestY = test.getBestY();
               }
            }
            
            int index = 0;
            int tracker = i-49;
            while(tracker > 0){
               index++;
               tracker -= 10;
            }
            
            outputTwoAlpha[index][0] = average/10;
            outputTwoAlpha[index][1] = bestFx;
            outputTwoAlpha[index][2] = bestX;
            outputTwoAlpha[index][3] = bestY;
         
         }
      */
      
      /**
       ------------------------------
       FUNCTION ONE BLOCK  
       ------------------------------
       */
      
        // FunctionOne - EXTERNAL Variance.
         for(int i = 20; i <= 100; i+=20){
            
            double average = 0;
            double bestFx = 100000;
            int[][] bestMatrix = new int[5][3];
            
            for(int j = 0; j < 10; j++){
            
               Simulator test = new Simulator(100, i, 25, .95);
               test.SA();
               average += test.getBestSolution();
               if(bestMatrix[0][0] == 0){
                  bestMatrix = test.getBestMatrix();
               }
               
               if(test.getBestSolution() < bestFx){
                  bestFx = test.getBestSolution();
                  bestMatrix = test.getBestMatrix();
               }
            }
            
            int index = 0;
            int tracker = i;
            while(tracker > 0){
               index++;
               tracker -= 20;
            }
            
            outputOneEx[index-1][0] = average/10;
            outputOneEx[index-1][1] = bestFx;
         }
      
       // FunctionOne - Internal Variance.
         for(int i = 20; i <= 100; i+=20){
            
            double average = 0;
            double bestFx = 100000;
            int[][] bestMatrix = new int[5][3];
            
            for(int j = 0; j < 10; j++){
            
               Simulator test = new Simulator(100, i, 25, .95);
               test.SA();
               average += test.getBestSolution();
               if(bestMatrix[0][0] == 0){
                  bestMatrix = test.getBestMatrix();
               }
               
               if(test.getBestSolution() < bestFx){
                  bestFx = test.getBestSolution();
                  bestMatrix = test.getBestMatrix();
               }
            }
            
            int index = 0;
            int tracker = i;
            while(tracker > 0){
               index++;
               tracker -= 20;
            }
            
            outputOneIn[index-1][0] = average/10;
            outputOneIn[index-1][1] = bestFx;
         }         
      	
      	
        // FunctionOne - ALPHA Variance.
         for(int i = 20; i <= 100; i+=20){
            
            double average = 0;
            double bestFx = 100000;
            int[][] bestMatrix = new int[5][3];
            
            for(int j = 0; j < 10; j++){
            
               Simulator test = new Simulator(100, i, 25, .95);
               test.SATwo();
               average += test.getBestSolution();
               if(bestMatrix[0][0] == 0){
                  bestMatrix = test.getBestMatrix();
               }
               
               if(test.getBestSolution() < bestFx){
                  bestFx = test.getBestSolution();
                  bestMatrix = test.getBestMatrix();
               }
            }
            
            int index = 0;
            int tracker = i;
            while(tracker > 0){
               index++;
               tracker -= 20;
            }
            
            outputOneAlpha[index-1][0] = average/10;
            outputOneAlpha[index-1][1] = bestFx;
         }
      
      
      /**
       ------------------------------
       OUTPUT BLOCK  
       ------------------------------
       */
       
      /** 
         String algOneData = "External: 200+ Iterations\n";
         algOneData += "200, 400, 600, 800, 1000\n";
         
         for(int j = 0; j < 4; j++){
            for(int i = 0; i < 5; i++){
               algOneData+= outputTwoEx[i][j]+", ";
            }
            algOneData += "\n"; 
         }
      
      
         
         String algTwoData = "Internal: 200+ Iterations\n";
         algTwoData += "200, 400, 600, 800, 1000\n";
         
         for(int j = 0; j < 4; j++){
            for(int i = 0; i < 5; i++){
               algTwoData+= outputTwoIn[i][j]+", ";
            }
            algTwoData += "\n"; 
         }
         
      	
      	
         String algThreeData = "Alpha: 70+5 Iterations\n";
         algThreeData += "49, 59, 69, 79, 89\n";
         
         for(int j = 0; j < 4; j++){
            for(int i = 0; i < 5; i++){
               algThreeData+= outputTwoAlpha[i][j]+", ";
            }
            algThreeData += "\n"; 
         }
         
      	
         FileWriter fileWrite = new FileWriter("data.csv");
         fileWrite.append(algOneData+"\n");
         fileWrite.append(algTwoData+"\n");
         fileWrite.append(algThreeData+"\n");
         fileWrite.flush();
         fileWrite.close();
         
      	*/
      
         String algOneDataX = "External: 200+ Iterations\n";
         algOneDataX += "20, 40, 60, 80, 100\n";
         
         for(int j = 0; j < 2; j++){
            for(int i = 0; i < 5; i++){
               algOneDataX+= outputOneEx[i][j]+", ";
            }
            algOneDataX += "\n"; 
         }
      
         String algTwoDataX = "Internal: 200+ Iterations\n";
         algTwoDataX += "20, 40, 60, 80, 100\n";
         
         for(int j = 0; j < 2; j++){
            for(int i = 0; i < 5; i++){
               algTwoDataX+= outputOneIn[i][j]+", ";
            }
            algTwoDataX += "\n"; 
         } 
         
         String algThreeDataX = "While Temp > 5";
         algThreeDataX += "49, 59, 69, 79, 89\n";
         
         for(int j = 0; j < 2; j++){
            for(int i = 0; i < 5; i++){
               algThreeDataX+= outputOneAlpha[i][j]+", ";
            }
            algThreeDataX += "\n"; 
         }  
      	
         FileWriter fileWrite = new FileWriter("data_matrix.csv");
         fileWrite.append(algOneDataX+"\n");
         fileWrite.append(algTwoDataX+"\n");
         //fileWrite.append(algThreeData+"\n");
         fileWrite.flush();
         fileWrite.close();
      	
      }
   
   
   }