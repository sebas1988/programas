package karatsuba;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import javax.swing.*;

/**
 *
 * @author Sebastian
 */
public class Karatsuba extends JFrame implements ActionListener{
    private JPanel pnlTitulo,pnlValores,pnlBotones;    
    private JLabel lblTexto,lblNumero1,lblNumero2;        
    private JButton btnMultiplicar,btnLimpiar,btnSalir;
    private Container contenedor;
    private TextField txtNumero1, txtNumero2;
    public Karatsuba(){
        //definicion objetos panel del titulo
  this.pnlTitulo = new JPanel();
        this.lblTexto = new JLabel("Ingrese dos números grandes a multiplicar");
        pnlTitulo.add(lblTexto);
	//definicion panel de objetos de las transacciones
	this.pnlValores = new JPanel();
	this.pnlValores.setLayout(new GridLayout(2,2));
	this.lblNumero1 = new JLabel("Número 1:");                
	this.lblNumero2 = new JLabel("Número 2:");
        this.txtNumero1 = new TextField(1000000000);
        //controlar el ingreso de datos sea solo numerico
        txtNumero1.addKeyListener(new KeyAdapter() {
            @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)||Character.isDefined(45)))){
                getToolkit().beep();
                e.consume();
                }
            }
        });
	this.txtNumero2 = new TextField(1000000000);
        txtNumero2.addKeyListener(new KeyAdapter() {
            @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) ||Character.isDefined(45)))){
                getToolkit().beep();
                e.consume();
                }
            
            }
        });    
	//adicionar objetos al panel valores
	pnlValores.add(lblNumero1);
        pnlValores.add(txtNumero1);
        pnlValores.add(lblNumero2);
        pnlValores.add(txtNumero2);
	//definicion panel de los botones
	this.pnlBotones = new JPanel();
        pnlBotones.setLayout(new GridLayout(1,3));
	this.btnMultiplicar = new JButton("Multiplicar");
	this.btnLimpiar = new JButton("Limpiar");
	this.btnSalir = new JButton("Salir");
	//adicionar objetos al panel botones
	pnlBotones.add(btnMultiplicar);
	pnlBotones.add(btnLimpiar);
	pnlBotones.add(btnSalir);		
	btnMultiplicar.addActionListener(this);
        btnSalir.addActionListener(this);
	btnLimpiar.addActionListener(this);
	// el contenedor obtiene el frame donde ubica los objetos graficos
	this.contenedor = getContentPane();
	contenedor.setLayout(new BorderLayout());
	contenedor.add(pnlTitulo, BorderLayout.NORTH);
	contenedor.add(pnlValores,BorderLayout.CENTER);
	contenedor.add(pnlBotones,BorderLayout.SOUTH);				
	//sentencias menejo de la ventana
        setTitle("Karatsuba");
	setSize(400,150);
	setVisible(true);
	setLocationRelativeTo(null); //ubicar ventana en el centro
	setResizable(false);        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Karatsuba karatsuba = new Karatsuba();
        karatsuba.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );  
        // TODO code application logic here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if(e.getSource()==btnMultiplicar){
            if(txtNumero1.getText().equals("")||txtNumero2.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Por favor digite algún número en los campos de texto.", "Error",JOptionPane.WARNING_MESSAGE);
            }else{
                BigInteger x = new BigInteger(txtNumero1.getText());
                BigInteger y = new BigInteger(txtNumero2.getText());
                JOptionPane.showMessageDialog(this, "La multiplicación entre "+x+" y "+y+" es: "+multiplicar(x,y), "Resultado",JOptionPane.INFORMATION_MESSAGE);                
                txtNumero1.setText(null);
                txtNumero2.setText(null);
            }
            
            }else{	
                if(e.getSource()==btnLimpiar){
                    limpiar();
                }else{	
                    if(e.getSource()==btnSalir){	
                        System.exit(0);
                    }
                }
            }
    }
    private void limpiar() {
	txtNumero1.setText("");
	txtNumero2.setText("");
	txtNumero1.requestFocus();
        txtNumero2.requestFocus();
    }
    private BigInteger multiplicar(BigInteger x,BigInteger y){ 
        int posicion;
        BigInteger a,b,c,d,e,f,g,h;
        if(x.bitLength()==0||y.bitLength()==0){
            return BigInteger.ZERO;
        }else{
            if(x.bitLength()==1){
                return y;
            }else{
                if(y.bitLength()==1){
                    return x;
                }
            }
        }
        posicion=Math.max(x.bitLength(),y.bitLength());
        posicion=posicion/2;
        a=x.shiftRight(posicion);
        b=x.subtract(a.shiftLeft(posicion));
        c=y.shiftRight(posicion);
        d=y.subtract(c.shiftLeft(posicion));
        e=multiplicar(a,c);
        f=multiplicar(b.add(a),d.add(c));
        g=multiplicar(b,d);
        h=f.subtract(e).subtract(g);
        return e.shiftLeft(2*posicion).add(h.shiftLeft(posicion)).add(g);
    } 
}
