package fr.hugosimony.pokemontopaze.pokemon.battle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Main;
import fr.hugosimony.pokemontopaze.pokemon.Pokemon;

public class PokemonSprite extends JPanel {
	private static final long serialVersionUID = 1L;

	private BufferedImage[] images;
	private int x = 0;
	private ImageIcon img;
	private boolean back;
	
	public PokemonSprite(Pokemon pokemon, boolean back) throws IOException {
		
		String path = BattleConst.getAnimatedSprite(pokemon, back);
		images = readGifImages(Main.class.getResourceAsStream(path));
        int delay = getDelay(Main.class.getResourceAsStream(path));
		
        img = new ImageIcon(Main.class.getResource(path));
        this.back = back;
        
		setOpaque(false);
		setVisible(true);
		setSize((int) (img.getIconWidth()*1.5), (int) (img.getIconHeight()*1.5));
		setLocation(620 - (int) ((img.getIconWidth()*1.5) / 2), 210 - (int) (img.getIconHeight()*1.5));
		if(back) {
			setSize((int) (img.getIconWidth()*1.8), (int) (img.getIconHeight()*1.8));
			setLocation(160 - (int) ((img.getIconWidth()*1.8) / 2), 390 - (int) (img.getIconHeight()*1.8));
		}
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				if(isVisible()) {
					x++;
					if(x < images.length)
						repaint();
					else {
						x = 0;
						repaint();
					}
				}
				else
					this.cancel();
			}
		}, 0, delay * 10);
	}
	
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    if(back)
	    	g.drawImage(images[x], 0, 0, (int) (img.getIconWidth()*1.8), (int) (img.getIconHeight()*1.8), this);
	    else
	    	g.drawImage(images[x], 0, 0, (int) (img.getIconWidth()*1.5), (int) (img.getIconHeight()*1.5), this);
	}
	
	public static BufferedImage[] readGifImages(InputStream is) throws IOException{
		BufferedInputStream in=null;
		ImageInputStream stream = null;
		try {
			in=new BufferedInputStream(is);
		    stream = ImageIO.createImageInputStream(in);
		}catch (Exception e) {
			return null;
		}
		ImageReader r1 = getReader("GIF");
        if(r1==null)
			return null;
		ArrayList<BufferedImage> img = new ArrayList<BufferedImage>();
		try{            
			r1.setInput(stream,true,true);
			ImageReadParam param = r1.getDefaultReadParam();
			try{
				int j=0;
				while(true)
				{
					img.add(r1.read(j,param));
					j++;
				}
			}catch(Exception e2) {}
	    r1.dispose();
	    in.close();
		}catch(Exception e) {
			return  null;
		}
		return img.toArray(new BufferedImage[img.size()]);
	}
	
	private static int getDelay(InputStream is) throws IOException {
		ImageReader r2 = getReader("GIF");
		r2.setInput(ImageIO.createImageInputStream(is));
        IIOMetadata imageMetaData = r2.getImageMetadata(0);
        String metaFormatName = imageMetaData.getNativeMetadataFormatName();
        IIOMetadataNode root = (IIOMetadataNode)imageMetaData.getAsTree(metaFormatName);
        IIOMetadataNode graphicsControlExtensionNode = getNode(root, "GraphicControlExtension");
        int delay = Integer.parseInt(graphicsControlExtensionNode.getAttribute("delayTime"));
        r2.dispose();
        return delay;
	}

	@SuppressWarnings("rawtypes")
	private static ImageReader getReader(String format) {
	
		Iterator readers = ImageIO.getImageReadersBySuffix(format);
		if (readers.hasNext()) {
			ImageReader reader = (ImageReader) readers.next();
			return reader;
		}
		return null;
	}
	
	private static IIOMetadataNode getNode(IIOMetadataNode rootNode, String nodeName) {
		int nNodes = rootNode.getLength();
		for (int i = 0; i < nNodes; i++) {
			if(rootNode.item(i).getNodeName().compareToIgnoreCase(nodeName) == 0)
				return((IIOMetadataNode) rootNode.item(i));
		}
        IIOMetadataNode node = new IIOMetadataNode(nodeName);
        rootNode.appendChild(node);
        return(node);
	}
}