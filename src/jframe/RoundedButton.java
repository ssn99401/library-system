package jframe;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;



public class RoundedButton extends JButton {
	
	public RoundedButton() { 
		super(); 
		decorate();
		} 
	public RoundedButton(String text) { 
		super(text); 
		decorate();
		} 
	public RoundedButton(Action action) { 
		super(action);
		decorate();
		}
	public RoundedButton(Icon icon) {
		super(icon); 
		decorate();
		} 
	public RoundedButton(String text, Icon icon) { 
		super(text, icon); 
		decorate();
		}
	protected void decorate() { 
		setBorderPainted(false); 
		setOpaque(false); 
	}
	
	@Override 
	protected void paintComponent(Graphics g) { 
		int width = getWidth(); 
		int height = getHeight(); 
		Graphics2D graphics = (Graphics2D) g; 
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		if (getModel().isArmed()) { 
			graphics.setColor(getBackground().brighter()); 
			} else if (getModel().isRollover()) { 
				graphics.setColor(getBackground().darker()); 
				} else { 
					graphics.setColor(getBackground()); 
					}
		graphics.fillRoundRect(0, 0, width, height, 30, 30); 
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
		int textX = (width - stringBounds.width) / 2; int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
		graphics.setColor(getForeground()); 
		graphics.setFont(getFont()); 
		graphics.drawString(getText(), textX, textY); 
		graphics.dispose(); super.paintComponent(g); 
		}

}

class RoundedButton2 extends JButton {
	
	public RoundedButton2() { 
		super(); 
		decorate();
		} 
	public RoundedButton2(String text) { 
		super(text); 
		decorate();
		} 
	public RoundedButton2(Action action) { 
		super(action);
		decorate();
		}
	public RoundedButton2(Icon icon) {
		super(icon); 
		decorate();
		} 
	public RoundedButton2(String text, Icon icon) { 
		super(text, icon); 
		decorate();
		}
	protected void decorate() { 
		setBorderPainted(false); 
		setOpaque(false); 
	}
	
