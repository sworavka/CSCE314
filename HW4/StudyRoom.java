public class StudyRoom extends Resource{
    private int capacity;

    public StudyRoom( String id,String name,int capacity){
        super(id,name);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getType() {
        return "Study Room";
    }
}
