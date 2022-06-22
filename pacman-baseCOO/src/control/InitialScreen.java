package control;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import utils.Consts;

public class InitialScreen extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private JButton startButton;
	private JButton openButton;
	private final String nomeImagemInicial = "inicialimagem.png";
	private static String[] levels = { "Level 1", "Level 2", "Level 3", "Level 4" };
	
	private JComboBox<String> box;
	
	public InitialScreen(){
		configureInitialScreen();
		configureStartButton();
		configureOpenButton();
		configureComboBox();
		configureMenuBar();
	}
	
	
	private void configureMenuBar() {
		JMenuBar barraMenu = new JMenuBar(); 
		this.setJMenuBar(barraMenu);
		
		
		
		
		
		JMenu menuMenu = new JMenu("Menu");
		barraMenu.add(menuMenu);
		
		JMenuItem itemNovo = new JMenuItem("Iniciar novo jogo");
		menuMenu.add(itemNovo);
		
		JMenuItem itemNovo1 = new JMenuItem("Carregar jogo salvo");
		menuMenu.add(itemNovo1);
		
		
		JMenu menuEstagio = new JMenu("Est·gio");
		barraMenu.add(menuEstagio);
		
		JMenuItem itemEstagio1 = new JMenuItem("Est·gio 1");
		menuEstagio.add(itemEstagio1);
		
		JMenuItem itemEstagio2 = new JMenuItem("Est·gio 2");
		menuEstagio.add(itemEstagio2);
		
		JMenuItem itemEstagio3 = new JMenuItem("Est·gio 3");
		menuEstagio.add(itemEstagio3);
		
		JMenuItem itemEstagio4 = new JMenuItem("Est·gio 4");
		menuEstagio.add(itemEstagio4);
		
		
		//JMenuItem itemEstagio = new JMenuItem("Selecionar o estagio");
		//itemNovo.add(itemEstagio);
	}
	
	private void configureInitialScreen(){
		int sizeWidth = Consts.NUM_CELLS * Consts.CELL_SIZE + getInsets().left + getInsets().right;
		int sizeHeight = Consts.NUM_CELLS * Consts.CELL_SIZE + getInsets().top + getInsets().bottom;
		
		setSize(sizeWidth, sizeHeight);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCC0604 - Pacman"); 
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(20, 20));
        setResizable(false);		
	    

        try{
        	setContentPane(new JLabel(new ImageIcon(new File(".").getCanonicalPath() + Consts.PATH + nomeImagemInicial)));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }	
        //pack();
	}
	private void configureStartButton(){
		startButton = new JButton("Novo Jogo");
		startButton.setSize(150, 50);
		startButton.setAlignmentX(CENTER_ALIGNMENT);
		startButton.setAlignmentY(CENTER_ALIGNMENT);
		startButton.setLocation(250, 225);
		startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		HandlerStartButton handlerIniciarJogo = new HandlerStartButton();
		startButton.addActionListener(handlerIniciarJogo);
		add(startButton);
	}
	
	/**
	 * Configurar bot√£o de Iniciar Jogo
	 */
	private void configureOpenButton(){
		startButton = new JButton("Carregar Jogo");
		startButton.setSize(150, 50);
		startButton.setAlignmentX(CENTER_ALIGNMENT);
		startButton.setAlignmentY(CENTER_ALIGNMENT);
		startButton.setLocation(250, 275);
		startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		HandlerOpenButton handlerOpen = new HandlerOpenButton();
		startButton.addActionListener(handlerOpen);
		add(startButton);
	}
	
	
	private void configureComboBox(){
		box = new JComboBox<String>(levels);
		box.setSize(100, 40);
		box.setSelectedIndex(0);
		box.setLocation(500, 10);
		box.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent event){
				if(event.getStateChange() == ItemEvent.SELECTED){ 
					JComboBox<String> cb = (JComboBox<String>)event.getSource();
					Main.level = cb.getSelectedIndex() + 1;
				}
			}			
		});
		add(box);
	}

	public class HandlerStartButton implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Main.initialScreen.setVisible(false);  
	    	Main.initialScreen.dispose();
			Main.startGame();
		}
	}

 
	public class HandlerOpenButton implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Main.initialScreen.setVisible(false);  
	    	Main.initialScreen.dispose();
	    	Main.openSavedGame = true;
	    	Main.startGame();
		}
	}
}