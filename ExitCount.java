public class ExitCount 
{
	
		 private boolean ExitMade;
		 public void ExitCount()
		 {
		   this.ExitMade = false;
		 }
	     public void setStarCreated()
	     {
	      this.ExitMade = true;
		 }    
		 public boolean checkExitMade()
		 {
		  return this.ExitMade;
		 }   
	     public void ExitCountReset()
	     {
		   this.ExitMade = false;
		 }
	
}

