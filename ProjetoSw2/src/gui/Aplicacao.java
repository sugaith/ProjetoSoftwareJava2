package gui;

import javax.swing.JFrame;

import gui.apresentacao.FramePrincipal;

public class Aplicacao {

	private static Aplicacao aplicacao;
	
	private Documento doc;
	
	public static Aplicacao getAplicacao() {
		if(aplicacao == null) {
			aplicacao = new Aplicacao();
		}
		return aplicacao;
	}
	
	public Documento getDocumentAtivo() {
		return doc;
	}
	
	private Aplicacao() {
		//look and feel
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				doc = new Documento();
				new FramePrincipal(doc).setVisible(true);
			}
		});
	}
	
	public static void main(String[] args) {
		Aplicacao.getAplicacao();
	}

}
