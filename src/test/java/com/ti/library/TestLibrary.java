package com.ti.library;



import com.ti.page.*;

import java.util.HashMap;
import java.util.Map;

public class TestLibrary {

    Map <String, String> UserCredetial = new  HashMap<>();

    Map<String, String> UserCont = new HashMap<>();

    Map<String, String> ShippinInformation = new HashMap<>();

    Map<String, String> billingInformation = new HashMap<>();
    LoginPage loginn = new LoginPage();
    RegisterPage registeer = new RegisterPage();

    UserDatePage AddresData;

    BuyPage comprar = new BuyPage();

    FollowOrder orden = new FollowOrder();


    Map<String, String> UserLogin = new HashMap<>();

    public void Register() throws InterruptedException {

        UserCont.put("Username", "Yahaira");
        UserCont.put("Useremail", "yahaira@gmail.com");
        UserCont.put("UserPhone", "4494131537");
        UserCont.put("Password", "yahaira");
        UserCont.put("ConPassword", "yahaira");
        registeer.RegisterUser(UserCont.get("Username"),
                UserCont.get("Useremail"),
                UserCont.get("UserPhone"),
                UserCont.get("Password"),
                UserCont.get("ConPassword"));;


        }
        public void  Login() throws InterruptedException {
        UserCredetial.put("Useremail","yahaira@gmail.com");
        UserCredetial.put("Userpassword","yahaira");
        loginn.LoginUser(UserCredetial.get("Useremail"),
                UserCredetial.get("Userpassword"));
    }

    public void AddressData() throws InterruptedException {
        AddresData = new UserDatePage();
        billingInformation.put("Address", "Jaltomate");
        billingInformation.put("State", "Aguascalientes");
        billingInformation.put("City", "Aguascalientes");
        billingInformation.put("Code", "201986");
        AddresData.UserAddress(
                billingInformation.get("Address"),
                billingInformation.get("State"),
                billingInformation.get("City"),
                billingInformation.get("Code")
        );
        ShippinInformation.put("Address", "Jaltomate");
        ShippinInformation.put("State", "Aguascalientes");
        ShippinInformation.put("City", "Aguascalientes");
        ShippinInformation.put("Code", "201986");

        AddresData.ShippingAddress(
                ShippinInformation.get("Address"),
                ShippinInformation.get("State"),
                ShippinInformation.get("City"),
                ShippinInformation.get("Code"));

    }

    public void Comprar() throws InterruptedException {
        comprar.BuyProduct();
    }

    public void Order() throws InterruptedException {
        orden.CheckOrder();
    }


}

