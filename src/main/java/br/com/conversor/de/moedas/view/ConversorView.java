package br.com.conversor.de.moedas.view;

import br.com.conversor.de.moedas.controller.ConversorController;
import br.com.conversor.de.moedas.dto.ConversorDTO;
import br.com.conversor.de.moedas.model.Moeda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorView extends JFrame {
    private final JComboBox<Moeda> codigoBaseComboBox = new JComboBox<>(Moeda.getModel());
    private final JComboBox<Moeda> codigoTargetComboBox = new JComboBox<>(Moeda.getModel());
    private final JLabel labelCodigoBase = new JLabel("Moeda a ser convertida: ");
    private final JLabel labelCodigoTarget = new JLabel("Converter para: ");
    private final JLabel labelDigitarValor = new JLabel("Digite o valor para conversão (opcional)");
    private final JTextArea textAreaDigitarValor = new JTextArea("1");
    private final JLabel valorConvertido = new JLabel();
    private final JButton converter = new JButton("Converter");
    public ConversorView(){
        iniciar();
    }

    private void iniciar() {
        this.setSize(800, 500);
        this.setLayout(null);


        labelCodigoBase.setSize(200, 10);
        labelCodigoBase.setLocation(40, 50);

        codigoBaseComboBox.setLocation(250, 50);
        codigoBaseComboBox.setSize(300, 20);

        labelCodigoTarget.setSize(200, 10);
        labelCodigoTarget.setLocation(40, 80);

        codigoTargetComboBox.setLocation(250, 80);
        codigoTargetComboBox.setSize(300, 20);

        labelDigitarValor.setLocation(40, 120);
        labelDigitarValor.setSize(300, 20);

        textAreaDigitarValor.setLocation(340, 120);
        textAreaDigitarValor.setSize(100, 20);

        converter.setLocation(400, 160);
        converter.setSize(100, 20);

        valorConvertido.setLocation(40, 200);
        valorConvertido.setSize(760, 50);



        this.add(labelCodigoBase);
        this.add(codigoBaseComboBox);
        this.add(labelCodigoTarget);
        this.add(codigoTargetComboBox);
        this.add(labelDigitarValor);
        this.add(textAreaDigitarValor);
        this.add(converter);
        this.add(valorConvertido);

        addActionPerformeted();


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addActionPerformeted(){

        converter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConversorController controller = new ConversorController();

                Moeda moedaBase = (Moeda) codigoBaseComboBox.getModel().getSelectedItem();
                Moeda moedaTarget = (Moeda) codigoTargetComboBox.getModel().getSelectedItem();
                ConversorDTO conversorDTO = controller.converter(moedaBase.getCodigo(), moedaTarget.getCodigo());
                String valor = conversorDTO.converterValor(textAreaDigitarValor.getText());


                String resultado = "%s %s = %s %s";
                System.out.println(conversorDTO.conversion_rate());
                valorConvertido.setText(
                        String.format(
                                resultado,
                                textAreaDigitarValor.getText(),
                                moedaBase.getNome(),
                                valor,
                                moedaTarget.getNome()
                        )
                );


            }
        });

    }
}
