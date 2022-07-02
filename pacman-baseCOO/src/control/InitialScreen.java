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
		
		configureMenuBar();
	}
	
	
	private void configureMenuBar() {
		JMenuBar barraMenu = new JMenuBar(); 
		this.setJMenuBar(barraMenu);
		
		
		JMenu menuMenu = new JMenu("Menu");
		barraMenu.add(menuMenu);
		
		JMenuItem itemNovo = new JMenuItem("Iniciar novo jogo");
		HandlerStartButton handlerIniciarJogo = new HandlerStartButton();
		itemNovo.addActionListener(handlerIniciarJogo);
		menuMenu.add(itemNovo);
		
		JMenuItem itemNovo1 = new JMenuItem("Carregar jogo salvo");
		HandlerOpenButton handlerOpen = new HandlerOpenButton();
		itemNovo1.addActionListener(handlerOpen);
		menuMenu.add(itemNovo1);
		
		
		JMenu menuEstagio = new JMenu("Estágio");
		barraMenu.add(menuEstagio);
		
		for(int i = 1;i < 5; i++) {
			menuEstagio.add(configureStageMenu(i));
		}
	}
	
	private JMenuItem configureStageMenu(final int index) {
		JMenuItem itemStage = new JMenuItem("Estágio " + index);
		itemStage.addActionListener(new java.awt.event.ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Main.level = index;
				setTitle("SCC0604 - Pacman -" + "Estágio selecionado: "+ Main.level);
			}
			
		});
		return itemStage;
	}
	
	private void configureInitialScreen(){
		int sizeWidth = Consts.NUM_CELLS * Consts.CELL_SIZE + getInsets().left + getInsets().right;
		int sizeHeight = Consts.NUM_CELLS * Consts.CELL_SIZE + getInsets().top + getInsets().bottom;
		
		setSize(sizeWidth, sizeHeight);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCC0604 - Pacman -" + "Estágio selecionado: "+ Main.level); 
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
	/**
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
	*/
	/**
	 * Configurar botÃ£o de Iniciar Jogo
	 
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
	*/

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