package bookslib;

public class EmailAddress {
    private String email; //электронный адрес
    private String someData;

    public EmailAddress(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getSomeData() {
        return someData;
    }

    public void setSomeData(String someData) {
        this.someData = someData;
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
                "email='" + email + ", name='" + someData;
    }
}

