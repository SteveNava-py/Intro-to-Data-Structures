package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainVII {

    public static void main(String[] args) {
        //serialization.MainVII.Employee e1 = new serialization.MainVII.Employee("Tyronus Magnus", "27th ward", 6969696, 420);
        //SerializeObject(e1);
        System.out.println(Deserialize());
    }

    public static void SerializeObject (Employee e) {
        try {
            FileOutputStream file = new FileOutputStream("C:\\Users\\Steet\\OneDrive\\Year 2\\employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(e);
            out.close();
            file.close();
            System.out.println("sensational...");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

        public static Employee Deserialize() {
            Employee e1;
            try {
                FileInputStream fileIn = new FileInputStream("C:\\Users\\Steet\\OneDrive\\Year 2\\employee.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                e1 = (Employee)in.readObject();
                fileIn.close();
                in.close();
                return e1;
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return null;
        }

    public static class Employee {
        private String name;
        private String address;
        private transient int SSN;
        private long EID;

        public Employee(String name, String address, int SSN, long EID) {
            this.name = name;
            this.address = address;
            this.SSN = SSN;
            this.EID = EID;
        }

        public String toString(){
            return "serialization.MainVII.Employee name is: " + this.name + " Address: " + this.address + " SSN: " + this.SSN + " serialization.MainVII.Employee ID: " + this.EID ;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getSSN() {
            return SSN;
        }

        public void setSSN(int SSN) {
            this.SSN = SSN;
        }

        public long getEID() {
            return EID;
        }

        public void setEID(long EID) {
            this.EID = EID;
        }
    }
}

