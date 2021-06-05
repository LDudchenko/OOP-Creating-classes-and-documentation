/*Создать класс "Линия на экране", который имеет ширину и
высоту. Поля – координаты начала и конца. Функции-члены
вычисляют длину,устанавливает поля и возвращают значения,
перемещают линию, рисуют на экран. Функции-члены установки
полей класса должны проверять корректность  задаваемых параметров.*/

import java.util.Objects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Task15 {
    public static void main(String[] args) throws CloneNotSupportedException{
        LineAtScreen line1 = new LineAtScreen(3, 1, 8,1 );
        System.out.println("Length of the line: " + line1.length());
        line1.draw_line();
        line1.moving_line(-2,3);
        System.out.println();
        line1.draw_line();
        LineAtScreen line2 = new LineAtScreen();
        System.out.println();
        if (line1.equals(line2)) {
            if (line1.hashCode() == line2.hashCode()) {
                System.out.println("Объекты равны:");
            } else {
                System.out.println("Обьекты не равны:");
            }
        } else {
            System.out.println("Обьекты не равны:");
        }
        System.out.println(line1.toString());
        System.out.println(line2.toString());
    }
    /**
     * Interface Geometry_object representing work with  different geometry objects
     */
    interface Geometry_object {
        double length();
        void moving_line(int numx, int numy);
    }
    /**
     * The class is used to store objects with properties
     * * <b>size_of_field</b>,<b>x_start</b>,<b>y_start</b>, <b>x_end</b> и <b>y_end</b>.
     * * @author Dudchenko Liudmila
     */
     static class LineAtScreen implements Cloneable,Geometry_object{
        /**Size of fields*/
        int size_of_field = 10;
        /**X start*/
        int x_start;
        /**Y start*/
        int y_start;
        /**X end*/
        int x_end;
        /**Y end*/
        int y_end;

        /**
         * It creates a new object with the given values
         * @param xs - X start
         * @param ys - Y start
         * @param xe - X end
         * @param ye - Y end
         * @see LineAtScreen#LineAtScreen(int, int,int,int)
         */
        public LineAtScreen(int xs, int ys, int xe, int ye) {
            x_start = xs;
            y_start = ys;
            x_end = xe;
            y_end = ye;
        }

        /**
         *It creates a new empty object
         * @see LineAtScreen#LineAtScreen()
         */
        public LineAtScreen() {
            x_start = 1;
            y_start = 1;
            x_end = 1;
            y_end = 1;
        }

        /**
         * Function for getting the length of line
         * @return It returns the length
         */
        public double length() {
            return sqrt(pow(x_end - x_start, 2) + pow(y_end - y_start, 2));
        }

        /**
         * Function for moving line
         * @param numx - value for moving x
         * @param numy - value for moving y
         */
        public void moving_line(int numx,int numy){
            y_start = y_start + numy;
            if(y_start>size_of_field){
                y_start = size_of_field;
            }
            else if(y_start<=0){
                y_start = 1;
            }
            y_end = y_end + numy;
            if(y_end>size_of_field){
                y_end = size_of_field;
            }
            else if(y_end<=0){
                y_end = 1;
            }
            x_start = x_start + numx;
            if(x_start>size_of_field){
                x_start = size_of_field;
            }
            else if(x_start<=0){
                x_start = 1;
            }
            x_end = x_end + numx;
            if(x_end>size_of_field){
                x_end = size_of_field;
            }
            else if(x_end<=0){
                x_end = 1;
            }
        }
        /** Function for getting value of field {@link LineAtScreen#x_start}
         * @return It returns X start
         */
        public int getX_start() {
            return x_start;
        }
        /** Function for setting value of field {@link LineAtScreen#x_start}
         */
        public void setX_start(int x_start) {
            if(x_start>0&&x_start<size_of_field+1) {
                this.x_start = x_start;
            }
            else{
                this.x_start = 1;
            }
        }
        /** Function for getting value of field {@link LineAtScreen#y_start}
         * @return It returns Y start
         */
        public int getY_start() {
            return y_start;
        }
        /** Function for setting value of field {@link LineAtScreen#y_start}
         */
        public void setY_start(int y_start) {
            if(y_start>0&&y_start<size_of_field+1) {
                this.y_start = y_start;
            }
            else{
                this.y_start = 1;
            }
        }
        /** Function for getting value of field {@link LineAtScreen#x_end}
         * @return It returns X end
         */
        public int getX_end() {
            return x_end;
        }
        /** Function for setting value of field {@link LineAtScreen#x_end}
         */
        public void setX_end(int x_end) {
            if(x_end>0&&x_end<size_of_field+1) {
                this.x_end = x_end;
            }
            else{
                this.x_end = 1;
            }
        }
        /** Function for getting value of field {@link LineAtScreen#y_end}
         * @return It returns Y end
         */
        public int getY_end() {
            return y_end;
        }
        /** Function for setting value of field {@link LineAtScreen#y_end}
         */
        public void setY_end(int y_end) {
            if(y_end>0&&y_end<size_of_field+1) {
                this.y_end = y_end;
            }
            else{
                this.y_end = 1;
            }
        }
        /**
         * Function for drawing line
         */
        public void draw_line() {
            if (x_end == x_start) {
                int ye = (y_end > y_start) ? y_end : y_start;
                int ys = (y_end < y_start) ? y_end : y_start;
                for (int i = 0; i < size_of_field; i++) {
                    //System.out.print('-');
                    if (size_of_field - ye == i) {
                        for (int t = size_of_field - ye; t <= 10 - ys; t++) {
                            for (int k = 0; k < x_start - 1; k++) {
                                System.out.print(' ');
                            }
                            if(t==10-ys) {
                                System.out.print('*');
                                i++;
                            }else {
                                System.out.println('*');
                                i++;
                            }
                        }
                    }
                    System.out.println();
                }
                for (int i = 0; i < size_of_field; i++) {
                    System.out.print('\u02D9');
                }
            } else if (y_end == y_start) {
                int xs = (x_end < x_start) ? x_end : x_start;
                int xe = (x_end > x_start) ? x_end : x_start;
                for (int i = 0; i < size_of_field; i++) {
                    if (size_of_field - y_end == i) {
                        for (int j = 0; j < xs - 1; j++) {
                            System.out.print(' ');
                        }

                        for (int l = xs; l <= xe; l++) {
                            System.out.print('*');
                        }
                        //System.out.print("\n");
                    }
                    System.out.println();
                }
                for (int i = 0; i <= size_of_field; i++) {
                    System.out.print('\u02D9');
                }
            } else if (x_start == y_start && x_end == y_end) {
                int ye = (y_end > y_start) ? y_end : y_start;
                int ys = (y_end < y_start) ? y_end : y_start;
                int xe = x_end;
                int xs = x_start;
                for (int i = 0; i < size_of_field; i++) {
                    if (10 - ye == i) {
                        if (xe > xs) {
                            for (int p = size_of_field - ye; p <= size_of_field - ys; p++) {
                                for (int j = 0; j < xe - 1; j++) {
                                    System.out.print(' ');
                                }
                                if (p == size_of_field - ys) {
                                    System.out.print('*');
                                    xe--;
                                    i++;
                                } else {
                                    System.out.println('*');
                                    xe--;
                                    i++;
                                }
                            }
                        }else if (xe < xs) {
                            for (int p = 10 - ye; p <= 10 - ys; p++) {
                                for (int j = 0; j < xs - 1; j++) {
                                    System.out.print(' ');
                                }
                                if(p==size_of_field-ys) {
                                    System.out.print('*');
                                    xe++;
                                    i++;
                                }else {
                                    System.out.println('*');
                                    xe++;
                                    i++;
                                }
                            }
                        }
                    }
                    System.out.println();
                }
                for (int i = 0; i < size_of_field; i++) {
                    System.out.print('\u02D9');
                }
            }
        }
        /** Function for comparing objects
         * @return It returns a boolean value according to equality or inequality of objects
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LineAtScreen that = (LineAtScreen) o;
            return size_of_field == that.size_of_field &&
                    x_start == that.x_start &&
                    y_start == that.y_start &&
                    x_end == that.x_end &&
                    y_end == that.y_end;
        }
        /** Function for getting table hash code
         * @return It returns the boolean value of the hash code
         */
        @Override
        public int hashCode() {
            return Objects.hash(size_of_field, x_start, y_start, x_end, y_end);
        }
        /** Function for getting information about an object
         * @return It returns a string containing the values of all fields of the object
         */
        @Override
        public String toString() {
            return "LineAtScreen{" +
                    "size_of_field=" + size_of_field +
                    ", x_start=" + x_start +
                    ", y_start=" + y_start +
                    ", x_end=" + x_end +
                    ", y_end=" + y_end +
                    '}';
        }
        /** Function for getting a copy of an object
         * @throws CloneNotSupportedException if the class that the cloned object belongs to does not enforce the Cloneable interface
         * @return It returns an object of type Time
         */
        public Task15.LineAtScreen clone() throws CloneNotSupportedException{
            return (Task15.LineAtScreen) super.clone();
        }
    }
}
