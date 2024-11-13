package model;

public class SuiteRoom extends Room {
	public SuiteRoom(int roomId, double price) {
        setRoomId(roomId);
        setRoomType("Suite Room");
        setPrice(price);
        setAvailablity(true);
    }
}
