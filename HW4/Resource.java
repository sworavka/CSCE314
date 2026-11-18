import java.util.HashSet;
import java.util.Set;

public abstract class Resource implements Reservable {
    private String id;
    private String name;
    private boolean isReserved;
    private HashSet<String> features;
    private static int resourceCount = 0;
    private String reservedBy;

        public Resource(String id, String name) {
            this.id = id;
            this.name = name;
            this.isReserved = false;
            this.reservedBy = null;
            resourceCount++;
        }

        public static int getResourceCount() {
            return resourceCount;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public abstract String getType();

        public String getDescription() {
            return "Resource ID: " + id + ", Name: " + name + ", Type: " + getType();
        }

        public void addFeature(String feature) {
            if (features == null) {
                features = new HashSet<>();
            }
            features.add(feature);
        }

        public Set<String> getFeatures() {
            return features;
        }

        @Override
        public synchronized void reserve(String user) throws ResourceUnavailableException {
            if (isReserved) {
                throw new ResourceUnavailableException("Already reserved.");
            }
            reservedBy = user;
            isReserved = true;
        }

        @Override
        public synchronized void release() {
            reservedBy = null;
            isReserved = false;
        }

        @Override
        public synchronized boolean isReserved() {
            return isReserved;
        }

        @Override
        public String getReservedBy() {
            return reservedBy;
        }
    }
