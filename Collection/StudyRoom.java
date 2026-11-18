// package HW4;
import java.util.HashSet;
import java.util.Set;

public class StudyRoom {
    private int capacity;
    private String id;
    private String name;
    private String reservedBy;
    private HashSet<String> features;
    private boolean isReserved;


    public StudyRoom( String id,String name,int capacity){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.isReserved = false;
        this.features= new HashSet<>();
        // this.reservedBy = null; //check if autograder complains
    }
    public String getId(){ return id;}

    public String getName() { return name;}

    public int getCapacity(){ return capacity;}

    public void addFeature(String feature){
        this.features.add(feature);
    }

    public Set<String> getFeatures() {return features;}

    public synchronized boolean reserve(String user){
        if(!isReserved){
            reservedBy = user;
            isReserved = true;
            return true;
        } else{
            return false;
        }
    }

    public synchronized void release(){
        isReserved = false;
        reservedBy = null;
    }

    public synchronized String getReservedBy(){
        return reservedBy;
    }

    public synchronized boolean isReserved() {
        return isReserved;
    }
        

    
}
