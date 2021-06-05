/*Создать класс для элемента каталога фильмов(поля:название,
режиссер, исполнитель главной роли, год выхода, кому данна
просмотр, язык звуковой дорожки, лицензионный или нет)*/

import java.util.Objects;

public class Task21 {
    public static void main (String[] args) throws CloneNotSupportedException{
        CatalogOfFilms cat1 = new CatalogOfFilms("Переводчики","Алекс Гудмэн",2019,"16+","Английский",true);
        cat1.setLanguage("Немецкий");
        cat1.edit_catalog(6, "false");
        System.out.print("Объект, созданный с помощью конструктора с параметрми: ");
        cat1.show_info();
        CatalogOfFilms cat2 = cat1.clone();
        System.out.print("Объект, созданный с помощью клонирования: ");
        cat2.show_info();
        System.out.print("Объект с изменённым полем: ");
        cat2.edit_catalog(6,"false");
        cat2.show_info();
        if (cat1.equals(cat2)) {
            if (cat1.hashCode() == cat2.hashCode()) {
                System.out.println("Объекты равны:");
            } else {
                System.out.println("Обьекты не равны:");
            }
        } else {
            System.out.println("Обьекты не равны:");
        }
        System.out.println(cat1.toString());
        System.out.println(cat2.toString());
    }
    /**
     * Interface Catalog representing work with  different catalogs
     */
    interface Catalog{
        void show_info();
        void edit_catalog(int num, String value);
    }
    /**
     * The class is used to store objects with properties
     * * <b>name</b>,<b>main_actor</b>, <b>year_of_primiere</b>, <b>for_whom</b>, <b>language</b> и <b>license</b>.
     * * @author Dudchenko Liudmila
     */
        public static class CatalogOfFilms implements Cloneable, Catalog{
        private String name;
        private String main_actor;
        private int year_of_premiere;
        private String for_whom;
        private String language;
        private boolean license;

        /**
         * It creates a new object with the given values
         * @param n - name
         * @param ma - main acotr
         * @param yop - year of premiere
         * @param fw - for whom
         * @param lan - language
         * @param lic - license
         * @see CatalogOfFilms#CatalogOfFilms(String, String, int, String, String, boolean)
         */
        CatalogOfFilms(String n, String ma, int yop, String fw, String lan, boolean lic){
            name = n;
            main_actor = ma;
            year_of_premiere = yop;
            for_whom = fw;
            language = lan;
            license = lic;
        }
        /** It creates a new empty object
         *@see CatalogOfFilms#CatalogOfFilms()
         */
        CatalogOfFilms(){
            name = null;
            main_actor = null;
            year_of_premiere = 0;
            for_whom = null;
            language = null;
            license = false;
        }
        /**
         * Function for changing parts of catalog according to their number
         * @param num
         * @param value
         */
            public void edit_catalog(int num, String value){
                switch(num){
                    case 1: {
                        this.name = value;
                        break;
                    }
                    case 2:{
                        this.main_actor = value;
                        break;
                    }
                    case 3:{
                        this.year_of_premiere = Integer.parseInt(value);
                        break;
                    }
                    case 4:{
                        this.for_whom = value;
                        break;
                    }
                    case 5:{
                        this.language =value;
                        break;
                    }
                    case 6:{
                        this.license = Boolean.parseBoolean(value);
                        break;
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
            CatalogOfFilms that = (CatalogOfFilms) o;
            return year_of_premiere == that.year_of_premiere &&
                    license == that.license &&
                    Objects.equals(name, that.name) &&
                    Objects.equals(main_actor, that.main_actor) &&
                    Objects.equals(for_whom, that.for_whom) &&
                    Objects.equals(language, that.language);
        }
        /** Function for getting table hash code
         * @return It returns the boolean value of the hash code
         */
        @Override
        public int hashCode() {
            return Objects.hash(name, main_actor, year_of_premiere, for_whom, language, license);
        }
        /** Function for getting information about an object
         * @return It returns a string containing the values of all fields of the object
         */
        @Override
        public String toString() {
            return "CatalogOfFilms{" +
                    "name='" + name + '\'' +
                    ", main_actor='" + main_actor + '\'' +
                    ", year_of_premiere=" + year_of_premiere +
                    ", for_whom='" + for_whom + '\'' +
                    ", language='" + language + '\'' +
                    ", license=" + license +
                    '}';
        }
        /** Function for showing field values {@link CatalogOfFilms#name},{@link CatalogOfFilms#main_actor},{{@link CatalogOfFilms#year_of_premiere},{@link CatalogOfFilms#for_whom},{@link CatalogOfFilms#language},{@link CatalogOfFilms#license} */
        public void show_info(){
            System.out.println(name+": "+main_actor+", "+year_of_premiere+", "+for_whom+", "+language+", "+((license==true)?"Лицензионный":"Не лицензионный")+". ");
        }
        /** Function for getting value of field {@link CatalogOfFilms#name}
         * @return It returns name
         */
        public String getName() {
            return name;
        }
        /** Function for setting value of field {@link CatalogOfFilms#name}
         */
        public void setName(String name) {
            this.name = name;
        }
        /** Function for getting value of field {@link CatalogOfFilms#year_of_premiere}
         * @return It returns main year of pemiere
         */
        public int getYear_of_premiere() {
            return year_of_premiere;
        }
        /** Function for setting value of field {@link CatalogOfFilms#year_of_premiere}
         */
        public void setYear_of_premiere(int year_of_premiere) {
            this.year_of_premiere = year_of_premiere;
        }
        /** Function for getting value of field {@link CatalogOfFilms#main_actor}
         * @return It returns main actor
         */
        public String getMain_actor() {
            return main_actor;
        }
        /** Function for setting value of field {@link CatalogOfFilms#main_actor}
         */
        public void setMain_actor(String main_actor) {
            this.main_actor = main_actor;
        }
        /** Function for getting value of field {@link CatalogOfFilms#for_whom}
         * @return It returns for whom
         */
        public String getFor_whom() {
            return for_whom;
        }
        /** Function for setting value of field {@link CatalogOfFilms#for_whom}
         */
        public void setFor_whom(String for_whom) {
            this.for_whom = for_whom;
        }
        /** Function for getting value of field {@link CatalogOfFilms#language}
         * @return It returns main language
         */
        public String getLanguage() {
            return language;
        }
        /** Function for setting value of field {@link CatalogOfFilms#language}
         */
        public void setLanguage(String language) {
            this.language = language;
        }
        /** Function for getting value of field {@link CatalogOfFilms#license}
         * @return It returns main license
         */
        public boolean isLicense() {
            return license;
        }
        /** Function for setting value of field {@link CatalogOfFilms#license}
         */
        public void setLicense(boolean license) {
            this.license = license;
        }
        /** Function for getting a copy of an object
         * @throws CloneNotSupportedException if the class that the cloned object belongs to does not enforce the Cloneable interface
         * @return It returns an object of type Time
         */
            public CatalogOfFilms clone() throws CloneNotSupportedException{
                return (CatalogOfFilms) super.clone();
            }

    }
}
