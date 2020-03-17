
public abstract class RoomItems 
{
 private String description;
 public RoomItems(String description)
 {
	 this.setDescription(description);
 }
 public String getDescription()
 {
	return description;
 }
 public void setDescription(String description)
 {
	this.description = description;
 }
 public void ToString()
 {
	 description=(description.toString());
	 System.out.print(description);
 }
}
