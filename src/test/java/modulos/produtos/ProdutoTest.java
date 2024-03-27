package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import telas.LoginTela;

import java.net.MalformedURLException;
import java.net.URL;

@DisplayName("Testes mobile do módulo de produto")
public class ProdutoTest {
    WebDriver app;

    @BeforeEach
    public void setup() throws MalformedURLException {
        //Abrir o app
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("appium:deviceName", "Pixel 3a");
        capacidades.setCapability("appium:platformName", "Android");
        capacidades.setCapability("appium:udid", "emulator-5554");
        capacidades.setCapability("appium:appPackage", "com.lojinha");
        capacidades.setCapability("appium:appActivity", "com.lojinha.ui.MainActivity");
        capacidades.setCapability("appium:app", "C:\\Users\\henri\\Downloads\\Lojinha+Android+Nativa\\lojinha-nativa.apk");

        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);

    }

    @DisplayName("Validaçao do valor de produto não permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitido() {

        LoginTela loginTela = new LoginTela(app);

        String mensagemApresentada = loginTela.preencherUsuario("Henrique No PTQS")
                .preencherSenha("Henriquenoptqs")
                .submeterLogin()
                .abrirTelaAdicaoProduto()
                .preencherNomeProduto("Iphone")
                .preencherValorProduto("700001")
                .preencherCoresProduto("Amarelo e cinza")
                .submeterNovoProdutoComErro()
                .obterMesnsagemErro();


        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }


    @AfterEach
    public void tearDown() {
        app.quit();
    }
}
