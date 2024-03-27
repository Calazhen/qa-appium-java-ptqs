package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ListaDeProdutosTela  extends BaseTela{

    public ListaDeProdutosTela(WebDriver app) {
        super(app);
    }

    public FormularioAdicaoProdutoTela abrirTelaAdicaoProduto() {
        app.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        app.findElement(By.id("com.lojinha:id/floatingActionButton")).click();
        return new FormularioAdicaoProdutoTela(app);
    }
}
