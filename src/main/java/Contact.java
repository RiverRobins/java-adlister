public class Contact {
    private long id;
    private String firstName;
    private String lastName;
    private String number;

    public Contact(long id, String nameFirst, String nameLast, String num){
        this.id = id;
        this.firstName = nameFirst;
        this.lastName = nameLast;
        this.number = num;
    }
    public Contact(String nameFirst, String nameLast, String num){
        this.firstName = nameFirst;
        this.lastName = nameLast;
        this.number = num;
    }
    public Contact(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
