/**
 @author:	Matthew J Swann
 @version:	1.0, Last Modified 2012-09-03
 
 */
 
   public class FunctionTwo{
   
      public double x, y;
   
      public FunctionTwo(double x, double y ){
      
         this.x = x;
         this.y = y;
      
      }
      
      public double solve(){
         double result = (4-(2.1*x*x)+((x*x*x*x)/3))*x*x + x*y + 
            (-4+(4*y*y))*y*y;
      
         return result;		
      }
      
      public void setVars(double x, double y){
         this.x = x;
         this.y = y;
      
      }
      
      public double getX(){
         return x;
      }
   	
      public double getY(){
         return y;
      }
   
   
   }