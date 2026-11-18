import java.util.ArrayList;
import java.util.HashMap;

public class RoomCatalog {
    private HashMap<String, StudyRoom> rooms;
    
    public RoomCatalog(){
        rooms = new HashMap<>();
    }
    public boolean addRoom(StudyRoom room){
        if(rooms.containsKey(room.getId())){
            return false;
        }
        rooms.put(room.getId(), room);
        return true;
    }
    public StudyRoom getRoom(String id){
        return rooms.get(id);
    }
    public int size(){
        return rooms.size();
    }
    public ArrayList<StudyRoom> getAllRooms(){
        return new ArrayList<>(rooms.values());
    }
}
