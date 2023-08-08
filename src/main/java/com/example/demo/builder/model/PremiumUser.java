package com.example.demo.builder.model;

public class PremiumUser {
    private String username;
    private String email;
    private String password;
    private String address;

    public PremiumUser(String username, String email, String password, String address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String print() {
        StringBuilder append = new StringBuilder()
                .append("Username : ").append(username)
                .append("Email : ").append(email)
                .append("Password : ").append(password)
                .append("Address : ").append(address);
        return append.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PremiumUser)) return false;

        PremiumUser adminUser = (PremiumUser) o;

        if (getUsername() != null ? !getUsername().equals(adminUser.getUsername()) : adminUser.getUsername() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(adminUser.getEmail()) : adminUser.getEmail() != null) return false;
        if (getPassword() != null ? !getPassword().equals(adminUser.getPassword()) : adminUser.getPassword() != null)
            return false;
        return getAddress() != null ? getAddress().equals(adminUser.getAddress()) : adminUser.getAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }
}
