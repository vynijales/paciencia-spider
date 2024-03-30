package components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class SpriteSheet {
    private BufferedImage image;
    private String path;
    private int x;
    private int y;
    private int w;
    private int h;
    private int columns;
    private int rows;
    private int cell;

    public SpriteSheet(String path, int columns, int rows) {
        this.path = path;
        this.columns = columns;
        this.rows = rows;
        this.cell = 0;
        loadImage();
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setCell(int column, int row) {
        this.cell = column + row * columns;
    }

    public void loadImage() {
		try {
			image = ImageIO.read(new File(path));
		} catch (Exception e) {
			System.out.println("Erro ao carregar imagem");
		}

        w = image.getWidth() / columns;
        h = image.getHeight() / rows; 
	}

    public void draw(Graphics2D graphics2d) {
        int src_x = (cell % columns) * w;
        int src_y = (cell / columns) * h;

		graphics2d.drawImage(
            image, 
            x, y, x + w, y + h,
            src_x, src_y, src_x + w, src_y + h,
            null
        );
	}
}
