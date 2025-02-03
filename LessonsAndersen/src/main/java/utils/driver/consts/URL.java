package utils.driver.consts;

public enum URL {
   AUTO("http://www.automationpractice.pl/index.php"),

    ZOO("https://zoo.waw.pl/"),

    W3("https://www.w3schools.com/"),

    SPEED("https://www.clickspeedtester.com/click-counter/"),
    LOGIN("https://qa-course-01.andersenlab.com/login"),

    LAB("https://andersenlab.com/");
    private String url;

    URL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
