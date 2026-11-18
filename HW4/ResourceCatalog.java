import java.util.HashMap;
import java.util.ArrayList;

public class ResourceCatalog<T extends Resource> {
    private HashMap<String, T> resources;

    public void add(T resource) throws DuplicateResourceException {
        if (resources == null) {
            resources = new HashMap<>();
        }
        if (resources.containsKey(resource.getId())) {
            throw new DuplicateResourceException("Resource with ID " + resource.getId() + " already exists.");
        }
        resources.put(resource.getId(), resource);
    }

    public T getById(String id) {
        return resources.get(id);
    }

    public int size() {
        return resources.size();
    }

    public ArrayList<T> getAll() {
        ArrayList<T> catalog = new ArrayList<>();
        for (T resource : resources.values()) {
            catalog.add(resource);
        }
        return catalog;
    }
}
