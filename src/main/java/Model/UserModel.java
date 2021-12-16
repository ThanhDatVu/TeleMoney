/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author dat26
 */
public class UserModel {

    String username;
    String password;

    public UserModel() {
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserModel{" + "username=" + username + ", password=" + password + '}';
    }

}
