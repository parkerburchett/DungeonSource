// this method will print room to the screen if you pass in the thing in the room and its x and y cords

public class RoomEdges
{   
   public static String horizontalDoor = "* - *\n";
   public static String horizontalWall = "* * *\n";
   public static String setMidRightDoor(String str){return "* " + str + " |\n";}
   public static String setMidBothDoor(String str) {return "| " + str + " |\n";}
   public static String setMidLeftDoor(String str){return "| " + str + " *\n";}
       
   public String RoomChooser(String thingInRoom, int xCord, int yCord)
   {
   // Pass in the symbol for what you want in the center of the door and the cordinates of the room into the RoomChooser Method 
   // DoorChooser will return the proper String repersentation of the door.
      return null;
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