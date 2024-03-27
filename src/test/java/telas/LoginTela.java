package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTela {
    private WebDriver app;

    public LoginTela(WebDriver app) {
        this.app = app;
    }

    public LoginTela preencherUsuario(String usuario) {
        app.findElement(By.id("com.lojinha:id/user")).click();
        app.findElement(By.id("com.lojinha:id/user")).findElement(By.id("com.lojinha:id/editText")).sendKeys(usuario);
        return this;
    }

    public LoginTela preencherSenha(String senha) {
        app.findElement(By.id("com.lojinha:id/password")).click();
        app.findElement(By.id("com.lojinha:id/password")).findElement(By.id("com.lojinha:id/editText")).sendKeys(senha);
        return this;
    }

    public ListaDeProdutosTela submeterLogin() {
        app.findElement(By.id("com.lojinha:id/loginButton")).click();
        return new ListaDeProdutosTela(app);
    }


}