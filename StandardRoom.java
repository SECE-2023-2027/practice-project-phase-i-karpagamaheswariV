package model;

public class StandardRoom extends Room{
    public StandardRoom(int roomId,double price) {
    	 setRoomId(roomId);
         setRoomType("Standard Room");
         setPrice(price);
         setAvailablity(true);
    }
}
