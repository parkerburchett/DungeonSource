
public class EntranceCount 
{
	
		 private boolean EntranceMade;
		 public void EntranceCount()
		 {
		   this.EntranceMade = false;
		 }
	     public void setStarCreated()
	     {
	      this.EntranceMade = true;
		 }    
		 public boolean checkEntranceMade()
		 {
		  return this.EntranceMade;
		 }   
	     public void EntranceCountReset()
	     {
		   this.EntranceMade = false;
		 }
	
}
