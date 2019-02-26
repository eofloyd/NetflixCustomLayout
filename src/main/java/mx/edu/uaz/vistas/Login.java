package mx.edu.uaz.vistas;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 @author Efraim Olague Garay
 */
public class Login extends CustomLayout {
    private TextField tfUsuario;
    private PasswordField pfContra;
    private Button btnIniciar, btnFace, btnSus, btnAyuda, btnRegalo, btnTerminos, btnPrivacidad;
    private CheckBox chkRecuerda;
   // private ComboBox comboIdioma;
    private NativeSelect comboIdioma;

    public Login(){
        this.setPrimaryStyleName("principal");
        this.setTemplateName("login");
        this.setSizeFull();
        this.setResponsive(true);

        tfUsuario = new TextField();
        tfUsuario.setPlaceholder("Email o número de teléfono");


        this.addComponent(tfUsuario,"usuario");

        pfContra = new PasswordField();
        pfContra.setPlaceholder("Contraseña");
        this.addComponent(pfContra,"password");

        btnIniciar = new Button("Iniciar sesión");
        btnIniciar.setPrimaryStyleName("btn-login");

        this.addComponent(btnIniciar,"ingresar");

        chkRecuerda = new CheckBox("Recuérdame");
        chkRecuerda.setStyleName("chk-recuerda");
        this.addComponent(chkRecuerda,"recuerda");

        btnAyuda = new Button("¿Necesitas ayuda?");
        this.addComponent(btnAyuda,"ayuda");
        btnAyuda.setPrimaryStyleName("btn-ayuda");
        btnAyuda.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().setContent(new LoginHelp());
            }
        });



        btnFace = new Button("Iniciar sesión con Facebook");
        this.addComponent(btnFace,"face");
        btnFace.setPrimaryStyleName("btn-face");

        btnSus = new Button("Suscríbete ya.");
        this.addComponent(btnSus,"suscribete");
        btnSus.setPrimaryStyleName("btn-sus");

        btnRegalo = new Button("Términos de las tarjetas de regalo");
        this.addComponent(btnRegalo,"regalo");
        btnRegalo.setPrimaryStyleName("link-footer");

        btnTerminos = new Button("Términos de uso");
        this.addComponent(btnTerminos,"uso");
        btnTerminos.setPrimaryStyleName("link-footer");

        btnPrivacidad = new Button("Declaración de privacidad");
        this.addComponent(btnPrivacidad,"privacidad");
        btnPrivacidad.setPrimaryStyleName("link-footer");



        List<String> data = IntStream.range(0, 6).mapToObj(i -> "Español " + i).collect(Collectors.toList());
        comboIdioma = new NativeSelect<>("", data);

        comboIdioma.setEmptySelectionAllowed(false);
        comboIdioma.setSelectedItem(data.get(1));

        this.addComponent(comboIdioma,"idiomas");
        comboIdioma.setStyleName("combo-idiomas");
    }
}
