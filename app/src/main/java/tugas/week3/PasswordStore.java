package tugas.week3;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordStore {
  public String name, username;
  private String password, hashkey;
  private double score;
  private int category;

  public static final int UNCATEGORIZED = 0;
  public static final int CAT_WEBAPP = 1;
  public static final int CAT_MOBILEAPP = 2;
  public static final int CAT_OTHER = 3;

  public PasswordStore(String name, String username, String plainPass, int category) throws Exception{    
    this.name = name;
    this.username = username;
    this.hashkey =  Encryptor.generateKey();
    setPassword(plainPass);
    setCategory(category);
  }

  public PasswordStore(String name, String username, String plainPass) throws Exception{
    this.name = name;
    this.username = username;
    this.hashkey =  Encryptor.generateKey();
    setPassword(plainPass);
    setCategory(UNCATEGORIZED);
  }

  public void setPassword(String plainPass) throws Exception{
    this.password = Encryptor.encrypt(plainPass, this.hashkey);
    calculateScore(plainPass);
  }

  public String getPassword() throws Exception{
    return Encryptor.decrypt(this.password, this.hashkey);
    // return this.password;
  }

  public void setCategory(int category){
    if(category >= 0 && category <= 3){
      this.category = category;
    } 
    else {
      this.category = 0;
    }
  }

  public String getCategory(){
    switch (this.category) {
      case 0:
          return "Belum terkategori";
      case 1:
          return "Aplikasi web";
      case 2:
          return "Aplikasi mobile";
      case 3:
          return "Akun lainnya";
      default:
          return "Kategori tidak valid";
    }  
  }

  public void calculateScore(String plainPass){
    double length = plainPass.length();
    if(length > 15){
      this.score = 10;
    } else {
      this.score = (length / 15.0) * 10; 
    }
  }

  @Override
  public String toString() {
    return "Username : " + this.username + "\nPassword : " + this.password + "\nHashkey : " + this.hashkey + "\nKategori : " + getCategory() + "\nScore : " + this.score ;
  }

}