	@Override 
	protected void paintComponent(Graphics g) { 
		int width = getWidth(); 
		int height = getHeight(); 
		Graphics2D graphics = (Graphics2D) g; 
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		if (getModel().isArmed()) { 
			graphics.setColor(new Color(30, 174, 255)); 
			} else if (getModel().isRollover()) { 
				graphics.setColor(Color.white); 
				} else { 
					graphics.setColor(new Color(30, 174, 255)); 
					}
		graphics.fillRoundRect(0, 0, width, height, 13, 13); 
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
		int textX = (width - stringBounds.width) / 2; int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
		if (getModel().isArmed()) { 
			graphics.setColor(Color.white); 
			} else if (getModel().isRollover()) { 
				graphics.setColor(new Color(30, 174, 255)); 
				} else { 
					graphics.setColor(Color.white); 
					}
		//graphics.setColor(getForeground()); 
		graphics.setFont(getFont()); 
		graphics.drawString(getText(), textX, textY); 
		graphics.dispose(); super.paintComponent(g); 
		}

	
}	
	
	class RoundedButton3 extends JButton {
		
		public RoundedButton3() { 
			super(); 
			decorate();
			} 
		public RoundedButton3(String text) { 
			super(text); 
			decorate();
			} 
		public RoundedButton3(Action action) { 
			super(action);
			decorate();
			}
		public RoundedButton3(Icon icon) {
			super(icon); 
			decorate();
			} 
		public RoundedButton3(String text, Icon icon) { 
			super(text, icon); 
			decorate();
			}
		protected void decorate() { 
			setBorderPainted(false); 
			setOpaque(false); 
		}
		
		@Override 
		protected void paintComponent(Graphics g) { 
			int width = getWidth(); 
			int height = getHeight(); 
			Graphics2D graphics = (Graphics2D) g; 
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
			if (getModel().isArmed()) { 
				graphics.setColor(Color.LIGHT_GRAY); 
				} else if (getModel().isRollover()) { 
					graphics.setColor(Color.DARK_GRAY); 
					} else { 
						graphics.setColor(Color.LIGHT_GRAY); 
						}
			graphics.fillRoundRect(0, 0, width, height, 11, 11); 
			FontMetrics fontMetrics = graphics.getFontMetrics();
			Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
			int textX = (width - stringBounds.width) / 2; int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
			if (getModel().isArmed()) { 
				graphics.setColor(getBackground()); 
				} else if (getModel().isRollover()) { 
					graphics.setColor(Color.WHITE); 
					} else { 
						graphics.setColor(Color.DARK_GRAY); 
						}
			//graphics.setColor(getForeground()); 
			graphics.setFont(getFont()); 
			graphics.drawString(getText(), textX, textY); 
			graphics.dispose(); super.paintComponent(g); 
			}
		
	}
	
		class RoundedButton4 extends JButton {
			
			public RoundedButton4() { 
				super(); 
				decorate();
				} 
			public RoundedButton4(String text) { 
				super(text); 
				decorate();
				} 
			public RoundedButton4(Action action) { 
				super(action);
				decorate();
				}
			public RoundedButton4(Icon icon) {
				super(icon); 
				decorate();
				} 
			public RoundedButton4(String text, Icon icon) { 
				super(text, icon); 
				decorate();
				}
			protected void decorate() { 
				setBorderPainted(false); 
				setOpaque(false); 
			}
			
			@Override 
			protected void paintComponent(Graphics g) { 
				int width = getWidth(); 
				int height = getHeight(); 
				Graphics2D graphics = (Graphics2D) g; 
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
				graphics.setColor(Color.LIGHT_GRAY); 
				graphics.fillRoundRect(0, 0, width, height, 10, 10); 
				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
				int textX = (width - stringBounds.width) / 2; int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
				graphics.setColor(getForeground()); 
				graphics.setFont(getFont()); 
				graphics.drawString(getText(), textX, textY); 
				graphics.dispose(); super.paintComponent(g); 
				}
			
		}			
			
		class RoundedButton5 extends JButton {
			
			public RoundedButton5() { 
				super(); 
				decorate();
				} 
			public RoundedButton5(String text) { 
				super(text); 
				decorate();
				} 
			public RoundedButton5(Action action) { 
				super(action);
				decorate();
				}
			public RoundedButton5(Icon icon) {
				super(icon); 
				decorate();
				} 
			public RoundedButton5(String text, Icon icon) { 
				super(text, icon); 
				decorate();
				}
			protected void decorate() { 
				setBorderPainted(false); 
				setOpaque(false); 
			}
			
			@Override 
			protected void paintComponent(Graphics g) { 
				int width = getWidth(); 
				int height = getHeight(); 
				Graphics2D graphics = (Graphics2D) g; 
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
				if (getModel().isArmed()) { 
					graphics.setColor(Color.LIGHT_GRAY); 
					} else if (getModel().isRollover()) { 
						graphics.setColor(Color.WHITE); 
						} else { 
							graphics.setColor(Color.LIGHT_GRAY); 
							}
				graphics.fillRoundRect(0, 0, width, height, 11, 11); 
				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
				int textX = (width - stringBounds.width) / 2; int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
				if (getModel().isArmed()) { 
					graphics.setColor(getBackground()); 
					} else if (getModel().isRollover()) { 
						graphics.setColor(Color.DARK_GRAY); 
						} else { 
							graphics.setColor(Color.DARK_GRAY); 
							}
				//graphics.setColor(getForeground()); 
				graphics.setFont(getFont()); 
				graphics.drawString(getText(), textX, textY); 
				graphics.dispose(); super.paintComponent(g); 
				}
			
}
		
		class RoundedButton6 extends JButton {
			
			public RoundedButton6() { 
				super(); 
				decorate();
				} 
			public RoundedButton6(String text) { 
				super(text); 
				decorate();
				} 
			public RoundedButton6(Action action) { 
				super(action);
				decorate();
				}
			public RoundedButton6(Icon icon) {
				super(icon); 
				decorate();
				} 
			public RoundedButton6(String text, Icon icon) { 
				super(text, icon); 
				decorate();
				}
			protected void decorate() { 
				setBorderPainted(false); 
				setOpaque(false); 
			}
			
			@Override 
			protected void paintComponent(Graphics g) { 
				int width = getWidth(); 
				int height = getHeight(); 
				Graphics2D graphics = (Graphics2D) g; 
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
				if (getModel().isArmed()) { 
					graphics.setColor(getBackground().brighter()); 
					} else if (getModel().isRollover()) { 
						graphics.setColor(getBackground().darker()); 
						} else { 
							graphics.setColor(getBackground()); 
							}
				graphics.fillRoundRect(0, 0, width, height, 30, 30); 
				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
				int textX = (width - stringBounds.width) / 2; int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
				if (getModel().isArmed()) { 
					graphics.setColor(getBackground()); 
					} else if (getModel().isRollover()) { 
						graphics.setColor(Color.WHITE); 
						} else { 
							graphics.setColor(Color.DARK_GRAY); 
							}
				//graphics.setColor(getForeground()); 
				graphics.setFont(getFont()); 
				graphics.drawString(getText(), textX, textY); 
				graphics.dispose(); super.paintComponent(g); 
				}

		}
	
		class RoundedButton7 extends JButton {
			
			public RoundedButton7() { 
				super(); 
				decorate();
				} 
			public RoundedButton7(String text) { 
				super(text); 
				decorate();
				} 
			public RoundedButton7(Action action) { 
				super(action);
				decorate();
				}
			public RoundedButton7(Icon icon) {
				super(icon); 
				decorate();
				} 
			public RoundedButton7(String text, Icon icon) { 
				super(text, icon); 
				decorate();
				}
			protected void decorate() { 
				setBorderPainted(false); 
				setOpaque(false); 
			}
			
			@Override 
			protected void paintComponent(Graphics g) { 
				int width = getWidth(); 
				int height = getHeight(); 
				Graphics2D graphics = (Graphics2D) g; 
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
				if (getModel().isArmed()) { 
					graphics.setColor(getBackground().brighter()); 
					} else if (getModel().isRollover()) { 
						graphics.setColor(getBackground().darker()); 
						} else { 
							graphics.setColor(getBackground()); 
							}
				graphics.fillRoundRect(0, 0, width, height, 0, 0); 
				FontMetrics fontMetrics = graphics.getFontMetrics();
				Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
				int textX = (width - stringBounds.width) / 2; int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
				if (getModel().isArmed()) { 
					graphics.setColor(getBackground()); 
					} else if (getModel().isRollover()) { 
						graphics.setColor(Color.WHITE); 
						} else { 
							graphics.setColor(Color.DARK_GRAY); 
							}
				//graphics.setColor(getForeground()); 
				graphics.setFont(getFont()); 
				graphics.drawString(getText(), textX, textY); 
				graphics.dispose(); super.paintComponent(g); 
				}

		}
	

	