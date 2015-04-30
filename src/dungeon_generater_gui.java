import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class dungeon_generater_gui {

	private JFrame frame;
	private JSlider WorldWidthSlider;
	private JSlider WorldHeightSlider;
	private JLabel lblWorldPopulation;
	private JSlider CreatureSlider;
	private JTextArea MapDisplay;
	private Game main;
	public JButton btnGenerate;
	private Font mapFont = new Font("Rage Italic", Font.TRUETYPE_FONT, 12);

	public JSlider getWorldWidthSlider() {
		return WorldWidthSlider;
	}

	public void setWorldWidthSlider(JSlider worldWidthSlider) {
		WorldWidthSlider = worldWidthSlider;
	}

	public JSlider getWorldHeightSlider() {
		return WorldHeightSlider;
	}

	public void setWorldHeightSlider(JSlider worldHeightSlider) {
		WorldHeightSlider = worldHeightSlider;
	}
	public JButton getBtnGenerate() {
		return btnGenerate;
	}

	public void setBtnGenerate(JButton btnGenerate) {
		this.btnGenerate = btnGenerate;
	}
	public JSlider getCreatureSlider() {
		return CreatureSlider;
	}

	public void setCreatureSlider(JSlider creatureSlider) {
		CreatureSlider = creatureSlider;
	}
	public JTextArea getMapDisplay() {
		return MapDisplay;
	}

	public void setMapDisplay(JTextArea mapDisplay) {
		MapDisplay = mapDisplay;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dungeon_generater_gui window = new dungeon_generater_gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public dungeon_generater_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWorldHeight = new JLabel("World Height");
		lblWorldHeight.setBounds(12, 12, 112, 15);
		frame.getContentPane().add(lblWorldHeight);
		
		JLabel lblWorldWidth = new JLabel("World Width");
		lblWorldWidth.setBounds(12, 60, 112, 15);
		frame.getContentPane().add(lblWorldWidth);
		
		WorldHeightSlider = new JSlider();
		WorldHeightSlider.setBounds(12, 32, 112, 16);
		WorldHeightSlider.setMinimum(10);
		WorldHeightSlider.setMaximum(100);
		frame.getContentPane().add(WorldHeightSlider);
		
		WorldWidthSlider = new JSlider();
		WorldWidthSlider.setBounds(12, 78, 112, 16);
		WorldWidthSlider.setMinimum(10);
		WorldWidthSlider.setMaximum(100);
		frame.getContentPane().add(WorldWidthSlider);
		
		btnGenerate = new JButton("Generate!");
		btnGenerate.setBounds(12, 191, 112, 69);
		frame.getContentPane().add(btnGenerate);
		
		lblWorldPopulation = new JLabel("Creatures");
		lblWorldPopulation.setBounds(12, 106, 123, 15);
		frame.getContentPane().add(lblWorldPopulation);
		
		CreatureSlider = new JSlider();
		CreatureSlider.setBounds(12, 133, 112, 16);
		frame.getContentPane().add(CreatureSlider);
		
		MapDisplay = new JTextArea();
		MapDisplay.setBounds(142, 25, 600, 600);
		frame.getContentPane().add(MapDisplay);
		
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main = new Game(WorldWidthSlider.getValue(), 
						WorldHeightSlider.getValue(), CreatureSlider.getValue());
	            MapDisplay.setText(main.displayMap());
	            MapDisplay.setFont(mapFont);
	            }
		});
	}
}
