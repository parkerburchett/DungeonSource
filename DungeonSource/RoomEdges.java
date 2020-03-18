// this method will print room to the screen if you pass in the thing in the room and its x and y cords

public class RoomEdges
{   
   private static String horizontalDoor = "* - *\n";
   private static String horizontalWall = "* * *\n";
   private static String setMidRightDoor(String str) {return "* " + str + " |\n";}
   private static String setMidBothDoor(String str) {return "| " + str + " |\n";}
   private static String setMidLeftDoor(String str) {return "| " + str + " *\n";}
       
   public static String roomChooser(int xCord, int yCord, String center)
   {
      // Pass in the symbol for what you want in the center of the door and the cordinates of the room into the RoomChooser Method 
      // Corner Logic
      if(xCord== 0 && yCord == 0) {return topLeftCorner(center);}
      else if(xCord== 4 && yCord == 0) {return topRightCorner(center);}  
      else if(xCord== 0 && yCord == 4) {return botLeftCorner(center);}
      else if(xCord== 4 && yCord == 4) {return botRightCorner(center);}
      // At this point the room is not a corner
      // Edge Logic
      else if(xCord == 0) {return leftEdge(center);}   
      else if(xCord == 4) {return rightEdge(center);}    
      else if(yCord == 0) {return topEdge(center);}   
      else if(yCord == 4) {return botEdge(center);}
      // at this point the room is a center room
      else {return centerRoom(center);}
   }   

   public static String topLeftCorner(String obj)   // I don't know how the statics work. I get an error when it is non static but I don't know what to do to fix ti
   {
      String top = horizontalWall;
      String mid = setMidRightDoor(obj); 
      String bot = horizontalDoor;
      return top + mid + bot;
   }
     
   public static String topRightCorner(String obj)
   {
      String top = horizontalWall;
      String mid = setMidLeftDoor(obj); 
      String bot = horizontalDoor;
      return top + mid + bot;
   }
   public static String botLeftCorner(String obj)
   {
      String top = horizontalDoor;
      String mid = setMidRightDoor(obj); 
      String bot = horizontalWall;
      return top + mid + bot;
   }

   public static String botRightCorner(String obj)
   {
      String top = horizontalDoor;
      String mid = setMidLeftDoor(obj); 
      String bot = horizontalWall;
      return top + mid + bot;
   }
   
   public static String centerRoom(String obj)
   {
      String top = horizontalDoor;
      String mid = setMidBothDoor(obj); 
      String bot = horizontalDoor;
      return top + mid + bot;
   }
   
   public static String leftEdge(String obj)
   {
      String top = horizontalDoor;
      String mid = setMidRightDoor(obj); 
      String bot = horizontalDoor;
      return top + mid + bot;
   }
   public static String rightEdge(String obj)
   {
      String top = horizontalDoor;
      String mid = setMidLeftDoor(obj); 
      String bot = horizontalDoor;
      return top + mid + bot;
   }
   
   public static String topEdge(String obj)
   {
      String top = horizontalWall;
      String mid = setMidBothDoor(obj); 
      String bot = horizontalDoor;
      return top + mid + bot;
   }
   
   public static String botEdge(String obj)
   {
      String top = horizontalDoor;
      String mid = setMidBothDoor(obj); 
      String bot = horizontalWall;
      return top + mid + bot;
   }
}