public class Dominoes {
    public static String[] createSet() {
        return createSet(6);
    }
    public static String[] createSet(int maxPips){
        String[] set = new String[(maxPips + 1) * (maxPips + 2) / 2];
        int index = 0;
        for (int i = 0; i <= maxPips; i++) {
            for (int j = i; j <= maxPips; j++) {
                set[index++] = "[" + i + "|" + j + "]";
            }
        }
        return set;
    }
    public static void main(String[] args){
        String[] dominoSet = createSet(6);
        for(String domino : dominoSet){
            System.out.println(domino);
        }
    }
}
