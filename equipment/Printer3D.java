public class Printer3D
    extends Equipment
    implements Reservable {
        private String reservedBy = null;
        public Printer3D(String name) {
            super(name);
        }
        @Override
        public String use(){
            return "Printing a 3D model";
        }

        @Override
        public void reserve(String studentName) {
            if(reservedBy != null){
                throw new IllegalStateException("Printer is already reserved");
            } else {
            reservedBy = studentName;
            }
        }
        @Override
        public String getReservedBy() {
            return reservedBy;
        }
        @Override
        public void returnItem() {
            reservedBy = null;
        }
    }