import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    Task17.Notebook ob1 = new Task17.Notebook("Петя","Iv","0509878576","ivan@gmail.com",123);
    Task21.CatalogOfFilms ob2 = new Task21.CatalogOfFilms("Переводчики","Алекс Гудмэн",2019,"16+","Английский",true);
    Task7.Time ob3 = new Task7.Time("09:59:09");
    Task15.LineAtScreen ob4 = new Task15.LineAtScreen(1,1,4,5);

    @Test
    void getName1(){
        String expected = ob1.getName();
        String actual = "Петя";
        assertEquals(expected, actual);
    }
    @Test
    void getNik1(){
        String expected = ob1.getNik();
        String actual = "Iv";
        assertEquals(expected, actual);
    }
    @Test
    void getNumber_phone1(){
        String expected = ob1.getNumber_phone();
        String actual = "0509878576";
        assertEquals(expected, actual);
    }
    @Test
    void getEmail_address1(){
        String expected = ob1.getEmail_address();
        String actual = "ivan@gmail.com";
        assertEquals(expected, actual);
    }
    @Test
    void getNumber_ICQ1(){
        int expected = ob1.getNumber_ICQ();
        int actual = 123;
        assertEquals(expected, actual);
    }
    @Test
    void getName2(){
        String expected = ob2.getName();
        String actual = "Переводчики";
        assertEquals(expected, actual);
    }
    @Test
    void getMain_actor2(){
        String expected = ob2.getMain_actor();
        String actual = "Алекс Гудмэн";
        assertEquals(expected, actual);
    }
    @Test
    void getYear_of_premiere2(){
        int expected = ob2.getYear_of_premiere();
        int actual = 2019;
        assertEquals(expected, actual);
    }
    @Test
    void getFor_whom2(){
        String expected = ob2.getFor_whom();
        String actual = "16+";
        assertEquals(expected, actual);
    }
    @Test
    void getLanguage2(){
        String expected = ob2.getLanguage();
        String actual = "Английский";
        assertEquals(expected, actual);
    }
    @Test
    void isLicense2(){
        boolean expected = ob2.isLicense();
        boolean actual = true;
        assertEquals(expected, actual);
    }
    @Test
    void show1(){
        String expected = ob3.show();
        String actual = "09:59:09";
        assertEquals(expected, actual);
    }
    @Test
    void length(){
        double expected = ob4.length();
        double actual = 5;
        assertEquals(expected, actual);
    }

    @Test
    void getX_start1(){
        double expected = ob4.getX_start();
        double actual = 1;
        assertEquals(expected, actual);
    }

    @Test
    void getY_start1(){
        double expected = ob4.getY_start();
        double actual = 1;
        assertEquals(expected, actual);
    }
    @Test
    void getX_end1(){
        double expected = ob4.getX_end();
        double actual = 4;
        assertEquals(expected, actual);
    }

    @Test
    void getY_end1(){
        double expected = ob4.getY_end();
        double actual = 5;
        assertEquals(expected, actual);
    }

}