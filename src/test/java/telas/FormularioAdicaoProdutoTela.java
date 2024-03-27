package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioAdicaoProdutoTela {
    private WebDriver app;

    public FormularioAdicaoProdutoTela(WebDriver app) {
        this.app = app;
    }

    public FormularioAdicaoProdutoTela preencherNomeProduto(String nome) {
        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(nome);
        return this;
    }

    public FormularioAdicaoProdutoTela preencherValorProduto(String valor) {
        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(valor);
        return this;
    }

    public FormularioAdicaoProdutoTela preencherCoresProduto(String cores) {
        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(cores);
        return this;
    }

    public ListaDeProdutosTela submeterNovoProdutoComSucesso() {
        app.findElement(By.id("com.lojinha:id/saveButton")).click();
        return new ListaDeProdutosTela(app);
    }

    public FormularioAdicaoProdutoTela submeterNovoProdutoComErro() {
        app.findElement(By.id("com.lojinha:id/saveButton")).click();
        return this;
    }

    public String obterMesnsagemErro() {
        return app.findElement(By.xpath("//android.widget.Toast")).getText();
    }
}
