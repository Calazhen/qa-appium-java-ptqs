package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ListaDeProdutosTela {

    private WebDriver app;

    public ListaDeProdutosTela(WebDriver app) {
        this.app = app;
    }

    public FormularioAdicaoProdutoTela abrirTelaAdicaoProduto() {
        app.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();
        return new FormularioAdicaoProdutoTela(app);
    }
}
