/*Построить программу для работы с классом "Время".Программа
должна обеспечивать простейшие функции:увеличение/уменьшение
на 1 час, минуту, секунду, ввод значений, вывод значений. */

import java.util.Objects;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.print("Введите время(в формате 00:00:00): ");
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        Time t1 = new Time(str);
        System.out.print("Начальное время: ");
        System.out.println(t1.show());
        t1.increase_seconds();
        t1.increase_minutes();
        t1.increase_hours();
        System.out.print("Начальное время увеличенное на 1 час, 1 минуту и 1 секунду: ");
        System.out.println(t1.show());
        Time t2 = new Time();
        t2 = t1.clone();
        System.out.print("Клонированное время: ");
        System.out.println(t2.show());
        t2.decrease_seconds();
        t2.decrease_minutes();
        t2.decrease_hours();
        System.out.print("Клонированное время уменьшенное на 1 час, 1 минуту и 1 секунду: ");
        System.out.println(t2.show());
        if (t1.equals(t2)) {
            if (t1.hashCode() == t2.hashCode()) {
                System.out.println("Объекты равны.");
            } else {
                System.out.println("Объекты не равны.");
            }
        } else {
            System.out.println("Объекты не равны.");
        }
        System.out.println(t1.toString());
        System.out.println(t2.toString());
    }

    /** DateTime representing methods for working with time*/
    interface DateTime{
        void increase_hours();
        void decrease_hours();
        void increase_minutes();
        void decrease_minutes();
        void increase_seconds();
        void decrease_seconds();
        String show();
    }

    /** The class is used to store objects with properties
     *  * <b>hours</b>,<b>minutes</b> и <b>secondes</b>.
     *  * @author Dudchenko Liudmila
     */
     static class Time implements Cloneable, DateTime{
        /**Seconds*/
        private int seconds;
        /**Minutes*/
        private int minutes;
        /**Hours*/
        private int hours;
        /** It creates a new empty object
         *@see Time#Time()
         */
        Time(){
            hours = 0;
            minutes = 0;
            seconds = 0;
        }

        /** It creates a new object with the given values
         * @param h - hours
         * @param min - minutes
         * @param sec - seconds
         * @see Time#Time(int,int,int)
         */
        Time(int h,int min, int sec){
            hours = (h>23||h<0)?0:h;
            minutes = (min>23||min<0)?0:min;
            seconds = (sec>23||sec<0)?0:sec;
        }
        /** It creates a new object with the given values
         * @param time - time string
         * @see Time#Time(String)
         */
        Time(String time){
            String[] substr;
            String delimeter = ":";
            substr = time.split(delimeter);
            hours = (Integer.parseInt(substr[0])>23||Integer.parseInt(substr[0])<0)?0:Integer.parseInt(substr[0]);
            minutes = (Integer.parseInt(substr[1])>59||Integer.parseInt(substr[1])<0)?0:Integer.parseInt(substr[1]);
            seconds = (Integer.parseInt(substr[2])>59||Integer.parseInt(substr[2])<0)?0:Integer.parseInt(substr[2]);
        }

        /** Function for increasing field value {@link Time#hours}
         */
        public void increase_hours(){
            hours++;
            if(hours>=24){
                hours=0;
            }
        }

        /** Function for decreasing field value {@link Time#hours}
         */
        public void decrease_hours() {
            hours--;
            if (hours < 0) {
                hours = 23;
            }
        }
        /** Function for increasing field value {@link Time#minutes}
         */
        public void increase_minutes() {
            minutes++;
            if (minutes >= 60) {
                hours++;
                minutes = 0;
                if(hours>=24){
                    hours=0;
                }
            }
        }
        /** Function for decreasing field value {@link Time#minutes}
         */
        public void decrease_minutes() {
            minutes--;
            if (minutes < 0) {
                hours--;
                minutes = 59;
                if (hours < 0) {
                    hours = 23;
                }
            }
        }
        /** Function for increasing field value {@link Time#seconds}
         */
        public void increase_seconds() {
            seconds++;
            if (seconds >= 60) {
                minutes++;
                seconds = 0;
                if (minutes >= 60) {
                    hours++;
                    minutes = 0;
                    if(hours>=24){
                        hours=0;
                    }
                }
            }
        }
        /** Function for decreasing field value {@link Time#seconds}
         */
        public void decrease_seconds() {
            seconds--;
            if (seconds < 0) {
                minutes--;
                seconds = 59;
                if (minutes < 0) {
                    hours--;
                    minutes = 59;
                    if (hours < 0) {
                        hours = 23;
                    }
                }
            }
        }

        /** Function for getting field values {@link Time#seconds},{@link Time#minutes},{@link Time#hours}
         * @return It returns the time value
         */
        public String show(){
            String str_h = Integer.toString(hours);
            if(str_h.toCharArray().length==1) {
                str_h="0"+str_h;
            }
            String str_m = Integer.toString(minutes);
            if(str_m.toCharArray().length==1) {
                str_m="0"+str_m;
            }
            String str_s = Integer.toString(seconds);
            if(str_s.toCharArray().length==1) {
                str_s="0"+str_s;
            }
                return str_h+":"+str_m+":"+str_s;
            
        }
        /** Function for getting a copy of an object
         * @throws CloneNotSupportedException if the class that the cloned object belongs to does not enforce the Cloneable interface
         * @return It returns an object of type Time
         */
        public Time clone() throws CloneNotSupportedException{
            return (Time) super.clone();
        }
        /** Function for comparing objects
         * @return It returns a boolean value according to equality or inequality of objects
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Time time = (Time) o;
            return seconds == time.seconds &&
                    minutes == time.minutes &&
                    hours == time.hours;
        }

        /** Function for getting table hash code
         * @return It returns the boolean value of the hash code
         */
        @Override
        public int hashCode() {
            return Objects.hash(seconds, minutes, hours);
        }

        /** Function for getting information about an object
         * @return It returns a string containing the values of all fields of the object
         */
        @Override
        public String toString() {
            return "Time{" +
                    "hours=" + hours +
                    ", minutes=" + minutes +
                    ",seconds=" + seconds +
                    '}';
        }
    }

}
