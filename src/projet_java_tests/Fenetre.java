package projet_java_tests;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.*;
import java.io.File;

public class Fenetre extends javax.swing.JFrame{
	
	private static final long serialVersionUID = 1L;
	private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem7;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;

	public Fenetre() {
		initComponents();
		layouts();
		
		// Charger les images du dossier Affiches_films
        File dossier = new File("Affiches_films");
        File[] fichiers = dossier.listFiles();

        if (fichiers != null) {
            JPanel panelImages = new JPanel(new GridLayout(0, 8, 10, 10)); // 6 colonnes, ajustées automatiquement
            panelImages.setBackground(Color.DARK_GRAY);
            for (File fichier : fichiers) {
                if (fichier.isFile()) {
                    ImageIcon imageIcon = new ImageIcon(fichier.getAbsolutePath());
                    Image image = imageIcon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
                    JLabel imageLabel = new JLabel(new ImageIcon(image));
                    panelImages.add(imageLabel);
                }
            }
            jScrollPane1.setViewportView(panelImages);
            jScrollPane1.getVerticalScrollBar().setUnitIncrement(30); //vitesse de défilement de la ScrollBar
        }
        
        pack();
        this.setLocationRelativeTo(null); //positionne la fenêtre au centre de l'écran
        this.setExtendedState(Frame.MAXIMIZED_BOTH);//ouvre l'application en plein écran
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
	}
	
	

	
	
	//Initialisation des composants
	private void initComponents() {
		jPanel1= new javax.swing.JPanel();
		jPanel1.setBackground(Color.DARK_GRAY);
		jPanel2=new JPanel();
		jPanel2.setBackground(Color.DARK_GRAY);
        
		jTextField1 = new javax.swing.JTextField();
		jTextField1.setPreferredSize(new Dimension(100,30));
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setText("Recherche :");
        jLabel1.setForeground(Color.WHITE);
        
		
		jMenuBar1 = new javax.swing.JMenuBar();
		setJMenuBar(jMenuBar1);
		
		jMenu1 = new javax.swing.JMenu();
		jMenu1.setText("Trier");
		jMenuBar1.add(jMenu1);
		
		jMenu2 = new javax.swing.JMenu();
		jMenu2.setText("Genre");
		jMenu1.add(jMenu2);
		
		jMenu3 = new javax.swing.JMenu();
		jMenu3.setText("Année");
		jMenu1.add(jMenu3);
		
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem1.setText("Recommandés");
        jMenu1.add(jMenuItem1);
        
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem2.setText("Tous les films");
        jMenu1.add(jMenuItem2);
		
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
		jCheckBoxMenuItem1.setSelected(false);
        jCheckBoxMenuItem1.setText("Drame");
        jMenu2.add(jCheckBoxMenuItem1);
        
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2.setSelected(false);
        jCheckBoxMenuItem2.setText("Comédie");
        jMenu2.add(jCheckBoxMenuItem2);
        
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3.setSelected(false);
        jCheckBoxMenuItem3.setText("Science-Fiction");
        jMenu2.add(jCheckBoxMenuItem3);
        
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4.setSelected(false);
        jCheckBoxMenuItem4.setText("Animation");
        jMenu2.add(jCheckBoxMenuItem4);
        
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem5.setSelected(false);
        jCheckBoxMenuItem5.setText("Aventure");
        jMenu2.add(jCheckBoxMenuItem5);
        
        jCheckBoxMenuItem6 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem6.setSelected(false);
        jCheckBoxMenuItem6.setText("Action");
        jMenu2.add(jCheckBoxMenuItem6);
        
        jCheckBoxMenuItem7 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem7.setSelected(false);
        jCheckBoxMenuItem7.setText("Croissant");
        jMenu3.add(jCheckBoxMenuItem7);
        
        jCheckBoxMenuItem8 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem8.setSelected(false);
        jCheckBoxMenuItem8.setText("Décroissant");
        jMenu3.add(jCheckBoxMenuItem8);
        
		jScrollPane1 = new javax.swing.JScrollPane();
	}
	
	
	
	//Placement des composants dans les Layouts
	public void layouts() {
		JPanel contentPane= (JPanel) this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(jScrollPane1, BorderLayout.CENTER);
		
		jPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPane.add(jPanel2,BorderLayout.NORTH);
		jPanel2.add(jLabel1);
		jPanel2.add(jTextField1);
	}
	
	
	
	public static void main(String[] args) throws Exception{
		
		//Selection du LookAndFeel
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
				
		Fenetre fenetre=new Fenetre();
		fenetre.setVisible(true);
	}
}
