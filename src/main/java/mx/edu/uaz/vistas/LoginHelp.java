package mx.edu.uaz.vistas;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
@author Efraim Olague Garay
*/
public class LoginHelp extends CustomLayout {

    Button btnIniciar,btnEnviar,btnNomeacuerdo,btnRegalo, btnTerminos, btnPrivacidad;
    private RadioButtonGroup radio;
    private NativeSelect comboIdioma;
    private TextField tfEmail;


    public LoginHelp() {
        this.setPrimaryStyleName("principal-help");
        this.setTemplateName("loginHelp");
        this.setSizeFull();
        this.setResponsive(true);

        btnIniciar = new Button("Iniciar sesión");
        this.addComponent(btnIniciar,"iniciar");
        btnIniciar.setPrimaryStyleName("btn-iniciar");
        btnIniciar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UI.getCurrent().setContent(new Login());
            }
        });


        List<String> data = Arrays.asList("Email", "Mensaje de texto", "Llamada");
        radio = new RadioButtonGroup<>("", data);
        radio.setSelectedItem(data.get(0));

        this.addComponent(radio,"radio");

        tfEmail = new TextField();
        tfEmail.setPlaceholder("nombre@ejemplo.com");
        this.addComponent(tfEmail,"email");
        tfEmail.setPrimaryStyleName("tf-email");

        btnEnviar = new Button("Enviar un email");
        this.addComponent(btnEnviar,"enviar");
        btnEnviar.setPrimaryStyleName("btn-enviar");

        btnNomeacuerdo = new Button("No me acuerdo de mi email ni de mi teléfono");
        this.addComponent(btnNomeacuerdo,"nome");
        btnNomeacuerdo.setPrimaryStyleName("btn-nomeacuerdo");

        btnRegalo = new Button("Términos de las tarjetas de regalo");
        this.addComponent(btnRegalo,"regalo");
        btnRegalo.setPrimaryStyleName("link-footer");

        btnTerminos = new Button("Términos de uso");
        this.addComponent(btnTerminos,"uso");
        btnTerminos.setPrimaryStyleName("link-footer");

        btnPrivacidad = new Button("Declaración de privacidad");
        this.addComponent(btnPrivacidad,"privacidad");
        btnPrivacidad.setPrimaryStyleName("link-footer");



        List<String> data2 = IntStream.range(0, 6).mapToObj(i -> "Español " + i).collect(Collectors.toList());
        comboIdioma = new NativeSelect<>("", data2);

        comboIdioma.setEmptySelectionAllowed(false);
        comboIdioma.setSelectedItem(data2.get(1));

        this.addComponent(comboIdioma,"idiomas");
        comboIdioma.setStyleName("combo-idiomas");

    }
}