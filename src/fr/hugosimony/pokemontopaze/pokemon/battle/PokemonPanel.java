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
import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Main;

class PokemonPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private BufferedImage[] test;
	private int x = 0;
	
	public PokemonPanel(String gif) throws IOException {
		
		
        test = readGifImages(Main.class.getResourceAsStream(gif + ".gif"));
        int delay = getDelay(Main.class.getResourceAsStream(gif + ".gif"));
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				x++;
				if(x < test.length)
					repaint();
				else {
					x = 0;
					repaint();
				}
			}
		}, 0, delay * 10);
	}
	
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    g.drawImage(test[x], 0, 0, 300, 300, this);
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