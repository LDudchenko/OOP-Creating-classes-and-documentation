/*Создать класс записной книжки (поля: имя, Ник, мобильный
телефон, адрес электронной почты, номер ICQ). */
import java.util.Objects;


public class Task17 {
    public static void main(String[]args) throws CloneNotSupportedException{
        Notebook nb1 = new Notebook("Петр","Iv","0509878576","ivan@gmail.com",123);
        System.out.print("Объект созданный с помощью конструктора с параметрами: ");
        nb1.show_info();
        Notebook nb2 = nb1.clone();
        System.out.print("Объект созданный с помощью клонирования: ");
        nb2.show_info();
        System.out.print("Объект с изменённым полем: ");
        nb2.edit_note(1,"Павел");
        nb2.show_info();
        if (nb2.equals(nb1)) {
            if (nb2.hashCode() == nb1.hashCode()) {
                System.out.println("Объекты равны:");
            } else {
                System.out.println("Обьекты не равны:");
            }
        } else {
            System.out.println("Обьекты не равны:");
        }
        System.out.println(nb1.toString()+'\n'+nb2.toString());
    }

    /**
     * Interface Notes representing work with  different notes
     */
    interface Notes{
        void show_info();
        void edit_note(int num, String value);
    }

    /**
     * The class is used to store objects with properties
     * * <b>name</b>,<b>nik</b>, <b>number_phone</b>, <b>email_address</b> и <b>number_ICQ</b>.
     * * @author Dudchenko Liudmila
     */
    public static class Notebook implements Cloneable, Notes{
        /**Name*/
        private String name;
        /**Nik*/
        private String nik;
        /**Number_phone*/
        private String number_phone;
        /**Email_address*/
        private String email_address;
        /**Number_ICQ*/
        private int number_ICQ;
        /** It creates a new object with the given values
         * @param n - name
         * @param nk - nik
         * @param np - number_phone
         * @param ea - email_address
         * @param nI - number_ICQ
         * @see Notebook#Notebook(String,String,String,String,int)
         */
        Notebook(String n, String nk, String np, String ea, int nI){
            name = n;
            nik = nk;
            number_phone = np;
            email_address = ea;
            number_ICQ = nI;
        }
        /** It creates a new empty object
         *@see Notebook#Notebook()
         */
        Notebook(){
            name = null;
            nik = null;
            number_phone = null;
            email_address = null;
            number_ICQ = 0;
        }
        /** Function for comparing objects
         * @return It returns a boolean value according to equality or inequality of objects
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Notebook notebook = (Notebook) o;
            return number_ICQ == notebook.number_ICQ &&
                    Objects.equals(name, notebook.name) &&
                    Objects.equals(nik, notebook.nik) &&
                    Objects.equals(number_phone, notebook.number_phone) &&
                    Objects.equals(email_address, notebook.email_address);
        }
        /** Function for getting table hash code
         * @return It returns the boolean value of the hash code
         */
        @Override
        public int hashCode() {
            return Objects.hash(name, nik, number_phone, email_address, number_ICQ);
        }
        /** Function for getting information about an object
         * @return It returns a string containing the values of all fields of the object
         */
        @Override
        public String toString() {
            return "Notebook{" +
                    "name='" + name + '\'' +
                    ", nik='" + nik + '\'' +
                    ", number_phone='" + number_phone + '\'' +
                    ", email_address='" + email_address + '\'' +
                    ", number_ICQ=" + number_ICQ +
                    '}';
        }
        /** Function for showing field values {@link Notebook#name},{@link Notebook#nik},{@link Notebook#number_phone},{@link Notebook#email_address},{@link Notebook#number_ICQ}
         */
        public void show_info(){
            System.out.println(name+": "+ nik+", "+number_phone+", "+email_address+", "+number_ICQ+'.');
        }

        /**
         * Function for changing parts of note according to their number
         * @param num
         * @param value
         */
        public void edit_note(int num, String value){
            switch(num){
                case 1: {
                    this.name = value;
                    break;
                }
                case 2:{
                    this.nik = value;
                    break;
                }
                case 3:{
                    this.number_phone = value;
                    break;
                }
                case 4:{
                    this.email_address = value;
                    break;
                }
                case 5:{
                    this.number_ICQ = Integer.parseInt(value);
                    break;
                }
            }
        }
        /** Function for getting value of field {@link Notebook#name}
         * @return It returns name
         */
        public String getName() {
            return name;
        }
        /** Function for setting value of field {@link Notebook#name}
         */
        public void setName(String name) {
            this.name = name;
        }
        /** Function for getting value of field {@link Notebook#number_phone}
         * @return It returns number_phone
         */
        public String getNumber_phone() {
            return number_phone;
        }
        /** Function for setting value of field {@link Notebook#number_phone}
         */
        public void setNumber_phone(String number_phone) {
            this.number_phone = number_phone;
        }
        /** Function for getting value of field {@link Notebook#nik}
         * @return It returns nik
         */
        public String getNik() {
            return nik;
        }
        /** Function for setting value of field {@link Notebook#nik}
         */
        public void setNik(String nik) {
            this.nik = nik;
        }
        /** Function for getting value of field {@link Notebook#email_address}
         * @return It returns email address
         */
        public String getEmail_address() {
            return email_address;
        }
        /** Function for setting value of field {@link Notebook#email_address}
         */
        public void setEmail_address(String email_address) {
            this.email_address = email_address;
        }
        /** Function for getting value of field {@link Notebook#number_ICQ}
         * @return It returns number ICQ
         */
        public int getNumber_ICQ() {
            return number_ICQ;
        }
        /** Function for setting value of field {@link Notebook#number_ICQ}
         */
        public void setNumber_ICQ(int number_ICQ) {
            this.number_ICQ = number_ICQ;
        }
        /** Function for getting a copy of an object
         * @throws CloneNotSupportedException if the class that the cloned object belongs to does not enforce the Cloneable interface
         * @return It returns an object of type Time
         */
        public Notebook clone() throws CloneNotSupportedException{
            return (Notebook) super.clone();
        }
    }
}
